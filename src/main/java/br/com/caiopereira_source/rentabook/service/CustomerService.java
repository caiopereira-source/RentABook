package br.com.caiopereira_source.rentabook.service;

import br.com.caiopereira_source.rentabook.dto.CustomerDto;
import br.com.caiopereira_source.rentabook.mapper.CustomModelMapper;
import br.com.caiopereira_source.rentabook.model.CustomerModel;
import br.com.caiopereira_source.rentabook.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public CustomerDto create(CustomerDto customerDto){
        CustomerModel customer = CustomModelMapper.parseObject(customerDto, CustomerModel.class);
        return CustomModelMapper.parseObject(repository.save(customer), CustomerDto.class);
    }

}
