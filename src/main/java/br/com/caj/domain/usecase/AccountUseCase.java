package br.com.caj.domain.usecase;

import javax.inject.Named;

import br.com.caj.domain.dataprovider.AccountProvider;
import br.com.caj.domain.entity.Account;
import br.com.caj.domain.usecase.exception.AccountException;
import br.com.caj.domain.usecase.exception.AccountExistingException;
import br.com.caj.domain.usecase.exception.AccountNotFoundException;

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
  public AccountUseCase(@Named("accountDataProvider") AccountProvider accountProvider) {
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

  /**
   * Returns an account by uuid.
   * 
   * @param uuid
   * @return
   * @throws AccountNotFoundException
   */
  public Account getAccount(final String uuid) throws AccountNotFoundException {
    Account account = null;

    if (accountProvider != null && uuid != null && !uuid.isBlank()) {
      account = accountProvider.getAccount(uuid);
    }

    if (account == null) {
      throw new AccountNotFoundException("Account not found");
    }

    return account;
  }

  /**
   * Returns an account by CPF.
   * 
   * @param cpf
   * @return
   * @throws AccountNotFoundException
   */
  public Account create(Account account) throws AccountException, AccountExistingException {
    Account accountExisting = accountProvider.getAccountByCPF(account.getCpf());

    if (accountExisting != null) {
      throw new AccountExistingException("Account has exists for this CPF.");
    }

    return accountProvider.create(account);
  }
}
