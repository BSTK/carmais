package com.caqqi.carmais.veiculo.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public record ModeloDto(
  @NotNull
  @JsonProperty("marcaId")
  Long marcaId,

  @NotNull
  @NotBlank
  @JsonProperty("nome")
  String nome) implements Serializable {
}
