package fitnesstrackerserver.services.stats;

import fitnesstrackerserver.dto.GraphDTO;
import fitnesstrackerserver.dto.StatsDTO;
import fitnesstrackerserver.entity.Activity;
import fitnesstrackerserver.entity.Workout;
import fitnesstrackerserver.repository.ActivityRepository;
import fitnesstrackerserver.repository.GoalRepository;
import fitnesstrackerserver.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor

public class StatsServiceImpl implements StatsService{

    private final GoalRepository goalRepository;
    private final ActivityRepository activityRepository;
    private final WorkoutRepository workoutRepository;

    public StatsDTO getStats(){
        Long achievedGoals=goalRepository.countAchievedGoals();
        Long notAchievedGoals=goalRepository.countNotAchievedGoals();
        Integer totalSteps=activityRepository.getTotalSteps();
        Double totalDistance=activityRepository.getTotalDistance();
        Integer totalActivityCaloriesBurned=activityRepository.getTotalActivityCalories();
        Integer totalWorkoutDuration=workoutRepository.getTotalDuration();
        Integer totalWorkoutCaloriesBurned=workoutRepository.getTotalCaloriesBurned();

        int totalCaloriesBurned=(totalActivityCaloriesBurned!=null?totalActivityCaloriesBurned:0)+(totalWorkoutCaloriesBurned!=null?totalWorkoutCaloriesBurned:0);

        StatsDTO dto=new StatsDTO();
        dto.setAchievedGoals(achievedGoals!=null?achievedGoals:0);
        dto.setNotAchievedGoals(notAchievedGoals!=null?notAchievedGoals:0);
        dto.setSteps(totalSteps!=null?totalSteps:0);
        dto.setDistance(totalDistance!=null?totalDistance:0);
        dto.setTotalCaloriesBurned(totalCaloriesBurned);
        dto.setDuration(totalWorkoutDuration!=null?totalWorkoutDuration:0);
        return dto;
    }

    public GraphDTO getGraphStats(){
        Pageable pageable= PageRequest.of(0,7);
        List<Workout> workouts=workoutRepository.findLast7Workouts(pageable);
        List<Activity> activities=activityRepository.findLast7Activities(pageable);
        GraphDTO graphDTO=new GraphDTO();
        graphDTO.setWorkouts(workouts.stream().map(Workout::getWorkoutDto).toList());
        graphDTO.setActivities(activities.stream().map(Activity::getActivityDTO).toList());
        return graphDTO;
    }
}
