package com.example.vo;

public class ChannelVO {
    private String ch_url;
    private int monthView;
    private String ch_name;
    private int sub;
    private String regdate;
    private double totView;
    private String category;
    private String contact;
    private String fan;
    private int insta;
    private int upload;
    private String img;
    private int adcount;
    private int adMaxView;
    private int adMinView;
    private int adAvgView;
    private int adSumView;
    private int adMaxComment;
    private int adMinComment;
    private int adAvgComment;
    private int adSumComment;

    public int getAdcount() {
        return this.adcount;
    }

    public void setAdcount(int adcount) {
        this.adcount = adcount;
    }

    public int getAdMaxView() {
        return this.adMaxView;
    }

    public void setAdMaxView(int adMaxView) {
        this.adMaxView = adMaxView;
    }

    public int getAdMinView() {
        return this.adMinView;
    }

    public void setAdMinView(int adMinView) {
        this.adMinView = adMinView;
    }

    public int getAdAvgView() {
        return this.adAvgView;
    }

    public void setAdAvgView(int adAvgView) {
        this.adAvgView = adAvgView;
    }

    public int getAdSumView() {
        return this.adSumView;
    }

    public void setAdSumView(int adSumView) {
        this.adSumView = adSumView;
    }

    public int getAdMaxComment() {
        return this.adMaxComment;
    }

    public void setAdMaxComment(int adMaxComment) {
        this.adMaxComment = adMaxComment;
    }

    public int getAdMinComment() {
        return this.adMinComment;
    }

    public void setAdMinComment(int adMinComment) {
        this.adMinComment = adMinComment;
    }

    public int getAdAvgComment() {
        return this.adAvgComment;
    }

    public void setAdAvgComment(int adAvgComment) {
        this.adAvgComment = adAvgComment;
    }

    public int getAdSumComment() {
        return this.adSumComment;
    }

    public void setAdSumComment(int adSumComment) {
        this.adSumComment = adSumComment;
    }

    public String getCh_url() {
        return this.ch_url;
    }

    public void setCh_url(String ch_url) {
        this.ch_url = ch_url;
    }

    public int getMonthView() {
        return this.monthView;
    }

    public void setMonthView(int monthView) {
        this.monthView = monthView;
    }

    public String getCh_name() {
        return this.ch_name;
    }

    public void setCh_name(String ch_name) {
        this.ch_name = ch_name;
    }

    public int getSub() {
        return this.sub;
    }

    public void setSub(int sub) {
        this.sub = sub;
    }

    public String getRegdate() {
        return this.regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public double getTotView() {
        return this.totView;
    }

    public void setTotView(double totView) {
        this.totView = totView;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFan() {
        return this.fan;
    }

    public void setFan(String fan) {
        this.fan = fan;
    }

    public int getInsta() {
        return this.insta;
    }

    public void setInsta(int insta) {
        this.insta = insta;
    }

    public int getUpload() {
        return this.upload;
    }

    public void setUpload(int upload) {
        this.upload = upload;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    /*
        여기서부터는 크리테리아 부분 붙여놓음
    */
    private int page;  	
	private int perPageNum; 
	
	public ChannelVO() {
		this.page = 1;
		this.perPageNum = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}
		
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		
		if(perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		
		this.perPageNum = perPageNum;
	}
	
	public int getPageStart() {
		return (this.page -1) * perPageNum;
	}
	

	
	public String toString() {
		return "ChannelVO [page=" + page + ", perPageNum=" + perPageNum + "]";
	}

    


}
