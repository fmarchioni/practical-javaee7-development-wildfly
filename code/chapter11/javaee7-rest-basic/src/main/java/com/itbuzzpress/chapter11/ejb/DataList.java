package com.itbuzzpress.chapter11.ejb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
 
import javax.ejb.Singleton;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.itbuzzpress.chapter11.model.SimpleProperty;

@Singleton
@Named
public class DataList implements Serializable {
	private List<SimpleProperty> list;

	@PostConstruct
	public void init() {
		list = new ArrayList<SimpleProperty>();

	}
	public List<SimpleProperty> getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	public int addToList(String key, String value) {
		list.add(new SimpleProperty(key,value));
		return list.size();
	}

}
