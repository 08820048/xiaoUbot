package simbot.xiaoU.entity;

import java.util.Date;

/**
 * @author: Tisox
 * @date: 2021/12/30 22:07
 * @description:
 * @blog:www.waer.ltd
 */
public class Answer {
    private int id;
    private String title;
    private String answer;
    private Date times;
    private String code;

    public Answer(){};

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", answer='" + answer + '\'' +
                ", times=" + times +
                ", code='" + code + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Answer(int id, String title, String answer, Date times, String code) {
        this.id = id;
        this.title = title;
        this.answer = answer;
        this.times = times;
        this.code = code;
    }
}
