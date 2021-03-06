package br.com.caj.domain.usecase.exception.account;

/**
 * AccountException - Generic exception to manipulate accounts informations.
 */
public class AccountException extends RuntimeException {

  private static final long serialVersionUID = -2696604476854706368L;

  /**
   * Default constructor.
   */
  public AccountException() {

  }

  /**
   * Default constructor with message.
   * 
   * @param message
   */
  public AccountException(String message) {
    super(message);
  }

}
