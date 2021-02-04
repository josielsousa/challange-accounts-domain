package br.com.caj.domain.usecase.exception.transfer;

/**
 * TransferInsufficientBalanceException - Generic exception to manipulate transfers informations.
 */
public class TransferInsufficientBalanceException extends RuntimeException {

  private static final long serialVersionUID = -1915394604874881486L;

  /**
   * Default constructor.
   */
  public TransferInsufficientBalanceException() {

  }

  /**
   * Default constructor with message.
   * 
   * @param message
   */
  public TransferInsufficientBalanceException(String message) {
    super(message);
  }

}
