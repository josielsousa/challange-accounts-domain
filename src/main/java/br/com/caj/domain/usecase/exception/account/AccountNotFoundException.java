package br.com.caj.domain.usecase.exception.account;

/**
 * AccountNotFoundException - Account exception to notify account not found.
 */
public class AccountNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -4310468742463228604L;

  /**
   * Default constructor.
   */
  public AccountNotFoundException() {

  }

  /**
   * Default constructor with message.
   * 
   * @param message
   */
  public AccountNotFoundException(final String message) {
    super(message);
  }

}
