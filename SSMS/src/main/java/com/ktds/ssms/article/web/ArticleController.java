package com.ktds.ssms.article.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.ssms.article.service.ArticleService;


@Controller
public class ArticleController {
	
	private Logger logger= LoggerFactory.getLogger(ArticleController.class);

	private ArticleService articleService;
	
	
	
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@RequestMapping("/list")
	public ModelAndView articleList() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/article/list");
		return view;
	}
	
	@RequestMapping("/introduction")
	public ModelAndView introduction() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/article/introduction");
		return view;
	}
	
	@RequestMapping("/mapGuide")
	public ModelAndView location() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/article/mapGuide");
		return view;
	}
	
	

}
