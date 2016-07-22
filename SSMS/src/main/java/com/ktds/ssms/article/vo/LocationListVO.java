package com.ktds.ssms.article.vo;

import java.util.List;

public class LocationListVO extends LocationVO{
	private String id;
	private List<LocationVO> locationList;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<LocationVO> getLocationList() {
		return locationList;
	}
	public void setLocationList(List<LocationVO> locationList) {
		this.locationList = locationList;
	}
	
	
	
}
