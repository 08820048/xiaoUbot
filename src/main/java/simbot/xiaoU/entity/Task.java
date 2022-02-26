package simbot.xiaoU.entity;

import java.util.Date;

/**
 * @author: Tisox
 * @date: 2021/12/30 22:10
 * @description:
 * @blog:www.waer.ltd
 */
public class Task {
    private int id;
    private String contens;
    private String from;
    private Date times;

    public Task(){};

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", contens='" + contens + '\'' +
                ", from='" + from + '\'' +
                ", times=" + times +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContens() {
        return contens;
    }

    public void setContens(String contens) {
        this.contens = contens;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    public Task(int id, String contens, String from, Date times) {
        this.id = id;
        this.contens = contens;
        this.from = from;
        this.times = times;
    }
}
