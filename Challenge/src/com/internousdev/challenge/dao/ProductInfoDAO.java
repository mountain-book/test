package com.internousdev.challenge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.challenge.dto.ProductInfoDTO;
import com.internousdev.challenge.util.DBConnector;

public class ProductInfoDAO {

//////////////全ての商品情報を取得する//////////////////////////////
	public List<ProductInfoDTO> getProductInfoList(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
		String sql = "SELECT * FROM product_info";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ProductInfoDTO dto = new ProductInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setProductDescription(rs.getString("product_description"));
				dto.setCategoryId(rs.getInt("category_id"));
				dto.setPrice(rs.getInt("price"));
				dto.setImageFilePath(rs.getString("image_file_path"));
				dto.setImageFileName(rs.getString("image_file_name"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setStatus(rs.getInt("status"));
				dto.setRegistDate(rs.getDate("regist_date"));
				dto.setUpdateDate(rs.getDate("update_date"));
				productInfoDTOList.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return productInfoDTOList;
	}
///////////////////ここまで//////////////////////////////////////

//////////////特定の商品の情報を取得する//////////////////////////
	public ProductInfoDTO getProductInfo(int productId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ProductInfoDTO dto = new ProductInfoDTO();
		String sql = "SELECT * FROM product_info WHERE product_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,productId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				dto.setId(rs.getInt("id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setProductDescription(rs.getString("product_description"));
				dto.setCategoryId(rs.getInt("category_id"));
				dto.setPrice(rs.getInt("price"));
				dto.setImageFilePath(rs.getString("image_file_path"));
				dto.setImageFileName(rs.getString("image_file_name"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setStatus(rs.getInt("status"));
				dto.setRegistDate(rs.getDate("regist_date"));
				dto.setUpdateDate(rs.getDate("update_date"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
//////////////////////ここまで/////////////////////////////////

///////////////////関連商品情報を取得する//////////////////////
	public List<ProductInfoDTO> getProductInfoListByCategoryId(
			int categoryId,
			int productId,
			int limitOffset,
			int limitRowCount){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
		String sql = "SELECT * FROM product_info "
				+ "WHERE category_id=? "
				+ "AND product_id NOT IN(?) "
				+ "ORDER BY rand() LIMIT ?,?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,categoryId);
			ps.setInt(2, productId);
			ps.setInt(3, limitOffset);
			ps.setInt(4, limitRowCount);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ProductInfoDTO dto = new ProductInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setProductDescription(rs.getString("product_description"));
				dto.setCategoryId(rs.getInt("category_id"));
				dto.setPrice(rs.getInt("price"));
				dto.setImageFilePath(rs.getString("image_file_path"));
				dto.setImageFileName(rs.getString("image_file_name"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setStatus(rs.getInt("status"));
				dto.setRegistDate(rs.getDate("regist_date"));
				dto.setUpdateDate(rs.getDate("update_date"));
				productInfoDTOList.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return productInfoDTOList;
	}
/////////////////////ここまで/////////////////////////////////////

//////////////////検索ワードに該当する商品を検索する//////////////////
	public List<ProductInfoDTO> getProductInfoListAll(String[] keywordsList){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ProductInfoDTO> productInfoDTOList =new ArrayList<ProductInfoDTO>();
		String sql ="SELECT * FROM product_info WHERE";
		boolean initializeFlg = true;
		for(String keyword : keywordsList) {
			if(initializeFlg) {
				sql += " (product_name LIKE '%" + keyword + "%' OR product_name_kana LIKE '%" + keyword + "%')";
				initializeFlg = false;
			}else {
				sql += " AND (product_name LIKE '%" + keyword + "%' OR product_name_kana LIKE '%" + keyword + "%')";
			}
		}
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ProductInfoDTO dto = new ProductInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setProductDescription(rs.getString("product_description"));
				dto.setCategoryId(rs.getInt("category_id"));
				dto.setPrice(rs.getInt("price"));
				dto.setImageFilePath(rs.getString("image_file_path"));
				dto.setImageFileName(rs.getString("image_file_name"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setStatus(rs.getInt("status"));
				dto.setUpdateDate(rs.getDate("regist_date"));
				dto.setUpdateDate(rs.getDate("update_date"));
				productInfoDTOList.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return productInfoDTOList;
	}
////////////////////////ここまで///////////////////////////
///////////////////商品リストから検索？//////////////////////
	public List<ProductInfoDTO> getProductInfoListByKeywords(String[] keywordsList, String categoryId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
		String sql = "SELECT * FROM product_info WHERE";
		boolean initializeFlg = true;
		for(String keyword : keywordsList) {
			if(initializeFlg) {
				sql += " category_id=" + categoryId + " AND (product_name LIKE '%" + keyword + "%' OR product_name_kana LIKE '%" + keyword + "%')";
				initializeFlg = false;
			}else {
				sql += " AND (product_name LIKE '%" + keyword + "%' OR product_name_kana LIKE '%" + keyword + "%')";
			}
		}
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ProductInfoDTO dto = new ProductInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setProductDescription(rs.getString("product_description"));
				dto.setCategoryId(rs.getInt("category_id"));
				dto.setPrice(rs.getInt("price"));
				dto.setImageFilePath(rs.getString("image_file_path"));
				dto.setImageFileName(rs.getString("image_file_name"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setStatus(rs.getInt("status"));
				dto.setUpdateDate(rs.getDate("regist_date"));
				dto.setUpdateDate(rs.getDate("update_date"));
				productInfoDTOList.add(dto);
			}
			}catch(SQLException e) {
				e.printStackTrace();
		}try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return productInfoDTOList;
	}
//////////////////////ここまで////////////////////////////////
}
