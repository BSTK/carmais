package com.caqqi.carmais.veiculo.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class VersaoDto {

  @NotNull
  private Long modeloId;

  @NotNull
  @NotBlank
  private String descricao;

}
