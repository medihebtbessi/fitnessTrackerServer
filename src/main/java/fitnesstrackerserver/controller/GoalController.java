package fitnesstrackerserver.controller;

import fitnesstrackerserver.dto.GoalDTO;
import fitnesstrackerserver.services.goal.GoalService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
@Tag(name = "Goal Controller")
public class GoalController {

    private final GoalService goalService;

    @PostMapping("/goal")
    public ResponseEntity<?> postGoal(@RequestBody GoalDTO dto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(goalService.postGoal(dto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/goals")
    public ResponseEntity<?> getGoals(){
        try {
            return ResponseEntity.ok(goalService.getGoals());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some thing wont wrong .");
        }
    }

    @GetMapping("/goal/status/{id}")
    public ResponseEntity<?> updateGoal(@PathVariable("id")  Long id){
        try {
            return ResponseEntity.ok(goalService.updateStatus(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
