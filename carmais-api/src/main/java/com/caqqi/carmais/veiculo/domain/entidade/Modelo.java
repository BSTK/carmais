package com.caqqi.carmais.veiculo.domain.entidade;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Modelo extends Entidade {

  public static final String SQL_TODOS_MODELOS = "SELECT * FROM MODELO";

  @NotNull
  private Long marcaId;

  @NotNull
  @NotBlank
  @Size(min = 5, max = 100)
  private String nome;

  public Modelo() {}

  public Modelo(
    @NotNull Long marcaId,
    @NotNull
    @NotBlank
    @Size(min = 5, max = 100) String nome) {
    this.marcaId = marcaId;
    this.nome = nome;
  }

  public Long getMarcaId() {
    return marcaId;
  }

  public void setMarcaId(Long marcaId) {
    this.marcaId = marcaId;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public static Modelo rowMapper(ResultSet rs, int rowNum) throws SQLException {
    var modelo = new Modelo();
    modelo.setId(rs.getLong(ID));
    modelo.setMarcaId(rs.getLong("MARCA_ID"));
    modelo.setNome(rs.getString("NOME"));
    modelo.setDataInsert(rs.getDate(DATA_INSERT));
    modelo.setDataUpdate(rs.getDate(DATA_UPDATE));
    return modelo;
  }

}
