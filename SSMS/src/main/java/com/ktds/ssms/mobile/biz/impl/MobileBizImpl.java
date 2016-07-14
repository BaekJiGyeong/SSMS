package com.ktds.ssms.mobile.biz.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.ktds.ssms.mobile.biz.MobileBiz;
import com.ktds.ssms.mobile.dao.MobileDAO;
import com.ktds.ssms.mobile.vo.LocationLogVO;

public class MobileBizImpl implements MobileBiz{

	private MobileDAO mobileDAO;
	
	public void setMobileDAO(MobileDAO mobileDAO) {
		this.mobileDAO = mobileDAO;
	}

	@Override
	public boolean registerLocation(LocationLogVO locationLogVO) {
		
		/* 현재 시간 */
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
		String nowTime = dateFormat.format(date);		
		locationLogVO.setTime(nowTime);
		
		/* log Id */		
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMdd");
		String idTime = dateFormat2.format(date);
		String locationLogSeq = mobileDAO.getLocationLogSeq();
		String logId = "LOC-" + idTime + "-" + lpad(locationLogSeq, 6, "0");
		locationLogVO.setLocationLogId(logId);
		
		return mobileDAO.registerLocation(locationLogVO);		
		
	}
	
	private String lpad(String source, int length, String defValue) {
		int sourceLength = source.length();
		int needLength = length - sourceLength;
		
		for (int i = 0; i < needLength; i++) {
			source = defValue + source;
		}
		return source;
	}
}
