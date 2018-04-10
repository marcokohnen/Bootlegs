package be.qnh.bootlegs.domain;

import be.qnh.bootlegs.repository.ConcertRepository;
import be.qnh.bootlegs.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ConcertPersister {

    @Autowired
    private ConcertRepository concertRepository;



    public ConcertMother init() {
        return new ConcertMother();
    }

    public class ConcertMother {
        private String city = "city";
        private String country = "contry";
        private LocalDate date = LocalDate.now();
        private RecordingQuality recordingQuality = RecordingQuality.EXCELENT;
        private String title = "title";
        private String venue = "venue";
        private Tour tour ;

        public ConcertMother city(String city) {
            this.city = city;
            return this;
        }

        public ConcertMother country(String country) {
            this.country = country;
            return this;
        }

        public ConcertMother date(LocalDate date) {
            this.date = date;
            return this;
        }

        public ConcertMother recordingQuality(RecordingQuality recordingQuality) {
            this.recordingQuality = recordingQuality;
            return this;
        }

        public ConcertMother title(String title) {
            this.title = title;
            return this;
        }

        public ConcertMother venue(String venue) {
            this.venue = venue;
            return this;
        }

        public ConcertMother tour(Tour tour) {
            this.tour = tour;
            return this;
        }

        public Concert get() {


            Concert concert =  concertRepository.save(Concert.newBuilder()
                    .city(city)
                    .country(country)
                    .date(date)
                    .quality(recordingQuality)
                    .title(title)
                    .venue(venue)
                    .build());

            tour.addConcert(concert);

            return concert;
        }
    }
}
