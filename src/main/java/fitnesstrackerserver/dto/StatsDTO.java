package fitnesstrackerserver.dto;

import lombok.Data;

@Data
public class StatsDTO {

    private Long achievedGoals;
    private Long notAchievedGoals;
    private int steps;
    private Double distance;
    private int totalCaloriesBurned;
    private int duration;

}
