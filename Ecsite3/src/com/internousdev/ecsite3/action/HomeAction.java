package com.internousdev.ecsite3.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite3.dao.MCategoryDAO;
import com.internousdev.ecsite3.dto.MCategoryDTO;
import com.internousdev.ecsite3.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{
	private List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();
	private String categoryId;
	private Map<String,Object> session;

	public String execute() {
		if(!(session.containsKey("loginId")) && !(session.containsKey("tempUserId"))) {
			CommonUtility commonUtility = new CommonUtility();
			session.put("tempUserId", commonUtility.getRamdomValue());
		}

		if(!session.containsKey("logined")) {
			session.put("logined", 0);
		}

		if(!session.containsKey("mCategoryList")) {
			MCategoryDAO dao = new MCategoryDAO();
			mCategoryDTOList = dao.getMCategoryList();
			session.put("mCategoryDTOList", mCategoryDTOList);
		}
		return SUCCESS;
	}

	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId=categoryId;
	}

	public List<MCategoryDTO> getMCategoryDTOList(){
		return mCategoryDTOList;
	}
	public void setMCategoryDTOList(List<MCategoryDTO>mCategoryDTOList) {
		this.mCategoryDTOList=mCategoryDTOList;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	@Override
	public void  setSession(Map<String,Object>session) {
		this.session=session;
	}
}
