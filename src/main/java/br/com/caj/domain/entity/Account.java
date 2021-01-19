package br.com.caj.domain.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * Account - Entity for manipulate account data.
 */
@Getter
@Builder
@AllArgsConstructor
public final class Account implements Serializable {

  private static final long serialVersionUID = -1924730905309351346L;
  
  private String uuid;
  private String name;
  private String cpf;
  private String secret;
  private BigDecimal balance;
  private Instant createdAt;
  private Instant updatedAt;

}
