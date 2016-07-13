package com.ktds.ssms.member.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.ssms.member.vo.MemberVO;

public interface MemberService {

	public ModelAndView registerMember();
	
	public String addNewMember(MemberVO member, String repeatPassword, Errors errors, HttpServletResponse response);
	
	public void checkValidationById(String id, HttpServletResponse response);

	public void checkValidationByPassword(String password, HttpServletResponse response);
	
	public void checkValidationByRepeatPassword(String password, String repeatPassword, HttpServletResponse response);
	
	public void checkValidationByPhoneNumber(String phoneNumber, HttpServletResponse response);
	
	public void checkValidationByName(String name, HttpServletResponse response);
}
