package br.com.caj.domain.usecase;

import javax.inject.Named;

import br.com.caj.domain.dataprovider.AccountProvider;
import br.com.caj.domain.dataprovider.TransferProvider;
import br.com.caj.domain.entity.Account;
import br.com.caj.domain.entity.Transfer;
import br.com.caj.domain.usecase.exception.transfer.TransferException;
import br.com.caj.domain.usecase.exception.transfer.TransferInsufficientBalanceException;
import br.com.caj.domain.usecase.exception.transfer.TransferNotFoundException;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * TransferUseCase - Implementation of use cases rules for transfers.
 */
@Named
public final class TransferUseCase implements Serializable {

  private static final long serialVersionUID = 8265836261131409966L;

  private final AccountProvider accountProvider;
  private final TransferProvider transferProvider;

  /**
   * Public constructor of this use case.
   * 
   * @param transferProvider
   * @param accountProvider
   */
  public TransferUseCase(@Named("transferDataProvider") TransferProvider transferProvider,
      @Named("accountDataProvider") AccountProvider accountProvider) {
    this.accountProvider = accountProvider;
    this.transferProvider = transferProvider;
  }

  /**
   * Get all transfers from provider.
   * 
   * @return
   * @throws TransferException
   */
  public Set<Transfer> getAllTransfers(String accountUuid) throws TransferException {
    return transferProvider.getAllTransfers(accountUuid);
  }

  /**
   * Create a new transfer.
   * 
   * @param transfer
   * @return
   * @throws TransferException
   * @throws TransferNotFoundException
   * @throws TransferInsufficientBalanceException
   */
  public Transfer create(Transfer transfer)
      throws TransferException, TransferNotFoundException, TransferInsufficientBalanceException {
    Account origin = accountProvider.getAccount(transfer.getAccountOriginUuiD());
    if (origin == null) {
      throw new TransferNotFoundException("Origin account not found");
    }

    Account destination = accountProvider.getAccount(transfer.getAccountDestinationUuiD());
    if (destination == null) {
      throw new TransferNotFoundException("Destination account not found");
    }

    if (origin.getBalance().compareTo(BigDecimal.ZERO) <= BigDecimal.ZERO.intValue()
        || origin.getBalance().compareTo(transfer.getAmount()) < BigDecimal.ZERO.intValue()) {
      throw new TransferInsufficientBalanceException("Origin account hasn't balance for this transfer");
    }

    Account newOrigin = origin.toBuilder().balance(origin.getBalance().subtract(transfer.getAmount())).build();
    accountProvider.update(newOrigin);

    Account newDestination = destination.toBuilder().balance(destination.getBalance().add(transfer.getAmount())).build();
    accountProvider.update(newDestination);

    return transferProvider.create(transfer);
  }
}
