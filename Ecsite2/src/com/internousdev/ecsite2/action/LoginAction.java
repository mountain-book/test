/* login.jspからbuyItem.jspへと遷移するためのクラス
 * 次のページで表示する購入品の情報を取得する
 * 管理者IDでログインした場合、管理者画面へと遷移する
 */

package com.internousdev.ecsite2.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.BuyItemDAO;
import com.internousdev.ecsite2.dao.LoginDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.internousdev.ecsite2.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
	private Map<String,Object> session;
	private ArrayList<BuyItemDTO> buyItemList = new ArrayList<BuyItemDTO>();
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();
	private BuyItemDTO buyItemDTO = new BuyItemDTO();

	public String execute() {
		String result = ERROR;
		// loginDTOをloginDAOで実行した状態にする(引数を別途設定）
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		// ログインユーザー情報（ログインID、ログインPASS、ユーザー名）のセッションを作成
		session.put("loginUser", loginDTO);

		// (String)session.get("key")…getメソッド(keyから値を取り出す)
		// もし"loginUser"の中にgetLoginFlgメソッドがあれば
		//if(loginDTO.getLoginFlg()){
		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;
			// BuyItemDTOをBuyItemDAOで実行した状態にする
			buyItemList = buyItemDAO.getBuyItemInfo();
			// 購入品の情報をセッションに格納する
			session.put("login_user_id", loginDTO.getLoginId());
			session.put("item_id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price",buyItemDTO.getItemPrice());

			//管理者としてログインする場合
			//if(loginDTO.getLoginId().equals("manager") && loginDTO.getLoginPass().equals("0302")) {
			if(session.get("login_user_id").equals("manager")){
				result = "manager";
			}
		}
		return result;
	}



	public String getLoginUserId() {
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId) {
		this.loginUserId=loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword=loginPassword;
	}

	@Override
	public void setSession(Map<String,Object>session) {
		this.session=session;
	}
}
