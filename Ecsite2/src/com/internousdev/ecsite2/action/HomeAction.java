/* home.jspからlogin.jspまたはbuyItem.jspへ遷移するためのクラス
 * 未ログイン：login.jspへ（result="login")
 * ログイン中：login.jspを飛ばしてbuyItem.jspへ(result=SUCCESS)
 */

package com.internousdev.ecsite2.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.BuyItemDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private ArrayList<BuyItemDTO> buyItemList = new ArrayList<BuyItemDTO>();
	private BuyItemDAO dao = new BuyItemDAO();
	private BuyItemDTO dto = new BuyItemDTO();
	public String execute() {
		String result = "login";
		// もし"id"のデータが格納されている場合(=ログイン中)
		if(session.containsKey("id")) {
			buyItemList = dao.getBuyItemInfo();

			session.put("item_id", dto.getId());
			session.put("buyItem_name", dto.getItemName());
			session.put("buyItem_price", dto.getItemPrice());
			result = SUCCESS;

		}
		return result;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}
}
