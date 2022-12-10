package com.example.libraryapp.models;

import java.sql.Date;

public class Notification {
    private long id;
    private long ownerId;
    private String text;
    private Date timeToLive;
    private Date timeStamp;
    private boolean isSeen;

    public Notification(long id, long ownerId, String text, Date timeToLive, Date timeStamp, boolean isSeen) {
        this.id = id;
        this.ownerId = ownerId;
        this.text = text;
        this.timeToLive = timeToLive;
        this.timeStamp = timeStamp;
        this.isSeen = isSeen;
    }

    public long getId() {
        return id;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public String getText() {
        return text;
    }

    public Date getTimeToLive() {
        return timeToLive;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public boolean isSeen() {
        return isSeen;
    }
}
