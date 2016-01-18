package com.astraltear.mvcsuit.domain;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MessageConvertBean {
	
	@NotNull
	private String foo;

	@NotNull
	private String fruit;

	public MessageConvertBean() {
	}

	public MessageConvertBean(String foo, String fruit) {
		this.foo = foo;
		this.fruit = fruit;
	}

	public String getFoo() {
		return foo;
	}

	public void setFoo(String foo) {
		this.foo = foo;
	}

	public String getFruit() {
		return fruit;
	}

	public void setFruit(String fruit) {
		this.fruit = fruit;
	}
	
	@Override
	public String toString() {
		return "JavaBean {foo=[" + foo + "], fruit=[" + fruit + "]}";
	}
}
