package fitnesstrackerserver.services.stats;

import fitnesstrackerserver.dto.GraphDTO;
import fitnesstrackerserver.dto.StatsDTO;

public interface StatsService {

    public StatsDTO getStats();
    public GraphDTO getGraphStats();
}
