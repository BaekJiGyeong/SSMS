package com.ktds.ssms.member.biz;
import com.ktds.ssms.member.vo.MemberVO;

public interface MemberBiz {

	public boolean addNewMember(MemberVO member);

	public boolean isVerifyId(String id);

	public boolean checkValidationByName(String name);

	public boolean isVerifyPassword(String password);

	public boolean isVerifyPhoneNumber(String phoneNumber);
}
