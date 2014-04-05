package de.application.abstracts.entities;

abstract public class EntityId {
	
	protected long m_id;
	public long getId() { return m_id; }
	public void setId(long id) { m_id = id; }
	
	public EntityId() {
		super();
	}
	
	public EntityId(long id) {
		super();
		m_id = id;
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
		if (!(obj instanceof EntityId))
			return false;
		EntityId other = (EntityId) obj;
		if (m_id != other.m_id)
			return false;
		return true;
	}
}
