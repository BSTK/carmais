package com.caqqi.carmais.veiculo.api.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
public class VersaoDto {

  @NotNull
  private final Long modeloId;

  @NotNull
  @NotBlank
  private final String descricao;

}
