/* home.jspからlogin.jspまたはbuyItem.jspへ遷移するためのクラス
 * 未ログイン：login.jspへ（result="login")
 * ログイン中：login.jspを飛ばしてbuyItem.jspへ(result=SUCCESS)
 */

package com.internousdev.ecsite2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.BuyItemDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	public String execute() {
		String result = "login";
		// もし"id"のデータが格納されている場合(=ログイン中)
		if(session.containsKey("id")) {
			BuyItemDAO buyItemDAO = new BuyItemDAO();
			// BuyItemDTOを、BuyItemDAOの処理を済ませた状態にする
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			// ~session.put~ "key"(箱)にvalue(中身)を格納する
			// 取得情報：購入品のid、名前、値段
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());
			result = SUCCESS;

		}
		return result;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}
}
