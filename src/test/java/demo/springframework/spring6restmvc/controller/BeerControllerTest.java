package demo.springframework.spring6restmvc.controller;

import demo.springframework.spring6restmvc.model.Beer;
import demo.springframework.spring6restmvc.services.BeerService;
import demo.springframework.spring6restmvc.services.BeerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@SpringBootTest
@WebMvcTest(BeerController.class)
class BeerControllerTest {

    //@Autowired
    //BeerController beerController;

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    BeerService beerService;

    BeerServiceImpl beerServiceImpl = new BeerServiceImpl();


    @Test
    void testListBeers() throws Exception {
        given(beerService.listBeers()).willReturn(beerServiceImpl.listBeers());

        mockMvc.perform(get("/api/v1/beer")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                //tests if there are 3 objects
                .andExpect(jsonPath("$.length()", is(3)));
    }

    //Static imports and matchers are generally the hardest to get straight when starting with MockMvc
    //Ex: Intellij didn't autofill the hamcrest static import for "is"
    @Test
    void getBeerById() throws Exception {
        Beer testBeer = beerServiceImpl.listBeers().get(0);

        given(beerService.getBeerById(testBeer.getId())).willReturn(testBeer);

        mockMvc.perform(get("/api/v1/beer/" + testBeer.getId())
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                        .andExpect(jsonPath("$.id", is(testBeer.getId().toString())))
                        .andExpect(jsonPath("$.beerName", is(testBeer.getBeerName())));
    }
}