package de.application.abstracts.entities;

abstract public class EntityName extends EntityId{

	protected String m_name;	
	public String getName() { return m_name; }
	public void setName(String name) { m_name = name; }

	public EntityName() {
		super();
	}

	public EntityName(long id, String name) {
		super(id);
		m_name = name;
	}
}
