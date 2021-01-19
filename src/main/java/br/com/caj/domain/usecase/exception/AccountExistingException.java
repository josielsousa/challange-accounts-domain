package br.com.caj.domain.usecase.exception;

/**
 * AccountExistingException - Account exception to notify account has exists.
 */
public class AccountExistingException extends RuntimeException {

  private static final long serialVersionUID = -6189595535549074905L;

  /**
   * Default constructor.
   */
  public AccountExistingException() {

  }

  /**
   * Default constructor with message.
   * 
   * @param message
   */
  public AccountExistingException(final String message) {
    super(message);
  }

}
