package br.com.avmartins.exception;

/**
 * Exceção Corrida da aplicação
 *
 * @author Andeson Virginio Martins
 * @since 28/11/2016
 * @version 1.0.0
 *
 */
public class RankingException extends BaseException {
	
	private static final long serialVersionUID = 1L;

	public RankingException() {
	}

	public RankingException(String message) {
		super(message);
	}

	public RankingException(Throwable cause) {
		super(cause);
	}

	public RankingException(String message, Throwable cause) {
		super(message, cause);
	}

}
