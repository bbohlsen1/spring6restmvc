package demo.springframework.spring6restmvc.controller;

import demo.springframework.spring6restmvc.model.Beer;
import demo.springframework.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@AllArgsConstructor //Automatically creates a constructor
@Slf4j //Logger
@Controller
public class BeerController {
    private final BeerService beerService;

    public Beer getBeerById(UUID id) {


            log.debug("Get beer by id");


        return beerService.getBeerById(id);
    }
}
