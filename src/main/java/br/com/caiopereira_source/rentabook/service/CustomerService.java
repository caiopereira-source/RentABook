package br.com.caiopereira_source.rentabook.service;

import br.com.caiopereira_source.rentabook.dto.CityDto;
import br.com.caiopereira_source.rentabook.dto.CustomerDto;
import br.com.caiopereira_source.rentabook.exception.ResourceNotFoundException;
import br.com.caiopereira_source.rentabook.mapper.CustomModelMapper;
import br.com.caiopereira_source.rentabook.model.CityModel;
import br.com.caiopereira_source.rentabook.model.CustomerModel;
import br.com.caiopereira_source.rentabook.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public CustomerDto create(CustomerDto customerDto){
        CustomerModel customer = CustomModelMapper.parseObject(customerDto, CustomerModel.class);
        return CustomModelMapper.parseObject(repository.save(customer), CustomerDto.class);
    }

    public CustomerDto findById(long id){
        return CustomModelMapper.parseObject(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado!")), CustomerDto.class);
    }

    public CustomerDto update(CustomerDto customerDto){
        CustomerModel found = repository.findById(customerDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado!"));
        found.setFullName(customerDto.getFullName());
        found.setGender(customerDto.getGender());
        found.setBirthDate(customerDto.getBirthDate());
        found.setCity(CustomModelMapper.parseObject(customerDto.getCity(), CityModel.class));

        return CustomModelMapper.parseObject(repository.save(found), CustomerDto.class);
    }

    public void delete(long id){
        CustomerModel found = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado!"));
        repository.delete(found);

    }

    public List<CustomerDto> findAll(){
        return CustomModelMapper.parseObjectList(repository.findAll(), CustomerDto.class);
    }
}
