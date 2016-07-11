package com.ktds.ssms.article.service.impl;

import com.ktds.ssms.article.biz.ArticleBiz;
import com.ktds.ssms.article.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {
	
	private ArticleBiz articleBiz;

	public void setArticleBiz(ArticleBiz articleBiz) {
		this.articleBiz = articleBiz;
	}
	
	

}
