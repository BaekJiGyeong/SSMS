package com.ktds.ssms.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktds.ssms.biz.ArticleBiz;
import com.ktds.ssms.dao.ArticleDAO;

public class ArticleDAOImpl extends SqlSessionDaoSupport implements ArticleDAO{

	private Logger logger = LoggerFactory.getLogger(ArticleBiz.class);
	
	private ArticleDAO articleDAO;
	
	//반드시 setter가 있어야함
	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}
	
	
}
