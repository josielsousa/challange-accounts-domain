package br.com.caj.domain.usecase;

import javax.inject.Named;

import br.com.caj.domain.dataprovider.AccountProvider;
import br.com.caj.domain.entity.Account;
import br.com.caj.domain.usecase.exception.account.AccountException;
import br.com.caj.domain.usecase.exception.account.AccountExistingException;
import br.com.caj.domain.usecase.exception.account.AccountNotFoundException;

import java.io.Serializable;
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
    return accountProvider.getAllAccounts();
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
      throw new AccountNotFoundException("Account not found by uuid: " + uuid);
    }

    return account;
  }

  /**
   * Create a new account.
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

  /**
   * Update an existing account.
   * 
   * @param cpf
   * @return
   * @throws AccountNotFoundException
   */
  public Account update(Account account) throws AccountException, AccountNotFoundException{
    Account accountExisting = accountProvider.getAccount(account.getUuid());

    if (accountExisting == null) {
      throw new AccountNotFoundException("Account not found");
    }

    return accountProvider.update(account);
  }
}
