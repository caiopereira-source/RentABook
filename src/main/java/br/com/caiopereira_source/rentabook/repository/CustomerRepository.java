package br.com.caiopereira_source.rentabook.repository;

import br.com.caiopereira_source.rentabook.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {
}
