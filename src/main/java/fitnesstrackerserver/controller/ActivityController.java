package fitnesstrackerserver.controller;

import fitnesstrackerserver.dto.ActivityDTO;
import fitnesstrackerserver.services.activity.ActivityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
@Tag(name = "Activity controller")
public class ActivityController {
    private final ActivityService activityService;
    @PostMapping("/activity")
    @Operation(description = "operation pour ajouté une nouvelle activité ")
    public ResponseEntity<?> postActivity(@RequestBody ActivityDTO dto){
        ActivityDTO createdActivity=activityService.postActivity(dto);
        if (createdActivity!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createdActivity);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some thing went wrong .");
        }
    }

    @GetMapping("activities")
    public ResponseEntity<?> getAllActivities(){
        try {
            return ResponseEntity.ok(activityService.getAllActivities());

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some thing went wrong .");
        }
    }
}
