package com.ktds.ssms.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.ssms.biz.ArticleBiz;


@Controller
public class ArticleController {
	
	private Logger logger= LoggerFactory.getLogger(ArticleController.class);

	private ArticleBiz articleBiz;
	
	public void setArticleBiz(ArticleBiz articleBiz) {
		this.articleBiz = articleBiz;
	}
	
	@RequestMapping("/list")
	public ModelAndView articleList() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/article/list");
		return view;
	}
	
	@RequestMapping("/test")
	public String viewTestPage() {
		return "/article/test";
	}
	
}
