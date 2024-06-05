package jp.ac.morijyobi.SpringKadai.bean.form;

import java.time.LocalDateTime;

public class PlaceForm {
    private String placeName;
    private LocalDateTime firstVisitDateTime;
    private LocalDateTime lastVisitDateTime;
    private String situation;

    public PlaceForm(String placeName, LocalDateTime firstVisitDateTime, LocalDateTime lastVisitDateTime, String situation) {
        this.placeName = placeName;
        this.firstVisitDateTime = firstVisitDateTime;
        this.lastVisitDateTime = lastVisitDateTime;
        this.situation = situation;
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
