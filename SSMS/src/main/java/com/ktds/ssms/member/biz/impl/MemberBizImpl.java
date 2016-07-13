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

	@Override
	public boolean isVerifyId(String id) {
		String idPolicy = "((?=.*[a-zA-Z])(?=.*[0-9]).{5,20})";
		Pattern pattern = Pattern.compile(idPolicy);
		Matcher matcher = pattern.matcher(id);
		boolean isVerify = matcher.matches();
		
		idPolicy = "(^[A-Za-z0-9]*$)";
		pattern = Pattern.compile(idPolicy);
		matcher = pattern.matcher(id);
		isVerify = isVerify && matcher.matches();
		
		return isVerify;
	}

	@Override
	public boolean isVerifyPassword(String password) {
		String passwordPolicy = "((?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*()]).{10,20})";
		Pattern pattern = Pattern.compile(passwordPolicy);
		Matcher matcher = pattern.matcher(password);
		boolean isVerify = matcher.matches();
		
		passwordPolicy = "(^[A-Za-z0-9!@#$%^&*()]*$)";
		pattern = Pattern.compile(passwordPolicy);
		matcher = pattern.matcher(password);
		isVerify = isVerify && matcher.matches();
		
		return isVerify;
	}
	
	@Override
	public boolean isVerifyPhoneNumber (String phoneNumber) {
		String phoneNumberPolicy = "(^0([0-9]){1,2}-([0-9]{3,4})-([0-9]{4})$)";
		Pattern pattern = Pattern.compile(phoneNumberPolicy);
		Matcher matcher = pattern.matcher(phoneNumber);
		return matcher.matches();
	}
	
	@Override
	public boolean checkValidationByName(String name) {
		String namePolicy = "(^[가-힣]*$)";
		Pattern pattern = Pattern.compile(namePolicy);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}

}
