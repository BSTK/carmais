package com.caqqi.carmais.veiculo.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ModeloDto {

  @NotNull
  @JsonProperty("marcaId")
  private Long marcaId;

  @NotNull
  @NotBlank
  @JsonProperty("nome")
  private String nome;

}
