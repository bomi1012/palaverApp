package de.application.palaver.article;

import de.helper.palaver.entities.EntityName;

public class Unit extends EntityName implements IUnit {
	
	public Unit() {
		super();
	}
	
	public Unit(long id, String name, String number) {
		super(id, name);
	}

	
}
