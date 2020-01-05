package com.hexiaofei.sjzclient.vo;

import java.io.Serializable;

public class PageIndex implements Serializable{
	private static final long serialVersionUID = -956277890632601252L;
	private int startIndex;
	private int endIndex;
	private int pages[];
	
	public PageIndex(int startindex, int endIndex) {
		this.startIndex = startindex;
		this.endIndex = endIndex;
	}

	public PageIndex(int startindex, int endIndex, int[] pages) {
		this.startIndex = startindex;
		this.endIndex = endIndex;
		this.pages = pages;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}


	public int[] getPages() {
		return pages;
	}

	public static PageIndex getPageIndex(int viewpagecount, int currentPage, int totalpage){
		int startpage = currentPage-(viewpagecount%2==0? viewpagecount/2-1 : viewpagecount/2);
		int endpage = currentPage+viewpagecount/2;
		if(startpage<1){
			startpage = 1;
			if(totalpage>=viewpagecount) endpage = viewpagecount;
			else endpage = totalpage;
		}
		if(endpage>totalpage){
			endpage = totalpage;
			if((endpage-viewpagecount)>0) startpage = endpage-viewpagecount+1;
			else startpage = 1;
		}
		int[] pages = new int[endpage-startpage+1];

		for(int i = 0 ; i < pages.length ; i++ ){
			pages[i] = startpage+i;
		}

		return new PageIndex(startpage, endpage, pages);
	}
}
