package com.github.tieba.model;

import java.io.Serializable;

public class Replyer implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private String id;
    
    private String name;
    
    private String portrait;
    
    private String is_friend;
    
    private String name_show;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getIs_friend() {
        return is_friend;
    }

    public void setIs_friend(String is_friend) {
        this.is_friend = is_friend;
    }

    public String getName_show() {
        return name_show;
    }

    public void setName_show(String name_show) {
        this.name_show = name_show;
    }

}
