package com.ktds.ssms.mobile.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.ssms.mobile.dao.MobileDAO;
import com.ktds.ssms.mobile.vo.LocationLogVO;

public class MobileDAOImpl extends SqlSessionDaoSupport implements MobileDAO{

	@Override
	public boolean registerLocation(LocationLogVO locationLogVO) {
		
		return getSqlSession().insert("MobileDAO.registerLocation", locationLogVO) > 0;
	}

	@Override
	public String getLocationLogSeq() {
		return getSqlSession().selectOne("MobileDAO.getLocationLogSeq");
	}

}
