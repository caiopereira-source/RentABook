package br.com.caiopereira_source.rentabook.repository;

import br.com.caiopereira_source.rentabook.model.CityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<CityModel, Long> {

    public List<CityModel> findByNameContainsIgnoreCaseOrderByName(String name);
    public List<CityModel> findByStateEqualsIgnoreCaseOrderByStateAscNameAsc(String state);
}
