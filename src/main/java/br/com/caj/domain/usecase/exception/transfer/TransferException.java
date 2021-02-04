package br.com.caj.domain.usecase.exception.transfer;

/**
 * TransferException - Generic exception to manipulate transfers informations.
 */
public class TransferException extends RuntimeException {

  private static final long serialVersionUID = 5477065934894016341L;

  /**
   * Default constructor.
   */
  public TransferException() {

  }

  /**
   * Default constructor with message.
   * 
   * @param message
   */
  public TransferException(String message) {
    super(message);
  }

}
