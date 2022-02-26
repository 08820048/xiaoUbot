package simbot.xiaoU.entity;

/**
 * @author: Tisox
 * @date: 2021/12/30 22:09
 * @description:
 * @blog:www.waer.ltd
 */
public class Group {
    private int id;
    private String number;
    private int authorization;

    public Group(){};

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", authorization=" + authorization +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getAuthorization() {
        return authorization;
    }

    public void setAuthorization(int authorization) {
        this.authorization = authorization;
    }

    public Group(int id, String number, int authorization) {
        this.id = id;
        this.number = number;
        this.authorization = authorization;
    }
}
