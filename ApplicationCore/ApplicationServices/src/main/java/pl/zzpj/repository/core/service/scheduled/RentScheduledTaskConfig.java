package pl.zzpj.repository.core.service.scheduled;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import pl.zzpj.repository.ports.command.rent.RentCommandService;

@Configuration
@AllArgsConstructor
public class RentScheduledTaskConfig {
    private final RentCommandService commandService;

    @Scheduled(fixedDelayString = "${schedule.time.ms:300000}")
    public void updateRentsNotIssued() {
        commandService.updateRentsNotIssued();
    }
}
