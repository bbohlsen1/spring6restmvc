package demo.springframework.spring6restmvc.controller;

import demo.springframework.spring6restmvc.model.Beer;
import demo.springframework.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor //Automatically creates a constructor
@Slf4j //Logger
@RestController //Combines Controller and ResponseBody so the return values are formatted to JSON/XML in the HTTP response body
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    //In this case RestController is used for API endpoints with less boilerplate
    //@Controller is for HTML or server-side rendering with a view template.
    //@RestController is for building RESTful APIs or when you need to return JSON responses directly
    @RequestMapping(method = RequestMethod.GET)
    public List<Beer> listBeers() {
        return beerService.listBeers();
    }

    //RequestMethod is used to specify HTTP method that a request mapping should respond to
    @RequestMapping(value = "{beerId}", method = RequestMethod.GET)
    public Beer getBeerById(@PathVariable("beerId") UUID beerId) {

            log.debug("Get beer by id");

        return beerService.getBeerById(beerId);
    }


}
