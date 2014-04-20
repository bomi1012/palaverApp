package de.application.palaver.employee;

import de.helper.palaver.entities.EntityName;

public class Permission extends EntityName implements IPermission{

	public Permission() {
		super();
	}

	public Permission(long id, String name) {
		super(id, name);
	}


}
