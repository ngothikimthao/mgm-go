package com.mgmtp.internship.experiences.repositories;

import com.mgmtp.internship.experiences.dto.QuoteDTO;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.lang.Math;

import static com.mgmtp.internship.experiences.model.tables.tables.Quote.QUOTE;

@Component
public class QuoteRepository {

    @Autowired
    private DSLContext dslContext;

    public List<QuoteDTO> findAll() {
        return dslContext.selectFrom(QUOTE)
                .orderBy(QUOTE.ID)
                .fetch().stream()
                .map(quoteRecord -> new QuoteDTO(quoteRecord.getId(), quoteRecord.getContent()))
                .collect(Collectors.toList());
    }

    public QuoteDTO findById(long id) {
        return dslContext.selectFrom(QUOTE)
                .where(QUOTE.ID.eq(id))
                .fetchOneInto(QuoteDTO.class);
    }

    public int update(QuoteDTO QuoteDTO) {
        return dslContext.update(QUOTE)
                .set(QUOTE.CONTENT, QuoteDTO.getContent())
                .where(QUOTE.ID.eq(QuoteDTO.getId()))
                .execute();
    }

    public int delete(long quoteId){
        return dslContext.delete(QUOTE)
                .where(QUOTE.ID.eq(quoteId))
                .execute();
    }
    public static long getRandomQuote(long maximum){
        return ((long) (Math.random()*(maximum - 1))) + 1;
    }

}
