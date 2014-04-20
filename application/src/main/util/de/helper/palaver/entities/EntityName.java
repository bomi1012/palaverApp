package de.helper.palaver.entities;



abstract public class EntityName extends Entity{

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
