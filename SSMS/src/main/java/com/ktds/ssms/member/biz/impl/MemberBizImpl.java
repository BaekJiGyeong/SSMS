package com.ktds.ssms.member.biz.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ktds.ssms.member.biz.MemberBiz;
import com.ktds.ssms.member.dao.MemberDAO;
import com.ktds.ssms.member.vo.MemberVO;

public class MemberBizImpl implements MemberBiz{

	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public boolean addNewMember(MemberVO member) {
		
		return memberDAO.addNewMember(member) > 0;
	}

}
