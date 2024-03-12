package com.spring.controller.common;

// ActionForward 가 필요없어짐!
public class ViewResolver {
	public String prefix;
	public String suffix;
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getView(String view) {
		return prefix+view+suffix;
	}
}
