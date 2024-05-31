package jp.ac.morijyobi.SpringKadai.bean.form;

import java.time.LocalDateTime;

public class TrainingForm {
    private String title;
    private LocalDateTime startDateTime;
    private int reserved;

    public TrainingForm(String title, LocalDateTime startDateTime, int reserved) {
        this.title = title;
        this.startDateTime = startDateTime;
        this.reserved = reserved;
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
