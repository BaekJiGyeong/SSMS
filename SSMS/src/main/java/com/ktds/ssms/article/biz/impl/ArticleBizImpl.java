package com.ktds.ssms.article.biz.impl;

import java.util.ArrayList;
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
		
		// name이 포함된 멤버들 id list를 가져온다.
		List<String> idList = articleDAO.getIdListByName(name);
		
		List<MemberVO> patientInfoList = new ArrayList<MemberVO>();
		MemberVO patientInfo = null;
		// id list for문 돌려서 각각 정보를 가져온다.
		for (String id : idList) {
			patientInfo = articleDAO.getPatientInfoById(id);
			patientInfoList.add(patientInfo);
		}
		return patientInfoList;
	}

	  

}
