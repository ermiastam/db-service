package com.ermias.stock.dbservice.resource;

import com.ermias.stock.dbservice.model.Quote;
import com.ermias.stock.dbservice.model.Quotes;
import com.ermias.stock.dbservice.repository.QuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

    private QuotesRepository quotesRepository;

    @Autowired
    public DbServiceResource(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }

    @GetMapping("/{userName}")
    public List<String> getQuotes(@PathVariable("userName") final String userName){
      return findByUserName(userName);


    }

    private List<String> findByUserName(@PathVariable("userName") String userName) {
        return quotesRepository.findByUserName(userName)
          .stream()
          .map(Quote::getQuote)
          .collect(Collectors.toList());
    }

    @PostMapping("/add") //in Postman add {"username": "ermias", "quotes": ["GOOG"]} "GOOG" is a symbol used for Google in YahooFinance
    public List<String> addQuotes(@RequestBody Quotes quotes){

       quotes.getQuotes()
               .stream()
               .map(quote -> new Quote(quotes.getUserName(),quote))
               .forEach(quote -> quotesRepository.save(quote));

         String userName = quotes.getUserName();


        return findByUserName(userName);
    }


    @DeleteMapping("/delete/{userName}")
    public List<String> deleteQuotes(@PathVariable("userName")String userName){

     List<Quote> quotes = quotesRepository.findByUserName(userName);
     quotesRepository.deleteAll(quotes);


        return findByUserName(userName);//should return nothing
    }

    @GetMapping("/hello")
    public String getstr(){

        return "HI";
    }





}
