package com.mgmtp.internship.experiences.controllers.app;

import com.mgmtp.internship.experiences.model.tables.tables.Quote;
import com.mgmtp.internship.experiences.repositories.QuoteRepository;
import com.mgmtp.internship.experiences.services.PlaceService;
import com.mgmtp.internship.experiences.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class QuoteController {
    @Autowired
    private QuoteService quoteService;

    @RequestMapping(value = "/quote" , method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("quotedto", quoteService.findAll());
        //Randome one id quote and find quote
        long idQuote = quoteService.getRandomQuote();
        model.addAttribute("quote", quoteService.findById(idQuote));
        //get length list quote
        int listQuote = quoteService.findAll().size();
        model.addAttribute("listQuote", listQuote);
        return "quote";
    }
}
