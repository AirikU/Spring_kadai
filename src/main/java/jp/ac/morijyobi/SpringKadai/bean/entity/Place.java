package jp.ac.morijyobi.SpringKadai.bean.entity;

import java.time.LocalDateTime;

public class Place {
    private int id;
    private String placeName;
    private LocalDateTime firstVisitDateTime;
    private LocalDateTime lastVisitDateTime;
    private String situation;

    public Place(int id, String placeName, LocalDateTime firstVisitDateTime, LocalDateTime lastVisitDateTime, String situation) {
        this.id = id;
        this.placeName = placeName;
        this.firstVisitDateTime = firstVisitDateTime;
        this.lastVisitDateTime = lastVisitDateTime;
        this.situation = situation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public LocalDateTime getFirstVisitDateTime() {
        return firstVisitDateTime;
    }

    public void setFirstVisitDateTime(LocalDateTime firstVisitDateTime) {
        this.firstVisitDateTime = firstVisitDateTime;
    }

    public LocalDateTime getLastVisitDateTime() {
        return lastVisitDateTime;
    }

    public void setLastVisitDateTime(LocalDateTime lastVisitDateTime) {
        this.lastVisitDateTime = lastVisitDateTime;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }
}
