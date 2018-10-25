package com.byb.sc.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;


/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/10/25 上午9:35
 */

public class FindResultResponse extends MultiItemEntity {
    /**
     * who : 有时放纵
     * publishedAt : 2016-02-01T03:49:41.440Z
     * desc : 省时省力的Andbase功能组件
     * type : Android
     * url : http://www.finalshares.com/read-608
     * used : true
     * objectId : 56aec014816dfa00597ca4fd
     * createdAt : 2016-02-01T02:16:52.628Z
     * updatedAt : 2016-02-01T03:49:42.159Z
     */

    private String who;
    private String publishedAt;
    private String desc;
    private String type;
    private String url;
    private boolean used;
    private List<String> images;
    private String objectId;
    private String createdAt;
    private String updatedAt;
    private int height;


    public static int NO_PIC = 0;
    public static int ONE_PIC = 1;
    public static int MORE_PIC = 2;

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public int getItemType() {
        if (images == null || images.size() == 0) {
            return NO_PIC;
        } else {
            if(images.size() == 1) {
                return ONE_PIC;
            } else {
                return MORE_PIC;
            }
        }
    }
}
