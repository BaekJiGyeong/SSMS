package com.ktds.ssms.article.biz.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktds.ssms.article.biz.ArticleBiz;
import com.ktds.ssms.article.dao.ArticleDAO;
import com.ktds.ssms.member.vo.MemberVO;

public class ArticleBizImpl implements ArticleBiz {

	   private Logger logger = LoggerFactory.getLogger(ArticleBizImpl.class);
	   
	   private ArticleDAO articleDAO;
	   
	   public void setArticleDAO(ArticleDAO articleDAO) {
	      this.articleDAO = articleDAO;
	   }

	@Override
	public List<MemberVO> getPatientVOListByName(String name) {
		return articleDAO.getPatientVOListByName(name);
	}

	  

}
