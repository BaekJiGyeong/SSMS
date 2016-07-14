package com.ktds.ssms.member.biz.impl;

import javax.servlet.http.HttpSession;

import com.ktds.ssms.member.biz.MemberBiz;
import com.ktds.ssms.member.dao.MemberDAO;
import com.ktds.ssms.member.vo.MemberVO;

import kr.co.hucloud.utilities.SHA256Util;

public class MemberBizImpl implements MemberBiz{

	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public boolean addNewMember(MemberVO member) {
		
		String salt = SHA256Util.generateSalt();
		member.setSalt(salt);
		
		String newPassword = SHA256Util.getEncrypt(member.getPassword(), salt);
		member.setPassword(newPassword);
		
		return memberDAO.addNewMember(member) > 0;
	}

	@Override
	public boolean doLoginMember(MemberVO member, HttpSession session) {
		
		// SALT 값 가져와 입력한 암호 암호화 처리
		String memberSalt = memberDAO.getSaltById(member.getId());
		String saltPassword = SHA256Util.getEncrypt(member.getPassword(), memberSalt);
		member.setPassword(saltPassword);
		
		MemberVO loginMember = memberDAO.doLoginMember(member);
		
		if ( loginMember != null ) {
			session.setAttribute("_MEMBER_", loginMember);
			return true;
		}
		else {
			return false;
		}
		
	}

}
