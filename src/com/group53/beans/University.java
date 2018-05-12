package com.group53.beans;

public class University {

    private static long universityID = 0;

    public static byte admin_access_level = 1;
    public static byte tutor_access_level = 2;
    public static byte student_access_level = 3;

    protected long id;
    protected String title;
    private String login;
    private String password;

    public University(String title, String login, String password) {
        universityID ++;
        this.id = universityID;
        this.title = title;
        this.login = login;
        this.password = password;
    }

    public University(String title) {
        universityID ++;
        this.id = universityID;
        this.title = title;
    }


    public long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
