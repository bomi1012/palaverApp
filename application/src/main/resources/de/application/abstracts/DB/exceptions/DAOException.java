package de.application.abstracts.DB.exceptions;

@SuppressWarnings("serial")
public class DAOException extends Exception
{
	public DAOException(String msg)
	{
		super(msg);
	}
}