package be.qnh.bootlegs.domain;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Track extends AbstractEntity {

    @NotNull
    private int sequenceNr;
    @NotNull
    private String title;
    @NotNull
    private String locationUrl;

    // constructor
    public Track() {
    }

    // getters and setters
    public int getSequenceNr() {
        return sequenceNr;
    }

    public void setSequenceNr(int sequenceNr) {
        this.sequenceNr = sequenceNr;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocationUrl() {
        return locationUrl;
    }

    public void setLocationUrl(String locationUrl) {
        this.locationUrl = locationUrl;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Track)) return false;
        Track track = (Track) o;
        return Objects.equals(getTitle(), track.getTitle()) &&
                Objects.equals(getLocationUrl(), track.getLocationUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getLocationUrl());
    }
}
