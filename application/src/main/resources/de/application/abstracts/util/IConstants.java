package de.application.abstracts.util;

public interface IConstants {

	//DB
	String 		DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/test?user=root&password=root";
	String		DB_CONNECTION_FAILED = "Connection failed.";
	String		DB_CONNECTION_CLOSE_FAILAD = "Problem while closing connection.";
	String 		DB_STATEMENT_ERROR = "Statement error: %s caused by: %s";
	
}
