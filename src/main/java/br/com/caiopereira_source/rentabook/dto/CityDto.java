package br.com.caiopereira_source.rentabook.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CityDto {

    private long id;

    private String name;

    private String state;

    public String getFullName(){
        return name + "/" + state;
    }
}


