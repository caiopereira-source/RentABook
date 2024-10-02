package br.com.caiopereira_source.rentabook.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_name", length = 64, nullable = false)
    private String fullName;

    @Column(length = 1)
    private String gender;

    @Column(name = "birthdate")
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityModel city;

}
