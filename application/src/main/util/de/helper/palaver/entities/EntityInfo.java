package de.helper.palaver.entities;

import java.util.Date;

abstract public class EntityInfo extends EntityId {

	protected Date m_createItem;
	protected boolean m_active;
	
	public EntityInfo() {
		super();
	}

	public EntityInfo(long id, Date createItem, boolean active) {
		super();
		m_createItem = createItem;
		m_active = active;
	}
	
}
