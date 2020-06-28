package com.example.internship;

public class posthome { private String id;
    private String title;
    private String subtitle;
    private String desc;
    private String postedby;

    public posthome(String id, String title, String subtitle, String desc, String postedby) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.desc = desc;
        this.postedby = postedby;

    }


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getDesc() {
        return desc;
    }

    public String getPostedby() {
        return postedby;
    }


}

