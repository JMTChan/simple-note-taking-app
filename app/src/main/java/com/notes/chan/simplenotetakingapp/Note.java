package com.notes.chan.simplenotetakingapp;

public class Note {
    private long id = -1;
    private String title = "";
    private String body = "";
    private String createdat = "";
    private String updatedat = "";


    public Note(long id, String title, String body, String createdat, String updatedat) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.createdat = createdat;
        this.updatedat = updatedat;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreatedat() {
        return createdat;
    }

    public void setCreatedat(String createdat) {
        this.createdat = createdat;
    }

    public String getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(String updatedat) {
        this.updatedat = updatedat;
    }

}
