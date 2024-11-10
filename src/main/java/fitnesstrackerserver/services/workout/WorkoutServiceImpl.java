package fitnesstrackerserver.services.workout;

import fitnesstrackerserver.dto.WorkoutDTO;
import fitnesstrackerserver.entity.Workout;
import fitnesstrackerserver.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutServiceImpl implements WorkoutService{

    private final WorkoutRepository workoutRepository;
    public WorkoutDTO postWorkout(WorkoutDTO workoutDTO){
        Workout workout=new Workout();
        workout.setDate(workoutDTO.getDate());
        workout.setType(workoutDTO.getType());
        workout.setDuration(workoutDTO.getDuration());
        workout.setCaloriesBurned(workoutDTO.getCaloriesBurned());
        return workoutRepository.save(workout).getWorkoutDto();
    }

    public List<WorkoutDTO> getWorkouts(){
        List<Workout> workouts=workoutRepository.findAll();

        return workouts.stream().map(Workout::getWorkoutDto).toList();
    }
}
