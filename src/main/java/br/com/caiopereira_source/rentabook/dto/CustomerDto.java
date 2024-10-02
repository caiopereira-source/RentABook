package br.com.caiopereira_source.rentabook.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerDto {

    private long id;
    private String fullName;
    private String gender;
    private Date birthDate;
    private CityDto city;

}



