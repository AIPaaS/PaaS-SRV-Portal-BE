package com.ai.paas.ipaas.user.utils;

public class PageUtils {
	public static int getTotalPages(int totalCount, int pageSize) {
		int totalPages = 0;
		if (totalCount % pageSize == 0) {
			totalPages = totalCount / pageSize;
		} else {
			totalPages = totalCount / pageSize + 1;
		}
		return totalPages;
	}
}
