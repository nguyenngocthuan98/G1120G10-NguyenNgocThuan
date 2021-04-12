package com.customer.manager.controllers;

import com.customer.manager.models.Customer;
import com.customer.manager.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/listCustomer")
    public ResponseEntity<List<Customer>> listCustomer() {
        if (customerService.findAll().isEmpty()) {
            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Customer>>(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getCustomer")
    public ResponseEntity<Customer> getCustomer(@RequestParam long id) {
        if (customerService.findById(id) == null) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Customer>(customerService.findById(id), HttpStatus.OK);
        }
    }

    @PostMapping("/createCustomer")
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer, UriComponentsBuilder ucBuilder) {
        customerService.save(customer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ucBuilder.path("/customers/{id}").buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<Customer> updateCustomer(@RequestParam long id, @RequestBody Customer customer) {
        Customer currentCustomer = customerService.findById(id);
        if (currentCustomer == null) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        } else {
            currentCustomer.setId(customer.getId());
            currentCustomer.setFirstName(customer.getFirstName());
            currentCustomer.setLastName(customer.getLastName());

            customerService.save(currentCustomer);
            return new ResponseEntity<Customer>(currentCustomer, HttpStatus.OK);
        }
    }

    @DeleteMapping("/deleteCustomer")
    public ResponseEntity<Customer> deleteCustomer(@RequestParam long id) {
        if (customerService.findById(id) == null) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        } else {
            customerService.remove(id);
            return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
        }
    }
}
