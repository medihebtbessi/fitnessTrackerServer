package fitnesstrackerserver.controller;

import fitnesstrackerserver.dto.WorkoutDTO;
import fitnesstrackerserver.services.workout.WorkoutService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("*")
@Tag(name = "Workout Controller")
public class WorkoutController {

    private final WorkoutService workoutService;

    @PostMapping("/workout")
    @Operation(description = "method to add a new Workout")
    public ResponseEntity<?> postWorkout(@RequestBody WorkoutDTO workoutDTO){
        try {
            return ResponseEntity.ok(workoutService.postWorkout(workoutDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some thing wont wrong .");
        }
    }

    @GetMapping("/workouts")
    @Operation(description = "method to get all workouts")
    public ResponseEntity<?> getWorkouts(){
        try {
            return ResponseEntity.ok(workoutService.getWorkouts());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some thing wont wrong .");
        }
    }
}
