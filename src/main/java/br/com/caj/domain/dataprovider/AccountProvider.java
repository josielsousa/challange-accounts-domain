package br.com.caj.domain.dataprovider;

import java.util.Set;
import br.com.caj.domain.entity.Account;
import br.com.caj.domain.usecase.exception.AccountException;

/**
 * AccountProvider - Interface to provide accounts manipulation.
 */
public interface AccountProvider {
  Set<Account> getAllAccounts() throws AccountException;

  Account getAccount(String uuid) throws AccountException;

  Account create(Account account) throws AccountException;

  Account update(Account account) throws AccountException;

  Account getAccountByCPF(String cpf) throws AccountException;
}
