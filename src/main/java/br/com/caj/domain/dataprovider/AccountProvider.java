package br.com.caj.domain.dataprovider;

import java.util.Set;
import br.com.caj.domain.entity.Account;
import br.com.caj.domain.usecase.exception.AccountException;
import br.com.caj.domain.usecase.exception.AccountExistingException;
import br.com.caj.domain.usecase.exception.AccountNotFoundException;

/**
 * AccountProvider - Interface to provide accounts manipulation.
 */
public interface AccountProvider {

  Set<Account> getAllAccounts() throws AccountException;

  Account getAccount(String uuid) throws AccountNotFoundException;

  Account getAccountByCPF(String cpf) throws AccountException;

  Account create(Account account) throws AccountException, AccountExistingException;

  Account update(Account account) throws AccountException;

}
