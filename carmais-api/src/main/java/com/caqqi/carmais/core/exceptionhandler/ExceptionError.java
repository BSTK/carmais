package com.caqqi.carmais.core.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
class ExceptionError {

    private String mensagem;
    private String metodo;
    private String urlRequest;
    private LocalDateTime data;
    private List<ExceptionErrorItem> erros;

}
