package study.hexagonal;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.hexagonal.account.application.service.MoneyTransferProperties;
import study.hexagonal.account.domain.Money;

@Configuration
@EnableConfigurationProperties(HexagonalConfigurationProperties.class)
public class HexagonalConfiguration {

    /**
     * 특정 사용 사례에 대한 {@link MoneyTransferProperties} 객체를 애플리케이션 컨텍스트에 추가합니다. 속성은 Spring-Boot 특정
     * {@link HexagonalConfigurationProperties} 객체에서 읽어옵니다.
     */
    @Bean
    public MoneyTransferProperties moneyTransferProperties(
            HexagonalConfigurationProperties hexagonalConfigurationProperties) {
        return new MoneyTransferProperties(Money.of(hexagonalConfigurationProperties.getTransferThreshold()));
    }

}
