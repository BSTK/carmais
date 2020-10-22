package com.caqqi.carmais.veiculo.domain.entidade;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Marca extends Entidade {

  public static final String SQL_TODAS_MARCAS = "SELECT * FROM MARCA";

  public static final String SQL_MARCA_COM_MODELOS =
    """
        SELECT          M.NOME  AS MARCA,
                        MM.NOME AS MODELO
        FROM            MARCA M
        LEFT JOIN       MODELO MM 
        ON              MM.MARCA_ID = M.ID
        ORDER BY        M.NOME;
    """;

  @NotNull
  @NotBlank
  @Size(min = 5, max = 100)
  private String nome;

  public Marca() { }

  public Marca(
    @NotNull
    @NotBlank
    @Size(min = 5, max = 100) String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public static Marca rowMapper(ResultSet rs, int index) throws SQLException {
    var marca = new Marca();
    marca.setId(rs.getLong(ID));
    marca.setNome(rs.getString("NOME"));
    marca.setDataInsert(rs.getDate(DATA_INSERT));
    marca.setDataUpdate(rs.getDate(DATA_UPDATE));
    return marca;
  }

}
