package com.internousdev.template2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template2.dao.BuyItemDAO;
import com.internousdev.template2.dao.LoginDAO;
import com.internousdev.template2.dto.BuyItemDTO;
import com.internousdev.template2.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private String userId;
	private String password;
	private Map<String,Object> session;

	public String execute(){
		String ret = ERROR;
		System.out.println(userId);
		System.out.println(password);
		LoginDAO dao = new LoginDAO();
		BuyItemDAO daoBuy = new BuyItemDAO();
		LoginDTO dto = new LoginDTO();
		BuyItemDTO dtoBuy = daoBuy.select();
		dto = dao.select(userId, password);
		/*session.put("loginUser", dto);*/
		/*if(((LoginDTO)session.get("loginUser")).getLoginFlg()){*/
		if(this.userId.equals(dto.getLoginUserId()) && this.password.equals(dto.getLoginPassword())){
			session.put("login_user_id",dto.getLoginUserId());
			session.put("login_pass", dto.getLoginPassword());
			session.put("id", dtoBuy.getId());
			session.put("buyItem_name", dtoBuy.getItemName());
			session.put("buyItem_price", dtoBuy.getItemPrice());
			ret = SUCCESS;
		}else{
			ret = ERROR;
		}
		return ret;
	}


public String getUserId(){
	return userId;
}
public void setUserId(String userId){
	this.userId=userId;
}

public String getPassword(){
	return password;
}
public void setPassword(String password){
	this.password=password;
}

public Map<String,Object> getSession(){
	return session;
}

public void setSession(Map<String,Object> session){
	this.session=session;
}
}
