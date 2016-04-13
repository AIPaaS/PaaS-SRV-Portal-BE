package com.ai.paas.ipaas.user.vo;


import java.io.Serializable;
import java.util.List;

public class PageEntity implements Serializable {
	private static final long serialVersionUID = 4933771255759680537L;
	
	private int currentPage; // 请求页数
	
	private int PageSize; // 每页大小
	
	private int limitStart;
	
	private int limitEnd;
	
	private int totalCount;//查询总条数
	
	private int totalPage;//总页数
	
	private List<?> list;//分页查询内容
	
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		if(PageSize!=0){
			if(totalCount%PageSize==0){
				this.totalPage=totalCount/PageSize;
			}else{
				this.totalPage=totalCount/PageSize+1;
			}
		}
	}

	public int getTotalPage() {
		return totalPage;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		countLimit();
	}

	public int getPageSize() {
		return PageSize;
	}

	public void setPageSize(int pageSize) {
		this.PageSize = pageSize;
		this.limitEnd = this.PageSize;
		countLimit();
	}
	
	private void countLimit(){
		if(this.PageSize != 0 && this.currentPage != 0){
			 this.limitStart = this.PageSize  * (this.currentPage -1);
		}
	}

	public int getLimitStart() {
		return limitStart;
	}

	public int getLimitEnd() {
		return limitEnd;
	}
		
}

