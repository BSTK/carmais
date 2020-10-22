package com.caqqi.carmais.veiculo.domain.entidade;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public abstract class Entidade implements Serializable {

  protected static final String ID = "ID";
  protected static final String DATA_INSERT = "DATA_INSERT";
  protected static final String DATA_UPDATE = "DATA_UPDATE";

  protected Long id;

  @NotNull
  protected Date dataInsert;

  @NotNull
  protected Date dataUpdate;

  public Entidade() {
    setDataInsert(new Date());
    setDataUpdate(new Date());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getDataInsert() {
    return dataInsert;
  }

  public void setDataInsert(Date dataInsert) {
    this.dataInsert = dataInsert;
  }

  public Date getDataUpdate() {
    return dataUpdate;
  }

  public void setDataUpdate(Date dataUpdate) {
    this.dataUpdate = dataUpdate;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, JSON_STYLE);
  }

  @Override
  public boolean equals(Object object) {
    return EqualsBuilder.reflectionEquals(this, object, true);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataInsert, dataUpdate);
  }
}
