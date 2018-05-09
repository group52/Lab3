package com.group53.beans;

public class Subject {
    private long id;
    private String title;
    private float mark;

    public Subject(long id, String title, float mark) {
        this.id = id;
        this.title = title;
        this.mark = mark;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
