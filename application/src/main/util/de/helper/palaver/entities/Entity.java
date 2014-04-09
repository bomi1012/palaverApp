package de.helper.palaver.entities;

import java.util.Date;

abstract public class Entity {
	
	protected long m_id;
	public long getId() { return m_id; }
	public void setId(long id) { m_id = id; }
	
	protected Date m_createDate;
	public Date getCreateDate() { return m_createDate; }
	public void setCreateDate(Date createDate) { m_createDate = createDate; }
	
	public Entity() {
		super();
	}
	
	public Entity(long id, Date createDate) {
		super();
		m_id = id;
		m_createDate = createDate;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (m_id ^ (m_id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Entity))
			return false;
		Entity other = (Entity) obj;
		if (m_id != other.m_id)
			return false;
		return true;
	}
}
