package com.caqqi.carmais.veiculo.api;

import com.caqqi.carmais.veiculo.api.dto.MarcaComModeloDto;
import com.caqqi.carmais.veiculo.api.dto.MarcaDto;
import com.caqqi.carmais.veiculo.api.dto.ModeloDto;
import com.caqqi.carmais.veiculo.api.dto.VersaoDto;
import com.caqqi.carmais.veiculo.domain.VeiculoRepository;
import com.caqqi.carmais.veiculo.domain.VeiculoService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/veiculos")
public class VeiculoController {

  private final VeiculoService veiculoService;
  private final VeiculoRepository veiculoRepository;

  @Autowired
  public VeiculoController(final VeiculoService veiculoService,
                           final VeiculoRepository veiculoRepository) {
    this.veiculoService = veiculoService;
    this.veiculoRepository = veiculoRepository;
  }

  @GetMapping("/marcas")
  public ResponseEntity<List<MarcaDto>> marcas() {
    final var marcas = veiculoService.marcas();
    return CollectionUtils.isNotEmpty(marcas)
        ? ResponseEntity.ok(marcas)
        : ResponseEntity.noContent().build();
  }

  @GetMapping("/modelos")
  public ResponseEntity<List<ModeloDto>> modelos(final @RequestParam("marca") String marca) {
    final var modelos = veiculoService.modelos(marca);
    return CollectionUtils.isNotEmpty(modelos)
        ? ResponseEntity.ok(modelos)
        : ResponseEntity.noContent().build();
  }

  @GetMapping("/marcas-modelos")
  public ResponseEntity<List<MarcaComModeloDto>> marcasComModelos() {
    final var marcasComModelos = veiculoRepository.marcasComModelos();
    return CollectionUtils.isNotEmpty(marcasComModelos)
      ? ResponseEntity.ok(marcasComModelos)
      : ResponseEntity.noContent().build();
  }

  @GetMapping("/versoes")
  public ResponseEntity<List<VersaoDto>> versoes() {
    final var versoes = veiculoService.versoes();
    return CollectionUtils.isNotEmpty(versoes)
        ? ResponseEntity.ok(versoes)
        : ResponseEntity.noContent().build();
  }

}
