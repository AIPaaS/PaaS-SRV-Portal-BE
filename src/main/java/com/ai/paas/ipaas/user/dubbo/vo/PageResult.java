package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageResult<T> implements Serializable {
	private static final long serialVersionUID = 381081797378780646L;
	
	private int currentPage; //当前页数
	
	private int totalPages; //总页数
	
	private int totalCount;//总记录条数
	
	private List<T> resultList = new ArrayList<T>(); // 结果集
	
	public List<T> getResultList() {
		return resultList;
	}
	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	
	
	
	
}
