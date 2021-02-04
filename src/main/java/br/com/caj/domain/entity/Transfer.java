package br.com.caj.domain.entity;


import lombok.Getter;
import lombok.Builder;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * Transfer - Entity for manipulate transfer data.
 */
@Getter
@AllArgsConstructor
@Builder(toBuilder = true)
public final class Transfer implements Serializable {

  private static final long serialVersionUID = -3533365134045634301L;

  private String uuid;
  private String accountOriginUuid;
  private String accountDestinationUuid;
  private BigDecimal amount;
  private Instant createdAt;
  private Instant updatedAt;

}
