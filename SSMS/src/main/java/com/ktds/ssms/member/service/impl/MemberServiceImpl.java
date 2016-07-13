package com.ktds.ssms.member.service.impl;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.ssms.member.biz.MemberBiz;
import com.ktds.ssms.member.service.MemberService;
import com.ktds.ssms.member.vo.MemberVO;

import kr.co.hucloud.utilities.SHA256Util;
import kr.co.hucloud.utilities.web.AjaxUtil;

public class MemberServiceImpl implements MemberService {

	private MemberBiz memberBiz;
	private Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	public void setMemberBiz(MemberBiz memberBiz) {
		this.memberBiz = memberBiz;
	}
	
	@Override
	public ModelAndView registerMember() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("member/registerMember");
		
		return view;
	}
	
	@Override
	public String addNewMember(MemberVO member, String repeatPassword, Errors errors, HttpServletResponse response) {
		ModelAndView view = new ModelAndView();
		
		boolean isNotError = true;
		isNotError = isAllValidValue(member, repeatPassword, view);
		if (errors.hasErrors() || !isNotError) {
			
			return "NO";
		} else if (isNotError) {
			setSaltAndPassword(member);
			if (memberBiz.addNewMember(member)) {
				return "OK";
			} else {
				return "NO";
			}
		} else {
			throw new RuntimeException("잘못된 입력입니다.");
		}
	}

	private void setSaltAndPassword(MemberVO member) {
		String salt = SHA256Util.generateSalt();
		member.setSalt(salt);

		String newPassword = SHA256Util.getEncrypt(member.getPassword(), salt);
		member.setPassword(newPassword);
	}

	private boolean isAllValidValue(MemberVO member, String repeatPassword, ModelAndView view) {

		boolean isNotError = true;
		int errorCount = 0;

		if (repeatPassword == null) {
			view.addObject("isEmptyRepeatPassword", "true");
			errorCount++;
		}

		if (repeatPassword != null && member.getPassword() != null && !member.getPassword().equals(repeatPassword)) {
			view.addObject("isEqualsPassword", "true");
			errorCount++;
		}

		if (member.getId() != null && !memberBiz.isVerifyId(member.getId())) {
			errorCount++;
		}

		if (member.getName() != null && !memberBiz.checkValidationByName(member.getName())) {
			errorCount++;
		}

		if (member.getPassword() != null && !memberBiz.isVerifyPassword(member.getPassword())) {
			errorCount++;
		}

		if (member.getPhoneNumber() != null && !memberBiz.isVerifyPhoneNumber(member.getPhoneNumber())) {
			errorCount++;
		}

		if (errorCount > 0) {
			isNotError = false;
		}

		return isNotError;
	}
	

	@Override
	public void checkValidationById(String id, HttpServletResponse response) {
		String message = "OK";
		boolean isVerifyId = memberBiz.isVerifyId(id);
		if (!isVerifyId) {
			message = "NO";
			AjaxUtil.sendResponse(response, message);
			return;
		}
		AjaxUtil.sendResponse(response, message);
		return;
	}

	@Override
	public void checkValidationByPassword(String password, HttpServletResponse response) {
		String message = "NO";
		boolean isVerifyPassword = memberBiz.isVerifyPassword(password);
		if (isVerifyPassword) {
			message = "OK";
		}
		AjaxUtil.sendResponse(response, message);
		return;
	}

	@Override
	public void checkValidationByRepeatPassword(String password, String repeatPassword, HttpServletResponse response) {
		String message = "NO";
		boolean isEquals = password.equals(repeatPassword);
		if (isEquals) {
			message = "OK";
		}
		AjaxUtil.sendResponse(response, message);
		return;
	}

	@Override
	public void checkValidationByPhoneNumber(String phoneNumber, HttpServletResponse response) {
		String message = "NO";
		boolean isVerifyPhoneNumber = memberBiz.isVerifyPhoneNumber(phoneNumber);
		if (isVerifyPhoneNumber) {
			message = "OK";
		}
		AjaxUtil.sendResponse(response, message);
		return;
	}

	@Override
	public void checkValidationByName(String name, HttpServletResponse response) {
		String message = "NO";
		boolean isVerifyName = memberBiz.checkValidationByName(name);
		if (isVerifyName) {
			message = "OK";
		}
		AjaxUtil.sendResponse(response, message);
		return;
	}

}
