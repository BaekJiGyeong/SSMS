package com.ktds.ssms.article.service.impl;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.ktds.ssms.article.biz.ArticleBiz;
import com.ktds.ssms.article.service.ArticleService;
import com.ktds.ssms.member.vo.MemberVO;

public class ArticleServiceImpl implements ArticleService {
	
	private ArticleBiz articleBiz;

	public void setArticleBiz(ArticleBiz articleBiz) {
		this.articleBiz = articleBiz;
	}

	@Override
	public ModelAndView getPatientVOListByName(String name) {
		
		ModelAndView view = new ModelAndView();		
		
		if(!name.equals("")){
			List<MemberVO> patientVOList = articleBiz.getPatientVOListByName(name);
			view.addObject("patientVOList", patientVOList);
		}
		view.addObject("name", name);
		
		view.setViewName("/article/patientLoc");
		
		return view;
	}
	
	

}
