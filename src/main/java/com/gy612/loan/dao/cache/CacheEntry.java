package com.gy612.loan.dao.cache;

import java.util.List;

public class CacheEntry<T> {
	private List<T> data;

	public CacheEntry(List<T> t) {
		data = t;
	}


	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}