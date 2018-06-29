package com.internousdev.challenge.util;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.challenge.dto.PaginationDTO;
import com.internousdev.challenge.dto.ProductInfoDTO;

public class Pagination {

	public PaginationDTO initialize(List<ProductInfoDTO> list,int pageSize) {
		// 初期化を行うメソッド
		PaginationDTO paginationDTO = new PaginationDTO();
		// 全ページ数 全ての要素を表示させるために必要なページ数を計算する
		paginationDTO.setTotalPageSize((int)(Math.ceil(list.size() / pageSize))); // Math.ceil(1.5) => 2 小数点以下切り上げ
		// 現在のページ番号 1ページにする
		paginationDTO.setCurrentPageNo(1);
		// 全レコード数
		paginationDTO.setTotalRecordSize(list.size() - 1); // -1　…列名以外を指定している？
		// 現在のページ番号に対する開始レコード番号（オフセット）
		paginationDTO.setStartRecordNo(pageSize * (paginationDTO.getCurrentPageNo() - 1));
		// 現在のページ番号に対する終了レコード番号
		paginationDTO.setEndRecordNo(paginationDTO.getStartRecordNo() + (pageSize - 1));

		// ページ数のリスト
		List<Integer> pageNumberList = new ArrayList<Integer>();
		for(int pageNumber = 1; pageNumber <= paginationDTO.getTotalPageSize(); pageNumber++) {
			pageNumberList.add(pageNumber);
		}

		// 商品情報のページのリスト？？わからん
		List<ProductInfoDTO> productInfoPages = new ArrayList<ProductInfoDTO>();
		for(int pageNumberOffset = paginationDTO.getStartRecordNo(); pageNumberOffset <= paginationDTO.getEndRecordNo(); pageNumberOffset++) {
			productInfoPages.add(list.get(pageNumberOffset));
		}
		paginationDTO.setCurrentProductInfoPage(productInfoPages);

		if((paginationDTO.getStartRecordNo() - 1) <= 0) {
			paginationDTO.setPreviousPage(false);
		}else {
			paginationDTO.setPreviousPage(true);
			paginationDTO.setPreviousPageNo(paginationDTO.getCurrentPageNo() - 1);
		}

		if(paginationDTO.getEndRecordNo() + pageSize > paginationDTO.getTotalRecordSize()) {
			paginationDTO.setNextPage(false);
		}else {
			paginationDTO.setNextPage(true);
			paginationDTO.setNextPageNo(paginationDTO.getCurrentPageNo() + 1);
		}
		return paginationDTO;
	}

	public PaginationDTO getPage(List<ProductInfoDTO> list, int pageSize, String pageNo) {

		PaginationDTO paginationDTO = new PaginationDTO();
		paginationDTO.setTotalPageSize((int)(Math.ceil(list.size() / pageSize)));
		paginationDTO.setCurrentPageNo(Integer.parseInt(pageNo));
		paginationDTO.setTotalRecordSize(list.size() - 1);
		paginationDTO.setStartRecordNo(pageSize * (paginationDTO.getCurrentPageNo() - 1));
		paginationDTO.setEndRecordNo(paginationDTO.getStartRecordNo() + (pageSize - 1));

		List<Integer> pageNumberList = new ArrayList<Integer>();
		for(int pageNumber = 1; pageNumber <= paginationDTO.getTotalPageSize(); pageNumber++) {
			pageNumberList.add(pageNumber);
		}

		List<ProductInfoDTO> productInfoPages = new ArrayList<ProductInfoDTO>();
		for(int pageNumberOffset = paginationDTO.getStartRecordNo(); pageNumberOffset <= paginationDTO.getEndRecordNo(); pageNumberOffset++) {
			productInfoPages.add(list.get(pageNumberOffset));
		}
		paginationDTO.setCurrentProductInfoPage(productInfoPages);

		if((paginationDTO.getStartRecordNo() - 1) <= 0){
			paginationDTO.setPreviousPage(false);
		}else {
			paginationDTO.setPreviousPage(true);
			paginationDTO.setPreviousPageNo(paginationDTO.getCurrentPageNo() - 1);
		}

		if(paginationDTO.getEndRecordNo() + pageSize > paginationDTO.getTotalRecordSize()) {
			paginationDTO.setNextPage(false);
		}else {
			paginationDTO.setNextPage(true);
			paginationDTO.setNextPageNo(paginationDTO.getCurrentPageNo() + 1);
		}

		return paginationDTO;
	}
}
