package com.internousdev.challenge.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.challenge.dao.ProductInfoDAO;
import com.internousdev.challenge.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDetailsAction extends ActionSupport implements SessionAware{
	private int productId;
	private List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
	private Map<String,Object> session;
	public String execute() {
		String result = ERROR;
		ProductInfoDAO dao = new ProductInfoDAO();
		ProductInfoDTO dto = new ProductInfoDTO();
		dto = dao.getProductInfo(productId);
		session.put("id", dto.getId());
		session.put("productId",dto.getProductId());
		session.put("productName", dto.getProductName());
		session.put("productNameKana", dto.getProductNameKana());
		session.put("imageFilePath", dto.getImageFilePath());
		session.put("imageFileName", dto.getImageFileName());
		session.put("price", dto.getPrice());
		session.put("releaseCompany", dto.getReleaseDate());
		session.put("releaseDate", dto.getReleaseDate());
		session.put("productDescription", dto.getProductDescription());

		List<Integer> productCountList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		session.put("productCountList", productCountList);
		productInfoDTOList = dao.getProductInfoListByCategoryId(
				dto.getCategoryId(), 
				dto.getProductId(), 0, 3);
		Iterator<ProductInfoDTO> iterator = productInfoDTOList.iterator();
		if(!(iterator.hasNext())) {
			productCountList = null;
		}
		if(!productInfoDTOList.isEmpty() || productCountList == null) {
			session.put("productInfoDTOList", productInfoDTOList);
			result = SUCCESS;
		}
		return result;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId=productId;
	}

	public List<ProductInfoDTO> getProductInfoDTOList(){
		return productInfoDTOList;
	}
	public void setProductInfoDTOList(List<ProductInfoDTO> productInfoDTOList) {
		this.productInfoDTOList=productInfoDTOList;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}

}
