package br.com.caiopereira_source.rentabook.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomExceptionResponse {

    private Date timeStamp;
    private String message;
    private String details;

}
