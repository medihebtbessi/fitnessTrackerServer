package fitnesstrackerserver.services.goal;

import fitnesstrackerserver.dto.GoalDTO;

import java.util.List;

public interface GoalService {
    public GoalDTO postGoal(GoalDTO dto);
    public List<GoalDTO> getGoals();
    public GoalDTO updateStatus(Long id);
}
