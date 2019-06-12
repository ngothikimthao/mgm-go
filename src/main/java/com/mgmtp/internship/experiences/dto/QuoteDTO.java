package com.mgmtp.internship.experiences.dto;

import com.mgmtp.internship.experiences.model.tables.tables.Quote;

public class QuoteDTO {
    private long id;
    private String content;

   public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public QuoteDTO(long id, String content) {
        this.id = id;
        this.content = content;
    }
}
