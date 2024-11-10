package fitnesstrackerserver.services.activity;

import fitnesstrackerserver.dto.ActivityDTO;

import java.util.List;

public interface ActivityService {
    public ActivityDTO postActivity(ActivityDTO dto);
    public List<ActivityDTO> getAllActivities();
}
