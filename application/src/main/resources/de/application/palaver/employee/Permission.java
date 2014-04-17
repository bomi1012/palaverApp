package de.application.palaver.employee;

import java.util.Date;

import de.helper.palaver.entities.EntityName;

public class Permission extends EntityName implements IPermission{

	public Permission() {
		super();
	}

	public Permission(long id, String name, Date createItem) {
		super(id, name, createItem);
	}


}
