package demo.springframework.spring6restmvc.services;

import demo.springframework.spring6restmvc.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {

    List<Beer> listBeers();

    Beer getBeerById(UUID id);

    Beer saveNewBeer(Beer beer);

    void getBeerById(UUID beerId, Beer beer);

    void deleteById(UUID beerId);
}
