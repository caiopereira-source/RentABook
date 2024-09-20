package br.com.caiopereira_source.rentabook.service;

import java.util.List;
import br.com.caiopereira_source.rentabook.exception.ResourceNotFoundException;
import br.com.caiopereira_source.rentabook.model.CityModel;
import br.com.caiopereira_source.rentabook.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public CityModel create(CityModel cityModel){
        return repository.save(cityModel);
    }

    public CityModel findById(long id){
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cidade não encontrada!"));
    }

    public CityModel update(CityModel cityModel){
        CityModel found = repository.findById(cityModel.getId()).orElseThrow(() -> new ResourceNotFoundException("Cidade não encontrada!"));
        found.setName(cityModel.getName());
        found.setState(cityModel.getState());
        return repository.save(found);
    }

    public void delete(long id){
        CityModel found = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cidade não encontrada!"));
        repository.delete(found);
    }

    public List<CityModel> findAll(){
        return repository.findAll();
    }


}
