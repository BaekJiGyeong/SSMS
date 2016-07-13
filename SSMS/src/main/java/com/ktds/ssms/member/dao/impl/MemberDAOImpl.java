package com.ktds.ssms.member.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.ssms.member.dao.MemberDAO;
import com.ktds.ssms.member.vo.MemberVO;

public class MemberDAOImpl extends SqlSessionDaoSupport implements MemberDAO{

	@Override
	public int addNewMember(MemberVO member) {
		
		member.setSalt("sfdsfsdfd");
		
		return getSqlSession().insert("MemberDAO.addNewMember", member);
	}


}
