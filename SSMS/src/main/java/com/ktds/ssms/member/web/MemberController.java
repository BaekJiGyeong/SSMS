package com.ktds.ssms.member.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.ssms.member.service.MemberService;
import com.ktds.ssms.member.vo.MemberVO;


@Controller
public class MemberController {

	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/login")
	public String viewLoginPage() {
		return "common/login";
	}
	
	@RequestMapping("/register")
	public ModelAndView ViewRegisterMemberPage() {
		return memberService.registerMember();
	}
	
	@RequestMapping("/doRegisterMemberAction")
	public ModelAndView doRegisterMemberAction(@Valid MemberVO member, Errors errors) {
		
		return memberService.addNewMember(member, errors);
	}
	
}
