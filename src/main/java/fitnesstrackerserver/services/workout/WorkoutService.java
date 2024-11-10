package fitnesstrackerserver.services.workout;

import fitnesstrackerserver.dto.WorkoutDTO;

import java.util.List;

public interface WorkoutService {
    public WorkoutDTO postWorkout(WorkoutDTO workoutDTO);
    public List<WorkoutDTO> getWorkouts();

}
