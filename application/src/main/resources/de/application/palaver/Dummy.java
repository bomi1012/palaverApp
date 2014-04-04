package de.application.palaver;

import javax.faces.bean.ManagedBean;


@ManagedBean(name = "sayHallo")
public class Dummy {

	public String getValue() {
		return "Hallo Thomas!";
	}

}
