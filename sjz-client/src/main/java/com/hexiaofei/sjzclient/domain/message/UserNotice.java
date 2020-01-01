package com.hexiaofei.sjzclient.domain.message;

import java.io.Serializable;
import java.util.Date;

public class UserNotice implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1752412577893180662L;

	/**
     *
     */
    private Integer id;

    /**
     *标题
     */
    private String title;

    /**
     *内容
     */
    private String content;

    /**
     *是否显示，默认是true(显示)
     */
    private Boolean isDisplay;

    /**
     *创建时间
     */
    private Date createTime;

    /**
     *
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *标题
     */
    public String getTitle() {
        return title;
    }

    /**
     *标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     *内容
     */
    public String getContent() {
        return content;
    }

    /**
     *内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     *是否显示，默认是true(显示)
     */
    public Boolean getIsDisplay() {
        return isDisplay;
    }

    /**
     *是否显示，默认是true(显示)
     */
    public void setIsDisplay(Boolean isDisplay) {
        this.isDisplay = isDisplay;
    }

    /**
     *创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
