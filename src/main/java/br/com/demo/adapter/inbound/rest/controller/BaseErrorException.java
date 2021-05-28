package br.com.demo.adapter.inbound.rest.controller;

import java.sql.Timestamp;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BaseErrorException {
    private String type;
    private String title;
    private Integer status;
    private String instance;
    private Timestamp timestamp;

    public static BaseErrorException buildBaseError(Integer code, String type, String instance, String title) {
        return BaseErrorException.builder()
                .status(code)
                .type(type)
                .instance(instance)
                .timestamp(Timestamp.from(Instant.now()))
                .title(title)
                .build();
    }
}
