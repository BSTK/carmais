package com.caqqi.carmais.veiculo.domain.service;

import com.caqqi.carmais.veiculo.domain.entidade.Marca;
import com.caqqi.carmais.veiculo.domain.entidade.Modelo;
import com.caqqi.carmais.veiculo.domain.entidade.Versao;
import com.caqqi.carmais.veiculo.domain.repository.VeiculoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.BDDMockito.given;

@Tag("Teste-Unitario")
class VeiculoServiceTest {

  @Mock
  private VeiculoRepository veiculoRepository;

  @InjectMocks
  private VeiculoService veiculoService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  @DisplayName("Deve retornar todas as Marcas")
  void deve_retornar_marcas() {
    final var marcas = List.of(
      new Marca("FIAT"),
      new Marca("TOYOTA")
    );

    given(veiculoRepository.marcas()).willReturn(marcas);

    final var resposta = veiculoService.marcas();

    Mockito.verify(veiculoRepository).marcas();

    Assertions.assertThat(resposta).isNotNull();
    Assertions.assertThat(resposta.size()).isEqualTo(marcas.size());
  }

  @Test
  @DisplayName("Deve retornar todos os Modelos")
  void deve_retornar_modelos() {
    final var modelos = List.of(
      new Modelo(1L, "DUCATO"),
      new Modelo(2L, "BELINA")
    );

    given(veiculoRepository.modelos()).willReturn(modelos);

    final var resposta = veiculoService.modelos(marca);

    Mockito.verify(veiculoRepository).modelos();

    Assertions.assertThat(resposta).isNotNull();
    Assertions.assertThat(resposta.size()).isEqualTo(modelos.size());
  }

  @Test
  @DisplayName("Deve retornar todas as Versões")
  void deve_retornar_versoes() {
    final var versoes = List.of(
      new Versao(1L, "1.0 MPI MILLE FIRE 8V FLEX 2P MANUAL"),
      new Versao(6L, "1.6 GLI 16V GASOLINA 4P AUTOMÁTIC")
    );

    given(veiculoRepository.versoes()).willReturn(versoes);

    final var resposta = veiculoService.versoes();

    Mockito.verify(veiculoRepository).versoes();

    Assertions.assertThat(resposta).isNotNull();
    Assertions.assertThat(resposta.size()).isEqualTo(versoes.size());
  }

}
