package be.qnh.bootlegs.service;

import be.qnh.bootlegs.domain.Concert;
import be.qnh.bootlegs.domain.RecordingQuality;

import java.time.LocalDate;

public interface ConcertService {

    // crud methods
    Concert addOne(Concert concert);

    Iterable<Concert> findAll();

    Concert findOneById(Long id);

    Concert udpdateOneById(Long id, Concert concert);

    Concert deleteOneById(Long id);

    // end crud methods ///////////////////////////////////////////

    Concert findByDateEquals(LocalDate date);

    Iterable<Concert> findByTitleLikeIgnoreCase(String title);

    Iterable<Concert> findByCountryLikeIgnoreCase(String country);

    Iterable<Concert> findByCityLikeIgnoreCase(String city);

    Iterable<Concert> findByRecordingQuality(RecordingQuality quality);
}
