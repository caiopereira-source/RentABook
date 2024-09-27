package br.com.caiopereira_source.rentabook.service;

import java.util.List;

import br.com.caiopereira_source.rentabook.dto.CityDto;
import br.com.caiopereira_source.rentabook.exception.ResourceNotFoundException;
import br.com.caiopereira_source.rentabook.mapper.CustomModelMapper;
import br.com.caiopereira_source.rentabook.model.CityModel;
import br.com.caiopereira_source.rentabook.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public CityDto create(CityDto cityDto){

        CityModel city = CustomModelMapper.parseObject(cityDto, CityModel.class);
        return CustomModelMapper.parseObject(repository.save(city), CityDto.class);
    }

    public CityDto findById(long id){

        //return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cidade não encontrada!"));
        return CustomModelMapper.parseObject(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cidade não encontrada!")), CityDto.class);
    }

    public CityDto update(CityDto cityDto){
        CityModel found = repository.findById(cityDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Cidade não encontrada!"));
        found.setName(cityDto.getName());
        found.setState(cityDto.getState());
        //return repository.save(found);
        return CustomModelMapper.parseObject(repository.save(found), CityDto.class);
    }

    public void delete(long id){
        CityModel found = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cidade não encontrada!"));
        repository.delete(found);
    }

    public List<CityDto> findAll(){
        //return repository.findAll();
        return CustomModelMapper.parseObjectList(repository.findAll(), CityDto.class);
    }

    public List<CityDto> findByName(String name){
        List<CityModel> cities = repository.findByNameContainsIgnoreCaseOrderByName(name);
        return CustomModelMapper.parseObjectList(cities, CityDto.class);
    }

    public List<CityDto> findByState(String state){
        List<CityModel> cities = repository.findByStateEqualsIgnoreCaseOrderByStateAscNameAsc(state);
        return CustomModelMapper.parseObjectList(cities, CityDto.class);
    }


}
