package br.com.caj.domain.usecase.exception.transfer;

/**
 * TransferNotFoundException - Transfer exception to notify transfer not found.
 */
public class TransferNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -5285151506717312013L;

  /**
   * Default constructor.
   */
  public TransferNotFoundException() {

  }

  /**
   * Default constructor with message.
   * 
   * @param message
   */
  public TransferNotFoundException(final String message) {
    super(message);
  }

}
