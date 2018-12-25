/*
 * Copyright (c) 2018/12/24
 *  By 葛超2016020900030 徐慧东2016020800168
 *  @https://STVEA.cn
 */

//json {id,title,introduce,likes}

package cn.stvea.stoneopen;

public class Answer {
    public int id;
    public int likes;
    public String texts;

    public Answer(int id, int likes, String texts) {
        this.id = id;
        this.likes = likes;
        this.texts = texts;
    }

    public int getId() {
        return id;
    }

    public int getLikes() {
        return likes;
    }

    public String getTexts() {
        return texts;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setTexts(String texts) {
        this.texts = texts;
    }
}
