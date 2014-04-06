package de.helper;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import de.helper.palaver.constants.IViewDic;

@ManagedBean(name = "dic")
@ApplicationScoped
public class Dictionary implements IViewDic{

	public String getCafePalaver() { return VIEW_CAFE_PALAVER; }	
	
	public Dictionary() {
		super();
	}
}
