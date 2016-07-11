package com.ktds.ssms.article.biz.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktds.ssms.article.biz.ArticleBiz;
import com.ktds.ssms.article.dao.ArticleDAO;

public class ArticleBizImpl implements ArticleBiz {

	   private Logger logger = LoggerFactory.getLogger(ArticleBiz.class);
	   
	   private ArticleDAO articleDAO;
	   
	   public void setArticleDAO(ArticleDAO articleDAO) {
	      this.articleDAO = articleDAO;
	   }

	  

}
