package br.com.caj.domain.usecase;

import javax.inject.Named;

import br.com.caj.domain.dataprovider.AccountProvider;
import br.com.caj.domain.entity.Account;
import br.com.caj.domain.usecase.exception.AccountException;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * AccountUseCase - Implementation of use cases rules for accounts.
 */
@Named
public final class AccountUseCase implements Serializable {

  private static final long serialVersionUID = -205614121429886644L;

  private final AccountProvider accountProvider;

  /**
   * Public constructor of this use case.
   * 
   * @param accountProvider
   */
  public AccountUseCase(AccountProvider accountProvider) {
    this.accountProvider = accountProvider;
  }

  /**
   * Get all accounts from provider.
   * 
   * @return
   * @throws AccountException
   */
  public Set<Account> getAllAccounts() throws AccountException {
    Set<Account> accounts = new HashSet<Account>();

    if (accountProvider != null) {
      accounts = accountProvider.getAllAccounts();
    }

    return accounts;
  }
}