package br.com.caj.domain.entity;

import lombok.Data;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

/**
 * Account - Entity for manipulate account data.
 */
@Named
@Data
@AllArgsConstructor
public final class Account implements Serializable {

  private static final long serialVersionUID = -1924730905309351346L;
  
  private String uuid;
  private String name;
  private String cpf;
  private String secret;
  private BigDecimal balance;
  private LocalDateTime createdAt;

}
