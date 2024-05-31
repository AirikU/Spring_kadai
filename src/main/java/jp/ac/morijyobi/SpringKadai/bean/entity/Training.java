package jp.ac.morijyobi.SpringKadai.bean.entity;

import java.time.LocalDateTime;

public class Training {
    private int id;
    private String title;
    private LocalDateTime startDateTime;
    private int reserved;

    public Training(int id, String title, LocalDateTime startDateTime, int reserved) {
        this.id = id;
        this.title = title;
        this.startDateTime = startDateTime;
        this.reserved = reserved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public int getReserved() {
        return reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }
}
