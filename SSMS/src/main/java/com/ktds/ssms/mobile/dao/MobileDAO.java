package com.ktds.ssms.mobile.dao;

import com.ktds.ssms.mobile.vo.LocationLogVO;

public interface MobileDAO {

	public boolean registerLocation(LocationLogVO locationLogVO);

	public String getLocationLogSeq();

}
