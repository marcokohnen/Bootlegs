package be.qnh.bootlegs.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TOUR")
public class Tour extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 5549479803124945766L;

    @NotNull
    private String title;
    @NotNull
    private int startyear;
    private int endYear;
    @NotNull
    private int leg;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Continent continent;


    // field(s) with mapping(s)

    // One Tour has many concerts
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "TOUR_ID") //@Joincolumn zorgt voor een foreignkey in de tabel concert, zonder deze annotatie wordt er een tussentabel Tour_Concerts gemaakt
    private List<Concert> concertList = new ArrayList<>();


    public void addConcert(Concert concert) {
        concertList.add(concert);
    }


    // constructor
    public Tour() {
    }

    private Tour(Builder builder) {
        setTitle(builder.title);
        setStartyear(builder.startyear);
        setEndYear(builder.endYear);
        setLeg(builder.leg);
        setContinent(builder.continent);
        setConcertList(builder.concertList);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    // getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStartyear() {
        return startyear;
    }

    public void setStartyear(int startyear) {
        this.startyear = startyear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public int getLeg() {
        return leg;
    }

    public void setLeg(int leg) {
        this.leg = leg;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public List<Concert> getConcertList() {
        return concertList;
    }

    public void setConcertList(List<Concert> concerts) {
        this.concertList = concerts;
    }

    // toString
    @Override
    public String toString() {
        return "Tour{" +
                "title='" + title + '\'' +
                ", startyear=" + startyear +
                ", endYear=" + endYear +
                ", leg=" + leg +
                ", continent=" + continent +
                '}';
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tour)) return false;
        Tour tour = (Tour) o;
        return getStartyear() == tour.getStartyear() &&
                getEndYear() == tour.getEndYear() &&
                getLeg() == tour.getLeg() &&
                Objects.equals(getTitle(), tour.getTitle()) &&
                getContinent() == tour.getContinent();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getStartyear(), getEndYear(), getLeg(), getContinent());
    }


    public static final class Builder {
        private @NotNull String title;
        private @NotNull int startyear;
        private int endYear;
        private @NotNull int leg;
        private @NotNull Continent continent;
        private List<Concert> concertList = new ArrayList<>(           );

        private Builder() {
        }

        public Builder title(@NotNull String val) {
            title = val;
            return this;
        }

        public Builder startyear(@NotNull int val) {
            startyear = val;
            return this;
        }

        public Builder endYear(int val) {
            endYear = val;
            return this;
        }

        public Builder leg(@NotNull int val) {
            leg = val;
            return this;
        }

        public Builder continent(@NotNull Continent val) {
            continent = val;
            return this;
        }

        public Builder concertList(List<Concert> val) {
            concertList = val;
            return this;
        }

        public Tour build() {
            return new Tour(this);
        }
    }
}
