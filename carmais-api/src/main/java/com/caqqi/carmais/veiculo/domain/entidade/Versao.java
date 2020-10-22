package com.caqqi.carmais.veiculo.domain.entidade;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Versao extends Entidade {

  public static final String SQL_TODAS_VERSOES = "SELECT * FROM VERSAO";

  @NotNull
  private Long modeloId;

  @NotNull
  @NotBlank
  @Size(min = 5, max = 150)
  private String descricao;

  public Versao() {}

  public Versao(
    @NotNull Long modeloId,
    @NotNull
    @NotBlank
    @Size(min = 5, max = 150) String descricao) {
    this.modeloId = modeloId;
    this.descricao = descricao;
  }

  public Long getModeloId() {
    return modeloId;
  }

  public void setModeloId(Long modeloId) {
    this.modeloId = modeloId;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public static Versao rowMapper(ResultSet rs, int rowNum) throws SQLException {
    var versao = new Versao();
    versao.setId(rs.getLong(ID));
    versao.setModeloId(rs.getLong("MODELO_ID"));
    versao.setDescricao(rs.getString("DESCRICAO"));
    versao.setDataInsert(rs.getDate(DATA_INSERT));
    versao.setDataUpdate(rs.getDate(DATA_UPDATE));
    return versao;
  }

}
