package com.caqqi.carmais.veiculo.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
public class ModeloDto {

  @NotNull
  @JsonProperty("marcaId")
  private final Long marcaId;

  @NotNull
  @NotBlank
  @JsonProperty("nome")
  private final String nome;

}
