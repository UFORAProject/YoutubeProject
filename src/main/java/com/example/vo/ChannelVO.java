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
    private String tag;
    private int clust;
    private Double adavgview;
    private int adcount;

    public int getAdcount() {
        return this.adcount;
    }

    public void setAdcount(int adcount) {
        this.adcount = adcount;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getClust() {
        return this.clust;
    }

    public void setClust(int clust) {
        this.clust = clust;
    }

    public Double getAdavgview() {
        return this.adavgview;
    }

    public void setAdavgview(Double adavgview) {
        this.adavgview = adavgview;
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
