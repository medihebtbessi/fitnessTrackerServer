package fitnesstrackerserver.repository;

import fitnesstrackerserver.entity.Workout;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout,Long> {
    @Query("select sum(w.duration) from Workout  w")
    Integer getTotalDuration();

    @Query("select sum (w.caloriesBurned ) from Workout w")
    Integer getTotalCaloriesBurned();
    @Query("select w from Workout  w order by w.date desc ")
    List<Workout> findLast7Workouts(Pageable pageable);
}
