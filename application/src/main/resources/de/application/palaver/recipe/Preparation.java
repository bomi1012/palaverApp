package de.application.palaver.recipe;

import java.io.Serializable;

import de.helper.palaver.entities.EntityName;


public class Preparation extends EntityName implements Serializable {
	private static final long serialVersionUID = -1776398426725392291L;

	public Preparation() {
		super();
	}

	public Preparation(long id, String name) {
		super(id, name);
	}
}
