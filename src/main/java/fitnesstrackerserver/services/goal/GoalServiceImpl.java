package fitnesstrackerserver.services.goal;

import fitnesstrackerserver.dto.GoalDTO;
import fitnesstrackerserver.dto.WorkoutDTO;
import fitnesstrackerserver.entity.Goal;
import fitnesstrackerserver.entity.Workout;
import fitnesstrackerserver.repository.GoalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GoalServiceImpl implements GoalService{

    private final GoalRepository goalRepository;

    public GoalDTO postGoal(GoalDTO dto){
        Goal goal =new Goal();
        goal.setDescription(dto.getDescription());
        goal.setStartDate(dto.getStartDate());
        goal.setEndDate(dto.getEndDate());
        goal.setAchieved(false);
        return goalRepository.save(goal).getGoalDto();

    }

    public List<GoalDTO> getGoals(){
        List<Goal> workouts=goalRepository.findAll();

        return workouts.stream().map(Goal::getGoalDto).toList();
    }

    public GoalDTO updateStatus(Long id){
        Optional<Goal> optionalGoal=goalRepository.findById(id);
        if (optionalGoal.isPresent()){
            Goal exitingGoal=optionalGoal.get();
            exitingGoal.setAchieved(true);
            return goalRepository.save(exitingGoal).getGoalDto();
        }
        throw new EntityNotFoundException("Goal not found");
    }
}
