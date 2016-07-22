package com.ktds.ssms.article.dao;

import java.util.List;

import com.ktds.ssms.article.vo.LocationVO;
import com.ktds.ssms.member.vo.MemberVO;

public interface ArticleDAO {
	
	public List<String> getIdListByName(String name);

	public MemberVO getPatientInfoById(String id);

	public List<LocationVO> getLocationVOListById(String id);

}
