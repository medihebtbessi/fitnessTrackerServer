package fitnesstrackerserver.repository;

import fitnesstrackerserver.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GoalRepository extends JpaRepository<Goal,Long> {
    @Query("select count (g) from Goal g where g.achieved=true" )
    Long countAchievedGoals();

    @Query("select count (g) from Goal g where g.achieved= false ")
    Long countNotAchievedGoals();
}
