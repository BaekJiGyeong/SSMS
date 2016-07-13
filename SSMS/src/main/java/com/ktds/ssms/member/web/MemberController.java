package com.ktds.ssms.member.web;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.ssms.member.service.MemberService;
import com.ktds.ssms.member.vo.MemberVO;

import kr.co.hucloud.utilities.web.AjaxUtil;

@Controller
public class MemberController {

	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping(value ="/doRegisterMemberAction", method = {RequestMethod.POST, RequestMethod.GET})
	public void doRegisterMemberAction(@Valid MemberVO member, @RequestParam String repeatPassword, Errors errors, HttpServletResponse response) {
		String reportStatus = memberService.addNewMember(member, repeatPassword, errors, response);
		AjaxUtil.sendResponse(response, reportStatus);
	}
	
	@RequestMapping("/login")
	public String viewLoginPage() {
		return "common/login";
	}
	
	@RequestMapping("/register")
	public ModelAndView viewRegisterMemberPage() {
		return memberService.registerMember();
		
	}
	
	@RequestMapping("/checkValidationById")
	public void checkValidationById(@RequestParam String id, HttpServletResponse response){
		memberService.checkValidationById(id, response);
			
	}
	
	@RequestMapping("/checkValidationByPassword")
	public void checkValidationByPassword(@RequestParam String password, HttpServletResponse response) {
		memberService.checkValidationByPassword(password, response);
	}

	@RequestMapping("/checkValidationByRepeatPassword")
	public void checkValidationByRepeatPassword(@RequestParam String password, @RequestParam String repeatPassword,
			HttpServletResponse response) {
		memberService.checkValidationByRepeatPassword(password, repeatPassword, response);
	}

	@RequestMapping("/checkValidationByName")
	public void checkValidationByName(@RequestParam String name, HttpServletResponse response) {
		memberService.checkValidationByName(name, response);
	}
	
	@RequestMapping("/checkValidationByPhoneNumber")
	public void checkValidationByPhoneNumber(@RequestParam String phoneNumber, HttpServletResponse response) {
		memberService.checkValidationByPhoneNumber(phoneNumber, response);
	}
	
	
}
