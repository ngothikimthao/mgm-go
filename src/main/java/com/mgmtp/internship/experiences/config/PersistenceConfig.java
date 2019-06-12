package com.mgmtp.internship.experiences.config;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class PersistenceConfig {

//    @Value("org.postgresql.Driver")
//    private String driver;
//
//    @Value("jdbc:postgresql://192.168.99.100:5432/mgmdb")
//    private String url;
//
//    @Value("${spring.datasource.username}")
//    private String username;
//
//    @Value("${spring.datasource.password}")
//    private String password;

    @Value("${spring.datasource.driver}")
    private String driver;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;
    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }


    /**
     * Return transaction manager
     *
     * @return
     */
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager getTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean(name = "transactionAwareDataSource")
    public TransactionAwareDataSourceProxy getTransactionAwareDataSource() {
        return new TransactionAwareDataSourceProxy(dataSource());
    }

    /**
     * Return connection provider
     *
     * @return
     */
    @Bean(name = "connectionProvider")
    public DataSourceConnectionProvider getConnectionProvider() {
        return new DataSourceConnectionProvider(getTransactionAwareDataSource());
    }

    /**
     * Return exception translator
     *
     * @return
     */
    @Bean(name = "jooqExceptionTranslator")
    public JOOQExceptionTranslator getJOOQExceptionTranslator() {
        return new JOOQExceptionTranslator();
    }

    /**
     * Returns the DSL context configuration
     *
     * @return
     */
    @Bean(name = "dslConfig")
    public org.jooq.Configuration getDslConfig() {
        DefaultConfiguration config = new DefaultConfiguration();
        config.setSQLDialect(SQLDialect.POSTGRES);
        config.setConnectionProvider(getConnectionProvider());
        DefaultExecuteListenerProvider listenerProvider = new DefaultExecuteListenerProvider(getJOOQExceptionTranslator());
        config.setExecuteListenerProvider(listenerProvider);
        return config;
    }

    /**
     * Return DSL context
     *
     * @return
     */
    @Bean(name = "dsl")
    public DSLContext getDsl() {
        org.jooq.Configuration config = this.getDslConfig();
        return new DefaultDSLContext(config);
    }
}
