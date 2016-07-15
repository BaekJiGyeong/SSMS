package com.ktds.ssms.member.service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.ssms.member.vo.MemberVO;

public interface MemberService {

	public ModelAndView registerMember();

	public ModelAndView addNewMember(MemberVO member, Errors errors);

	public ModelAndView doLoginMember(MemberVO member, HttpSession session);

	public String doLogoutMember(HttpSession session);

	public void checkValidationById(String id, HttpServletResponse response);

}
