package com.ktds.ssms.mobile.service.impl;

import com.ktds.ssms.mobile.biz.MobileBiz;
import com.ktds.ssms.mobile.service.MobileService;
import com.ktds.ssms.mobile.vo.LocationLogVO;

public class MobileServiceImpl implements MobileService{

	private MobileBiz mobileBiz;
	
	public void setMobileBiz(MobileBiz mobileBiz) {
		this.mobileBiz = mobileBiz;
	}

	@Override
	public boolean registerLocation(LocationLogVO locationLogVO) {

		return mobileBiz.registerLocation(locationLogVO);
		
	}
	
}
