package be.qnh.bootlegs.domain;

import be.qnh.bootlegs.repository.TourRepository;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.beans.Transient;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CreateTourIT {

    @Autowired
    private TourPersister tourPersister;

    @Autowired
    private ConcertPersister concertPersister;

    @Autowired
    private TourRepository tourRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void createTour() {
        Tour tour = tourPersister.init().get();

    }

    @Test
    @Transactional
    public void createTourWithConcerts() {
        Tour tour = tourPersister.init().get();
        Concert concert = concertPersister.init().tour(tour).get();

        //because we want to force a DB call to fetch the Tour from the db, we need to clear the entity manager
        //to make sure the tour isnt fetched from second level cache
        flushAndClear();

        //check the logs, next line triggers select statements, while putting the flushAndClear line in comment,
        //there will no db calls with the next line because the tour to be fetched is still in memory

        Tour tourDB = tourRepository.getOne(tour.getId());


        assertThat(tourDB.getConcertList().size(), is(1));

    }

    private void flushAndClear() {
        entityManager.flush();
        entityManager.clear();
    }


}
