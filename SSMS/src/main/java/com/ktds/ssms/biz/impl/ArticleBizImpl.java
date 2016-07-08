package com.ktds.ssms.biz.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktds.ssms.biz.ArticleBiz;
import com.ktds.ssms.dao.ArticleDAO;

public class ArticleBizImpl implements ArticleBiz {

	   private Logger logger = LoggerFactory.getLogger(ArticleBiz.class);
	   
	   private ArticleDAO articleDAO;
	   
	   public void setArticleDAO(ArticleDAO articleDAO) {
	      this.articleDAO = articleDAO;
	   }

	  

}
