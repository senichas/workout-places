package ua.com.findcoach.workoutplaces.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ua.com.findcoach.workoutplaces.domain.Place;

import java.util.List;

public interface PlacesRepository extends CrudRepository<Place, Integer> {

    List<Place> findAll();

    @Query("SELECT p FROM Place p WHERE p.name = :name")
    List<Place> findPlacesByName(@Param("name") String name);
}
