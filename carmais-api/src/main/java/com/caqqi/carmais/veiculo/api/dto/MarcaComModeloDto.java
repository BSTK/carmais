package com.caqqi.carmais.veiculo.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public record MarcaComModeloDto(
  @NotNull
  @NotBlank
  @JsonProperty("marca")
  String marca,

  @NotNull
  @JsonProperty("modelos")
  List<String>modelos) {

}
