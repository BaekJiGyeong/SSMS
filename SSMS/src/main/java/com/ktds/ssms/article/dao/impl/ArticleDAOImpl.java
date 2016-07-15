package com.ktds.ssms.article.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktds.ssms.article.biz.ArticleBiz;
import com.ktds.ssms.article.dao.ArticleDAO;
import com.ktds.ssms.member.vo.MemberVO;

public class ArticleDAOImpl extends SqlSessionDaoSupport implements ArticleDAO{

	private Logger logger = LoggerFactory.getLogger(ArticleBiz.class);

	@Override
	public List<MemberVO> getPatientVOListByName(String name) {
		return getSqlSession().selectList("ArticleDAO.getPatientVOListByName", name);
	}
	
	
	
}
