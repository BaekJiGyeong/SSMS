package com.ktds.ssms.mobile.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ktds.ssms.mobile.service.MobileService;
import com.ktds.ssms.mobile.vo.LocationLogVO;

@Controller
public class MobileController {
	
	private MobileService mobileService;

	public void setMobileService(MobileService mobileService) {
		this.mobileService = mobileService;
	}

	@RequestMapping("/m/registerLocation")
	@ResponseBody
	public void registerLocation(@Valid LocationLogVO locationLogVO){
		
		String locationId = "1";
		String memberId = "test02";
		
		locationLogVO.setLocationId(locationId);
		locationLogVO.setMemberId(memberId);
		
		boolean result = mobileService.registerLocation(locationLogVO);		
		
	}
	
}
