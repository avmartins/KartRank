package br.com.avmartins.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Exceção base de todas as outras exceções da aplicação
 *
 * @author Andeson Virginio Martins
 * @since 28/11/2016
 * @version 1.0.0
 *
 */
public class BaseException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor da classe
	 */
	public BaseException() {
		super();
	}

	/**
	 * Lança uma exceção base
	 *
	 * @param message Mensagem da exceção
	 */
	public BaseException(String message) {
		super(message);
	}

	/**
	 * Lança uma exceção base
	 *
	 * @param cause Causa da exceção
	 */
	public BaseException(Throwable cause) {
		super(cause);
	}

	/**
	 * Lança uma exceção base
	 *
	 * @param message Mensagem da exceção
	 * @param cause Causa da exceção
	 */
	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Converte a pilha de exceção em uma String
	 *
	 * @return String contendo a pilha de exceção
	 */
	public String getStackTraceAsString() {
		Writer result = new StringWriter();
		PrintWriter printWriter = new PrintWriter(result);
		printStackTrace(printWriter);
		return result.toString();
	}
}
