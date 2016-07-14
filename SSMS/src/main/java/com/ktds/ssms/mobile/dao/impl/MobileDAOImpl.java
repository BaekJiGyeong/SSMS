package com.ktds.ssms.mobile.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.ssms.mobile.dao.MobileDAO;
import com.ktds.ssms.mobile.vo.LocationLogVO;

public class MobileDAOImpl extends SqlSessionDaoSupport implements MobileDAO{

	@Override
	public boolean registerLocation(LocationLogVO locationLogVO) {
		
		System.out.println(locationLogVO.getLocationId());
		System.out.println(locationLogVO.getLocationLogId());
		System.out.println(locationLogVO.getMemberId());
		System.out.println(locationLogVO.getTime());
		
		
		return getSqlSession().insert("MobileDAO.registerLocation", locationLogVO) > 0;
	}

	@Override
	public String getLocationLogSeq() {
		return getSqlSession().selectOne("MobileDAO.getLocationLogSeq");
	}

}
