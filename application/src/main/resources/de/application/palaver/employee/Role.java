package de.application.palaver.employee;

import java.util.Date;

import de.helper.palaver.entities.EntityName;

public class Role extends EntityName implements IRole{

	private String m_description;
	@Override
	public String getDescription() { return m_description; }
	@Override
	public void setDescription(String description) { m_description = description; }
	
	public Role() {
		super();
	}

	public Role(long id, String name, String description, Date createItem) {
		super(id, name, createItem);
		m_description = description;
	}


}
