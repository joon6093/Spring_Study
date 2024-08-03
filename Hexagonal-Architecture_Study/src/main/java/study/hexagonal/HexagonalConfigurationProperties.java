package study.hexagonal;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "hexagonal")
public class HexagonalConfigurationProperties {

    private long transferThreshold = Long.MAX_VALUE;

}
