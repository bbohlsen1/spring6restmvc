package demo.springframework.spring6restmvc.controller;

import demo.springframework.spring6restmvc.entities.Customer;
import demo.springframework.spring6restmvc.model.CustomerDTO;
import demo.springframework.spring6restmvc.repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerControllerTestIT {

    @Autowired
    CustomerController customerController;

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void testIdNotFound() {
        assertThrows(NotFoundException.class, () -> {
            customerController.getCustomer(UUID.randomUUID());
        });
    }

    @Transactional
    @Rollback
    @Test
    void testEmptyList() {
        customerRepository.deleteAll();
        List<CustomerDTO> dtos = customerController.listCustomers();

        assertThat(dtos.size()).isEqualTo(0);
    }

    @Test
    void testListAll() {
        List<CustomerDTO> dtos = customerController.listCustomers();

        assertThat(dtos.size()).isEqualTo(3);
    }

    @Test
    void testGetById() {
        Customer customer = customerRepository.findAll().get(0);
        CustomerDTO dto = customerController.getCustomer(customer.getId());
        assertThat(dto).isNotNull();
    }
}