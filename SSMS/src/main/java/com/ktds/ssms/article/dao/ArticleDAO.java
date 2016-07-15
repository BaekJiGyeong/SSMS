package com.ktds.ssms.article.dao;

import java.util.List;

import com.ktds.ssms.member.vo.MemberVO;

public interface ArticleDAO {

	public List<MemberVO> getPatientVOListByName(String name);

}
