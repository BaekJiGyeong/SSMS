package com.ktds.ssms.member.biz;

import javax.servlet.http.HttpSession;

import com.ktds.ssms.member.vo.MemberVO;

public interface MemberBiz {

	public boolean addNewMember(MemberVO member);

	public boolean doLoginMember(MemberVO member, HttpSession session);

	public boolean isExistId(String id);

}
