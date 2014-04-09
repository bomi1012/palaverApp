package de.helper.palaver.entities;

import java.util.Date;


abstract public class EntityName extends Entity{

	protected String m_name;	
	public String getName() { return m_name; }
	public void setName(String name) { m_name = name; }

	public EntityName() {
		super();
	}

	public EntityName(long id, String name, Date createItem) {
		super(id, createItem);
		m_name = name;
	}
}
