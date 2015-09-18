package com.azhuoinfo.cqurity.model;

import java.io.Serializable;

import mobi.cangol.mobile.parser.Element;

public class Rescouce implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 0L;
	private String id;
	private String name;

    public Rescouce(String id, String name) {
        this.id=id;
        this.name=name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
