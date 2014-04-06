package de.application.abstracts.entities;

import java.util.Date;


abstract public class EntityName extends EntityInfo{

	protected String m_name;	
	public String getName() { return m_name; }
	public void setName(String name) { m_name = name; }

	public EntityName() {
		super();
	}

	public EntityName(long id, String name, Date createItem, Date updateItem, boolean active) {
		super(id, createItem, active);
		m_name = name;
	}
}
