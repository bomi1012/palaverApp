package de.application.abstracts.entities;

import java.util.Date;

abstract public class EntityInfo extends EntityId {

	protected Date m_createItem;
	protected Date m_updateItem;
	protected boolean m_active;
	
	public EntityInfo() {
		super();
	}

	public EntityInfo(long id, Date createItem, Date updateItem, boolean active) {
		super();
		m_createItem = createItem;
		m_updateItem = updateItem;
		m_active = active;
	}
	
}
