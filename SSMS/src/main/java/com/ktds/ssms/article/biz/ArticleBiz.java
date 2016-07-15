package com.ktds.ssms.article.biz;

import java.util.List;

import com.ktds.ssms.member.vo.MemberVO;


public interface ArticleBiz {

	List<MemberVO> getPatientVOListByName(String name);

	
}
