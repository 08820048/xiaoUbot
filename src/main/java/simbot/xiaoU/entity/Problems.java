package simbot.xiaoU.entity;

import java.util.Date;

/**
 * @author: Tisox
 * @date: 2021/12/30 21:31
 * @description:
 * @blog:www.waer.ltd
 */
public class Problems {
    private int id;
    private int code;
    private String title;
    private String content;
    private Date times;
    private String images;
    private String from;

    public Problems() {

    }

    @Override
    public String toString() {
        return "Problems{" +
                "id=" + id +
                ", code=" + code +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", times=" + times +
                ", images='" + images + '\'' +
                ", from='" + from + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Problems(int id, int code, String title, String content, Date times, String images, String from) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.content = content;
        this.times = times;
        this.images = images;
        this.from = from;
    }
}
