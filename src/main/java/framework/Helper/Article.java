package framework.Helper;

import java.util.List;

public class Article {

    private boolean isPromo;
    private boolean isPublished;
    private int position;
    private String requireTime;
    private String title;
    private String autor;
    private String person;
    private String lead;
    private List<Integer> tags;
    private String readMore;
    public String leadImg;
    private String img_25;
    private String img_100;
    private String img_200;


    public Article() {
        leadImg = "C:\\AA\\1.jpg";
    }

    public void setInvalidArticle() {
        requireTime = "";
        title = "";
        autor = "";
        person = "";
        lead = "";
        readMore = "";
    }

    public void setMiddleArticle() {
        requireTime = "123qwe";
        title = "123qwe";
        autor = "123qwe";
        person = "123qwe";
        lead = "123qwe";
        readMore = "123qwe";
    }

    public boolean isPromo() {
        return isPromo;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public int getPosition() {
        return position;
    }

    public String getRequireTime() {
        return requireTime;
    }

    public String getTitle() {
        return title;
    }

    public String getAutor() {
        return autor;
    }

    public String getPerson() {
        return person;
    }

    public String getLead() {
        return lead;
    }

    public List<Integer> getTags() {
        return tags;
    }

    public String getReadMore() {
        return readMore;
    }

    public String getLeadImg() {
        return leadImg;
    }

    public String getImg_25() {
        return img_25;
    }

    public String getImg_100() {
        return img_100;
    }

    public String getImg_200() {
        return img_200;
    }

}
