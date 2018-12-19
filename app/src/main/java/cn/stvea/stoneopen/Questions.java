/*
 * Copyright (c) 2018/12/18
 *  By 葛超2016020900030 徐慧东2016020800168
 *  @https://STVEA.cn
 */

//json {id,title,introduce,likes}

package cn.stvea.stoneopen;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.util.logging.LogRecord;

public class Questions {
    public int id;
    public String introduce;
    public String title;
    public int likes;
    public String texts;

    public Questions(int id, String introduce, String title, int likes) {
        this.id = id;
        this.introduce = introduce;
        this.title = title;
        this.likes = likes;
    }

    public Questions(int id, String introduce, String title, int likes, String texts) {
        this.id = id;
        this.introduce = introduce;
        this.title = title;
        this.likes = likes;
        this.texts = texts;
    }

    public void setText(String texts) {
        this.texts = texts;
    }

    public String getTexts() {

        return texts;
    }

    public int getId() {
        return id;
    }

    public String getIntroduce() {
        return introduce;
    }

    public String getTitle() {
        return title;
    }

    public int getLikes() {
        return likes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
