package com.mgmtp.internship.experiences.services;

import com.mgmtp.internship.experiences.dto.QuoteDTO;
import com.mgmtp.internship.experiences.model.tables.tables.Quote;

import java.util.List;

public interface QuoteService {
    List<QuoteDTO> findAll();

    QuoteDTO findById(long id);

    int update(QuoteDTO quote);

    int delete(long quoteId);
    long getRandomQuote();
}
