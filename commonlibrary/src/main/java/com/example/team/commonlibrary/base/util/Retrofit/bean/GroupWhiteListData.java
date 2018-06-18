package com.example.team.commonlibrary.base.util.Retrofit.bean;

import java.util.List;

/**
 * Created by 邹特强 on 2018/6/18.
 * 群体白名单对应的javabean信息类
 */

public class GroupWhiteListData {
    /**
     * 群组id
     */
    String groupId;
    /**
     * 参与自习的用户列表
     */
    List<User> idList;
    /**
     * 应用白名单列表
     */
    List<String> applications;
    /**
     * 自习开始时间
     */
    String beginTime;
    /**
     * 自习持续时间
     */
    long continueTime;
    /**
     * 是否是群主
     */
    String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<User> getIdList() {

        return idList;
    }

    public void setIdList(List<User> idList) {
        this.idList = idList;
    }

    public String getGroupId() {

        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public long getContinueTime() {

        return continueTime;
    }

    public void setContinueTime(long continueTime) {
        this.continueTime = continueTime;
    }

    public String getBeginTime() {

        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public List<String> getApplications() {

        return applications;
    }

    public void setApplications(List<String> applications) {
        this.applications = applications;
    }
}
