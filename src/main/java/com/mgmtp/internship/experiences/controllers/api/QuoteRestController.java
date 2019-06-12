package com.mgmtp.internship.experiences.controllers.api;

import com.mgmtp.internship.experiences.dto.QuoteDTO;
import com.mgmtp.internship.experiences.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/quote")
public class QuoteRestController extends BaseRestController{
    @Autowired
    private QuoteService quoteService;
    @GetMapping()
    public List<QuoteDTO> all(){return  quoteService.findAll();}

}
