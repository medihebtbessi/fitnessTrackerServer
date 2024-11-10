package fitnesstrackerserver.services.activity;

import fitnesstrackerserver.dto.ActivityDTO;
import fitnesstrackerserver.entity.Activity;
import fitnesstrackerserver.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService{
    private final ActivityRepository activityRepository;

    public ActivityDTO postActivity(ActivityDTO dto){
        Activity activity=new Activity();
        activity.setDate(dto.getDate());
        activity.setSteps(dto.getSteps());
        activity.setDistance(dto.getDistance());
        activity.setCaloriesBurned(dto.getCaloriesBurned());
        return activityRepository.save(activity).getActivityDTO();
    }
    public List<ActivityDTO> getAllActivities(){
       List<Activity> activities=activityRepository.findAll();
       return activities.stream().map(Activity::getActivityDTO).toList();
    }
}
