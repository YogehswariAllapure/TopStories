package in.andriod.heady.assessmenttest;



public class TopStories {


    private String section, title, desc ,published;


    public TopStories(String section, String title, String desc, String published) {
        this.section = section;
        this.title = title;
        this.desc = desc;
        this.published = published;
    }

    public String getSection() {
        return section;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getPublished() {
        return published;
    }
}