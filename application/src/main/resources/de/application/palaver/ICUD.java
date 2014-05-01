package de.application.palaver;

import de.helper.palaver.exceptions.ConnectException;
import de.helper.palaver.exceptions.DAOException;

public interface ICUD {
	long create(Object o) throws ConnectException, DAOException;
	void update(Object o);
	void delete(Object o);
}
