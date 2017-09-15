package com.avalon.entity;

/**
 * 
 * @类名: Greeting
 * @功能描述:实体类
 * @类创建人: Evan
 * @类创建时间： 2016-8-17 上午10:25:49
 */
public class Greeting {
    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
