package com.caqqi.carmais.veiculo.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class MarcaComModeloDto {

  @NotNull
  @NotBlank
  private String marca;

  @NotNull
  private List<String> modelos;

}

