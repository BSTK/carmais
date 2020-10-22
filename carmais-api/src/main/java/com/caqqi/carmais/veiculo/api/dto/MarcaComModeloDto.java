package com.caqqi.carmais.veiculo.api.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@RequiredArgsConstructor
public class MarcaComModeloDto {

  @NotNull
  @NotBlank
  private final String marca;

  @NotNull
  private final List<String> modelos;

}
