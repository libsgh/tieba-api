package com.github.libsgh.tieba.model;

import java.io.Serializable;

public class ReplyInfo implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private Replyer replyer;
    
    private QuoteUser quote_user;
    
    private String title;
    
    private String content;
    
    private String thread_id;
    
    private String post_id;
    
    private String time;
    
    private String quote_content;
    
    private String fname;
    
    private String is_floor;
    
    private String thread_type;

    public Replyer getReplyer() {
        return replyer;
    }

    public void setReplyer(Replyer replyer) {
        this.replyer = replyer;
    }

    public QuoteUser getQuote_user() {
        return quote_user;
    }

    public void setQuote_user(QuoteUser quote_user) {
        this.quote_user = quote_user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getThread_id() {
        return thread_id;
    }

    public void setThread_id(String thread_id) {
        this.thread_id = thread_id;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getQuote_content() {
        return quote_content;
    }

    public void setQuote_content(String quote_content) {
        this.quote_content = quote_content;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getIs_floor() {
        return is_floor;
    }

    public void setIs_floor(String is_floor) {
        this.is_floor = is_floor;
    }

    public String getThread_type() {
        return thread_type;
    }

    public void setThread_type(String thread_type) {
        this.thread_type = thread_type;
    }

	@Override
	public String toString() {
		return "ReplyInfo [replyer=" + replyer + ", quote_user=" + quote_user + ", title=" + title + ", content="
				+ content + ", thread_id=" + thread_id + ", post_id=" + post_id + ", time=" + time + ", quote_content="
				+ quote_content + ", fname=" + fname + ", is_floor=" + is_floor + ", thread_type=" + thread_type + "]";
	}

}
