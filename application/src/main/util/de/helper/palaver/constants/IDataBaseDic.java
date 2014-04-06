package de.helper.palaver.constants;


public interface IDataBaseDic {

	//Connection
	String 		DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/test?user=root&password=root";
	
	//Exceptions	
	String		DB_CONNECTION_FAILED = "ERROR: Connection failed.";
	String		DB_CONNECTION_CLOSE_FAILAD = "Problem while closing connection.";
	String 		DB_STATEMENT_ERROR = "Statement ERROR: %s caused by: %s";
	
}
