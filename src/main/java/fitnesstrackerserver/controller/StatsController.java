package fitnesstrackerserver.controller;

import fitnesstrackerserver.dto.GraphDTO;
import fitnesstrackerserver.services.stats.StatsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
@Tag(name = "Stats Controller")
public class StatsController {


    private final StatsService statsService ;

    @GetMapping("/stats")
    public ResponseEntity<?> getStats(){
        return ResponseEntity.ok(statsService.getStats());
    }

    @GetMapping("/graphs")
    public ResponseEntity<?> getGraphStats(){
        GraphDTO graphDTO=statsService.getGraphStats();
        if (graphDTO!=null){
            return ResponseEntity.ok(graphDTO);
        }else {
            return ResponseEntity.status(404).body(null);
        }
    }

}
