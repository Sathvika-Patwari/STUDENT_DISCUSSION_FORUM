package com.example.internship;
public class ActoresList {
    private String post_title, post_desc, posted_by;

    public ActoresList(String post_title, String post_desc, String posted_by) {
        this.post_title = post_title;
        this.post_desc = post_desc;
        this.posted_by = posted_by;
    }

    public String getPost_title() {
        return post_title;
    }

    public String getPost_desc() {
        return post_desc;
    }

    public String getPosted_by() {
        return posted_by;
    }
}