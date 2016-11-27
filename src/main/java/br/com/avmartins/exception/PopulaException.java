package br.com.avmartins.exception;

/**
 * Exceção Popular da aplicação
 *
 * @author Andeson Virginio Martins
 * @since 28/11/2016
 * @version 1.0.0
 *
 */

public class PopulaException extends BaseException {
	private static final long serialVersionUID = 1L;

	public PopulaException() {
		super();
	}

	public PopulaException(String message) {
		super(message);
	}

	public PopulaException(Throwable cause) {
		super(cause);
	}

	public PopulaException(String message, Throwable cause) {
		super(message, cause);
	}

}
