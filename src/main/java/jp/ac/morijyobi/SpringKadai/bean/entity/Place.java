package jp.ac.morijyobi.SpringKadai.bean.entity;

import java.time.LocalDateTime;

public class Place {
    private int id;
    private String place_name;
    private LocalDateTime first_visit_date_time;
    private LocalDateTime last_visit_date_time;
    private String situation;

    public Place(int id, String place_name, LocalDateTime first_visit_date_time, LocalDateTime last_visit_date_time, String situation) {
        this.id = id;
        this.place_name = place_name;
        this.first_visit_date_time = first_visit_date_time;
        this.last_visit_date_time = last_visit_date_time;
        this.situation = situation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public LocalDateTime getFirst_visit_date_time() {
        return first_visit_date_time;
    }

    public void setFirst_visit_date_time(LocalDateTime first_visit_date_time) {
        this.first_visit_date_time = first_visit_date_time;
    }

    public LocalDateTime getLast_visit_date_time() {
        return last_visit_date_time;
    }

    public void setLast_visit_date_time(LocalDateTime last_visit_date_time) {
        this.last_visit_date_time = last_visit_date_time;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }
}
