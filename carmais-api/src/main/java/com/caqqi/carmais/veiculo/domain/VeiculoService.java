package com.caqqi.carmais.veiculo.domain;

import com.caqqi.carmais.veiculo.api.dto.MarcaComModeloDto;
import com.caqqi.carmais.veiculo.api.dto.MarcaDto;
import com.caqqi.carmais.veiculo.api.dto.ModeloDto;
import com.caqqi.carmais.veiculo.api.dto.VersaoDto;
import com.caqqi.carmais.veiculo.domain.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VeiculoService {

  private final VeiculoRepository veiculoRepository;

  @Autowired
  public VeiculoService(VeiculoRepository veiculoRepository) {
    this.veiculoRepository = veiculoRepository;
  }

  public List<MarcaDto> marcas() {
    final var marcasDto = new ArrayList<MarcaDto>();
    veiculoRepository
      .marcas()
      .forEach(marca -> marcasDto.add(new MarcaDto(marca.getNome())));

    return marcasDto;
  }

  public List<ModeloDto> modelos(final String marca) {
    final var modelosDto = new ArrayList<ModeloDto>();
    veiculoRepository
      .modelos(marca)
      .forEach(modelo ->
        modelosDto.add(
          new ModeloDto(
            modelo.getMarcaId(),
            modelo.getNome()
          )
        ));

    return modelosDto;
  }

  public List<VersaoDto> versoes() {
    final var versoesDto = new ArrayList<VersaoDto>();
    veiculoRepository
      .versoes()
      .forEach(versao -> versoesDto.add(
        new VersaoDto(
          versao.getModeloId(),
          versao.getDescricao()
        )
      ));

    return versoesDto;
  }

  public List<MarcaComModeloDto> marcasComModelos() {
    return veiculoRepository.marcasComModelos();
  }

}
