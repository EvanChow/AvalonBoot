package com.avalon.entity.quartz;

import java.io.Serializable;
import java.util.Date;

public class ScheduleJob implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -9036427526710160900L;

    /** 任务id */
    private String id;

    /** 任务名称 */
    private String name;

    /** 任务别名 */
    private String aliasName;

    /** 任务分组 */
    private String group;

    /** 触发器 */
    private String  jobTrigger;

    /** 任务状态 */
    private String  status;

    /** 任务运行时间表达式 */
    private String  cronExpression;

    /** 是否异步 */
    private Boolean  isSync;

    /** 任务描述 */
    private String  description;

    /** 创建时间 */
    private Date  create;

    /** 修改时间 */
    private Date  modify;
    /**
     * 要执行的任务类
     */
    private String  classname;
    private String  classnamesync;
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
    public String getAliasName() {
        return aliasName;
    }
    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }
    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }
    public String getJobTrigger() {
        return jobTrigger;
    }
    public void setJobTrigger(String jobTrigger) {
        this.jobTrigger = jobTrigger;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getCronExpression() {
        return cronExpression;
    }
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }
    public Boolean getIsSync() {
        return isSync;
    }
    public void setIsSync(Boolean isSync) {
        this.isSync = isSync;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getCreate() {
        return create;
    }
    public void setCreate(Date create) {
        this.create = create;
    }
    public Date getModify() {
        return modify;
    }
    public void setModify(Date modify) {
        this.modify = modify;
    }
    public String getClassname() {
        return classname;
    }
    public void setClassname(String classname) {
        this.classname = classname;
    }
    public String getClassnamesync() {
        return classnamesync;
    }
    public void setClassnamesync(String classnamesync) {
        this.classnamesync = classnamesync;
    }
  
    public String toString(){
        return "{id:"+id+",name:"+name+",aliasName:"+aliasName+",group:"+group+",status:"+status+",cronExpression:"+cronExpression+"}";
    }

}
