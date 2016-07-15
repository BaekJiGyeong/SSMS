package com.ktds.ssms.mobile.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@RequestMapping("/m/login")
	@ResponseBody
	public Map<String, String> login(@Valid MemberVO memberVO, Errors errors, HttpSession session, HttpServletRequest request) {
		
		ModelAndView mav = memberService.doLoginMember(memberVO, session);
		
		Map<String , String> result = new HashMap<String, String>();
	
		boolean loginResult = true;
		if(mav == null ){
			loginResult = false;
		}
		result.put("result", loginResult+"");
		
		if(mav != null ){
			result.put("message", "로그인을 성공했습니다.");
			result.put("sessionId", session.getId()+"");
		}
		else  {
			result.put("message", "로그인에 실패하였습니다.");
		}
		return result;
	}
	
}
