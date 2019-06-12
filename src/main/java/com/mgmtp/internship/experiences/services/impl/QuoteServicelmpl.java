package com.mgmtp.internship.experiences.services.impl;

import com.mgmtp.internship.experiences.dto.QuoteDTO;
import com.mgmtp.internship.experiences.model.tables.tables.Quote;
import com.mgmtp.internship.experiences.repositories.QuoteRepository;
import com.mgmtp.internship.experiences.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteServicelmpl implements QuoteService {
    @Autowired
    private QuoteRepository quoteRepository;
    @Override
   public List<QuoteDTO> findAll(){ return quoteRepository.findAll();}

    @Override
    public QuoteDTO findById(long id) {
        return quoteRepository.findById(id);
    }

    @Override
    public int update(QuoteDTO quote) {
        return quoteRepository.update(quote);
    }

    @Override
    public int delete(long quoteId) {
        return quoteRepository.delete(quoteId);
    }

    //random id quote
    @Override
    public long getRandomQuote(){return quoteRepository.getRandomQuote(findAll().size());}


}

