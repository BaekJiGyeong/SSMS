package com.ktds.ssms.member.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.ssms.member.dao.MemberDAO;
import com.ktds.ssms.member.vo.LoginLogVO;
import com.ktds.ssms.member.vo.MemberVO;

public class MemberDAOImpl extends SqlSessionDaoSupport implements MemberDAO{

	@Override
	public int addNewMember(MemberVO member) {
		return getSqlSession().insert("MemberDAO.addNewMember", member);
	}

	@Override
	public String getSaltById(String id) {
		return getSqlSession().selectOne("MemberDAO.getSaltById", id);
	}

	@Override
	public MemberVO doLoginMember(MemberVO member) {
		return getSqlSession().selectOne("MemberDAO.doLoginMember", member);
	}

	@Override
	public String getNowTime() {
		return getSqlSession().selectOne("MemberDAO.getNowTime");
	}

	@Override
	public String getCurrentSeq() {
		return getSqlSession().selectOne("MemberDAO.getCurrentSeq");
	}

	@Override
	public void insertLoginLog(LoginLogVO loginLogVO) {
		getSqlSession().insert("MemberDAO.insertLoginLog", loginLogVO);
	}

	@Override
	public String isExistId(String id) {
		return getSqlSession().selectOne("MemberDAO.isExistId", id);
	}
}
