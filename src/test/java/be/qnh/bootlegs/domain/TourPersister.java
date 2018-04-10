package be.qnh.bootlegs.domain;

import be.qnh.bootlegs.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TourPersister {

    @Autowired
    private TourRepository tourRepository;



    public TourMother init() {
        return new TourMother();
    }

    public class TourMother {


        private Continent continent = Continent.EUROPE;
        private Integer endYear = 2000;
        private Integer leg = 1;
        private Integer startYear = 2000;
        private String title = "title";


        public TourMother continent(Continent continent) {
            this.continent = continent;
            return this;
        }

        public TourMother endYear(Integer endYear) {
            this.endYear = endYear;
            return this;
        }

        public TourMother leg(Integer leg) {
            this.leg = leg;
            return this;
        }

        public TourMother startYear(Integer startYear) {
            this.startYear = startYear;
            return this;
        }

        public TourMother title(String title) {
            this.title = title;
            return this;
        }

        public Tour get() {
            return tourRepository.save(Tour.newBuilder()
                    .continent(continent)
                    .endYear(endYear)
                    .leg(leg)
                    .startyear(startYear)
                    .title(title)
                    .build());


        }
    }
}
