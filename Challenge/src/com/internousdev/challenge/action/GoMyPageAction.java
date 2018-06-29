package com.internousdev.challenge.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.challenge.dao.GoMyPageDAO;
import com.internousdev.challenge.dto.GoMyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoMyPageAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private GoMyPageDAO dao = new GoMyPageDAO();

	public String execute() {
		String result = "login";
		if(session.containsKey("userId")
				&& session.containsKey("password")) {
			GoMyPageDTO dto = dao.getMyPageInfo(
					session.get("userId").toString(),
					session.get("password").toString());
			session.put("familyName", dto.getFamilyName());
			session.put("firstName", dto.getFirstName());
			session.put("sex", dto.getSex());
			session.put("Email", dto.getEmail());
			result = SUCCESS;
		}
		return result;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}
}
