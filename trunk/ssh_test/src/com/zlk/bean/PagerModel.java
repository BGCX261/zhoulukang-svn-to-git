package com.zlk.bean;

import java.util.List;

public class PagerModel {
private int total;
private int offset;
private List list;

public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
public int getOffset() {
	return offset;
}
public void setOffset(int offset) {
	this.offset = offset;
}
public List getList() {
	return list;
}
public void setList(List list) {
	this.list = list;
}
}
