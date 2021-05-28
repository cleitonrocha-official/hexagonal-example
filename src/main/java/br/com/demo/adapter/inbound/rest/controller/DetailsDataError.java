package br.com.demo.adapter.inbound.rest.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DetailsDataError {
    private Integer code;
    private String field;
    private String message;

  
}
