package br.com.caj.domain.dataprovider;

import java.util.Set;
import br.com.caj.domain.entity.Account;
import br.com.caj.domain.usecase.exception.account.AccountException;
import br.com.caj.domain.usecase.exception.account.AccountExistingException;

/**
 * AccountProvider - Interface to provide accounts manipulation.
 */
public interface AccountProvider {

  Set<Account> getAllAccounts();

  Account getAccount(String uuid);

  Account getAccountByCPF(String cpf);

  Account create(Account account) throws AccountException, AccountExistingException;

  Account update(Account account) throws AccountException;

}
