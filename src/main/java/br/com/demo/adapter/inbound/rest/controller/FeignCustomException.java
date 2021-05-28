package br.com.demo.adapter.inbound.rest.controller;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeignCustomException extends BaseErrorException {

    public String message;

    public Integer code;
    
    private List<DetailsDataError> details;

    public FeignCustomException(BaseErrorException baseError, List<DetailsDataError> details)
    {
        this.setInstance(baseError.getInstance());
        this.setStatus(baseError.getStatus());
        this.setType(baseError.getType());
        this.setTimestamp(baseError.getTimestamp());
        this.setTitle(baseError.getTitle());
        this.details = details;
    }

    public FeignCustomException(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
