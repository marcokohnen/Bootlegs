package be.qnh.bootlegs.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CONCERT")
public class Concert extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = -3050653212143377407L;

    // object fields
    @NotNull
    private LocalDate date;
    @NotNull
    private String title;
    private String country;
    private String city;
    private String venue;
    @Enumerated(EnumType.STRING)
    private RecordingQuality quality;

    // field(s) with mapping(s)

    // One Concert has many Tracks
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "Concert_ID")
    private List<Track> trackList;

    // constructor
    public Concert() {
    }

    private Concert(Builder builder) {
        setDate(builder.date);
        setTitle(builder.title);
        setCountry(builder.country);
        setCity(builder.city);
        setVenue(builder.venue);
        setQuality(builder.quality);
        setTrackList(builder.trackList);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    // getters and setters

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public RecordingQuality getQuality() {
        return quality;
    }

    public void setQuality(RecordingQuality quality) {
        this.quality = quality;
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }

    // toString
    @Override
    public String toString() {
        return "Concert{" +
                "date=" + date +
                ", title='" + title + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", venue='" + venue + '\'' +
                '}';
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        System.out.println("Entered Concert Equals");
        if (this == o) return true;
        if (!(o instanceof Concert)) return false;
        Concert concert = (Concert) o;
        return Objects.equals(getId(), concert.getId()) &&
                Objects.equals(getDate(), concert.getDate()) &&
                Objects.equals(getTitle(), concert.getTitle()) &&
                Objects.equals(getCountry(), concert.getCountry()) &&
                Objects.equals(getCity(), concert.getCity()) &&
                Objects.equals(getVenue(), concert.getVenue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getTitle(), getCountry(), getCity(), getVenue());
    }


    public static final class Builder {
        private @NotNull LocalDate date;
        private @NotNull String title;
        private String country;
        private String city;
        private String venue;
        private RecordingQuality quality;
        private List<Track> trackList;

        private Builder() {
        }

        public Builder date(@NotNull LocalDate val) {
            date = val;
            return this;
        }

        public Builder title(@NotNull String val) {
            title = val;
            return this;
        }

        public Builder country(String val) {
            country = val;
            return this;
        }

        public Builder city(String val) {
            city = val;
            return this;
        }

        public Builder venue(String val) {
            venue = val;
            return this;
        }

        public Builder quality(RecordingQuality val) {
            quality = val;
            return this;
        }

        public Builder trackList(List<Track> val) {
            trackList = val;
            return this;
        }

        public Concert build() {
            return new Concert(this);
        }
    }
}
