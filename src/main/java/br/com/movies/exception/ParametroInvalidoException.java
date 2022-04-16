package br.com.movies.exception;

public class ParametroInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ParametroInvalidoException(String message, Throwable root) {
		super(message, root);
	}

	public ParametroInvalidoException(String message) {
		super(message);
	}
}
