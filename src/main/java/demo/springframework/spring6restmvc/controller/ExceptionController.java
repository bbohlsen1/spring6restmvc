package demo.springframework.spring6restmvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Global exception handler. Passes both customer and beer tests despite not being handled directly in the controllers
//Typically, when doing RESTful APIs we don't need a lot of complication. We mainly just want the HTTP status returned
//@ResponseStatus is simpler than a global exception handler
//Using @ResponseStatus you can define custom exception classes if you need to provide different status'

//@ControllerAdvice
public class ExceptionController {
   // @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException() {
        System.out.println("In exception handler");

        //alternative to the new method
        return  ResponseEntity.notFound().build();
    }
}
