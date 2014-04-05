package de.application.abstracts.DB.exceptions;

public class ConnectException extends Exception {
	private static final long serialVersionUID = 7869794587925682671L;
	public ConnectException(String message) {
		super(message);
	}
}
