package com.group53.beans;

public class Subject {

    private static long subjectID = 0;

    private long id;
    private String title;

    public Subject(long id, String title) {

        subjectID ++;
        this.id = subjectID;
        this.title = title;
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
