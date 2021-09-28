package com.example.vo;

public class adVO {
    private String ad_url;
    private String ch_url;
    private String name;
    private String upday;
    private String category;
    private int likecnt;
    private int dislike;
    private double ratio;
    private int click;
    private int comment;
    private String hashtag;
    private String descript;
    private Double foreign;

    public Double getForeign() {
        return this.foreign;
    }

    public void setForeign(Double foreign) {
        this.foreign = foreign;
    }

    public String getHashtag() {
        return this.hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public String getDescript() {
        return this.descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getAd_url() {
        return this.ad_url;
    }

    public void setAd_url(String ad_url) {
        this.ad_url = ad_url;
    }

    public String getCh_url() {
        return this.ch_url;
    }

    public void setCh_url(String ch_url) {
        this.ch_url = ch_url;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpday() {
        return this.upday;
    }

    public void setUpday(String upday) {
        this.upday = upday;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getLikecnt() {
        return this.likecnt;
    }

    public void setLikecnt(int likecnt) {
        this.likecnt = likecnt;
    }

    public int getDislike() {
        return this.dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public double getRatio() {
        return this.ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public int getClick() {
        return this.click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public int getComment() {
        return this.comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    /** 
     * 여기서 부터 페이지 메이커 부분
     * 
    */

    private int page;  	
	private int perPageNum; 
	
	public adVO() {
		this.page = 1;
		this.perPageNum = 5;
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
			this.perPageNum = 5;
			return;
		}
		
		this.perPageNum = perPageNum;
	}
	
	public int getPageStart() {
		return (this.page -1) * perPageNum;
	}
	

	
	public String toString() {
		return "adVO [page=" + page + ", perPageNum=" + perPageNum + "]";
	}

}
