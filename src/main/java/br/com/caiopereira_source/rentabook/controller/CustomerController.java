package br.com.caiopereira_source.rentabook.controller;


import br.com.caiopereira_source.rentabook.dto.CustomerDto;
import br.com.caiopereira_source.rentabook.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public ResponseEntity<CustomerDto> create(@RequestBody CustomerDto customerDto){
        CustomerDto customer = service.create(customerDto);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findById(@PathVariable(name = "id") long id){
        CustomerDto customer = service.findById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> findAll(){
        var list = service.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(name = "id") long id){
        service.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customerDto){
        CustomerDto customer = service.update(customerDto);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
