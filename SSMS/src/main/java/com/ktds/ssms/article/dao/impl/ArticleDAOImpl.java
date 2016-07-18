package com.ktds.ssms.article.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.ssms.article.dao.ArticleDAO;
import com.ktds.ssms.member.vo.MemberVO;

public class ArticleDAOImpl extends SqlSessionDaoSupport implements ArticleDAO{

	   @Override
	   public List<String> getIdListByName(String name) {
	      return getSqlSession().selectList("ArticleDAO.getIdListByName", name);
	   }

	   @Override
	   public MemberVO getPatientInfoById(String id) {
	      return getSqlSession().selectOne("ArticleDAO.getPatientInfoById", id);
	   }
	
}
