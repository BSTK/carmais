package com.caqqi.carmais.api;

import com.caqqi.carmais.veiculo.api.VeiculoController;
import com.caqqi.carmais.veiculo.api.dto.MarcaComModeloDto;
import com.caqqi.carmais.veiculo.api.dto.MarcaDto;
import com.caqqi.carmais.veiculo.api.dto.ModeloDto;
import com.caqqi.carmais.veiculo.api.dto.VersaoDto;
import com.caqqi.carmais.veiculo.domain.repository.VeiculoRepository;
import com.caqqi.carmais.veiculo.domain.service.VeiculoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Tag("Teste-Integracao")
@WebMvcTest(VeiculoController.class)
class VeiculoControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private VeiculoService veiculoService;

  @MockBean
  private VeiculoRepository veiculoRepository;

  @Test
  @DisplayName("Deve retornar todas as Marcas")
  void deveRetonarTodasAsMarcas() throws Exception {
    final var marcas = List.of(
      new MarcaDto("FIAT"),
      new MarcaDto("TOYOTA")
    );

    given(veiculoService.marcas()).willReturn(marcas);

    mvc.perform(
      get("/v1/veiculos/marcas")
        .accept(APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().contentType(APPLICATION_JSON))
      .andExpect(jsonPath("$.length()", equalTo(marcas.size())))
      .andExpect(jsonPath("$[0].nome", equalTo("FIAT")))
      .andExpect(jsonPath("$[1].nome", equalTo("TOYOTA")));
  }

  @Test
  @DisplayName("Deve retornar todas os Modelos")
  void deveRetonarTodosOsModelos() throws Exception {
    final var modelos = List.of(
      new ModeloDto(1L, "UNO"),
      new ModeloDto(4L, "COROLLA")
    );

    given(veiculoService.modelos(marca)).willReturn(modelos);

    mvc.perform(
      get("/v1/veiculos/modelos")
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().contentType(APPLICATION_JSON))
      .andExpect(jsonPath("$.length()", equalTo(modelos.size())))
      .andExpect(jsonPath("$[0].marcaId", equalTo(1)))
      .andExpect(jsonPath("$[0].nome", equalTo("UNO")))
      .andExpect(jsonPath("$[1].marcaId", equalTo(4)))
      .andExpect(jsonPath("$[1].nome", equalTo("COROLLA")));
  }

  @Test
  @DisplayName("Deve retornar todas as Versões")
  void deveRetonarTodasAsVersoes() throws Exception {
    final var versoes = List.of(
      new VersaoDto(1L, "1.0 MPI MILLE FIRE 8V FLEX 2P MANUAL"),
      new VersaoDto(6L, "1.6 GLI 16V GASOLINA 4P AUTOMÁTICO")
    );

    given(veiculoService.versoes()).willReturn(versoes);

    mvc.perform(
      get("/v1/veiculos/versoes")
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().contentType(APPLICATION_JSON))
      .andExpect(jsonPath("$[0].modeloId", equalTo(1)))
      .andExpect(jsonPath("$[0].descricao", equalTo("1.0 MPI MILLE FIRE 8V FLEX 2P MANUAL")))
      .andExpect(jsonPath("$[1].modeloId", equalTo(6)))
      .andExpect(jsonPath("$[1].descricao", equalTo("1.6 GLI 16V GASOLINA 4P AUTOMÁTICO")));
  }

  @Test
  @DisplayName("Deve retornar todas as marcas com seus modelos")
  void deveRetornarTodasasMarcasComSeusModelos() throws Exception {
    final var marcaComModelos = List.of(
        new MarcaComModeloDto("FIAT", List.of("UNO")),
        new MarcaComModeloDto("CHEVLOLET", List.of("")),
        new MarcaComModeloDto("FORD", List.of("BELINA", "ECOSPORT"))
    );

    given(veiculoRepository.marcasComModelos()).willReturn(marcaComModelos);

    mvc.perform(
        get("/v1/veiculos/marcas-modelos")
          .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(APPLICATION_JSON))
        .andExpect(jsonPath("$[0].marca", equalTo("FIAT")))
        .andExpect(jsonPath("$[0].modelos", contains("UNO")))
        .andExpect(jsonPath("$[1].marca", equalTo("CHEVLOLET")))
        .andExpect(jsonPath("$[2].marca", equalTo("FORD")))
        .andExpect(jsonPath("$[2].modelos", contains("BELINA", "ECOSPORT")));
  }
}
