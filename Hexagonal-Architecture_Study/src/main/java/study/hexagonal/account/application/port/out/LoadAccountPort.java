package study.hexagonal.account.application.port.out;

import java.time.LocalDateTime;
import study.hexagonal.account.domain.Account;
import study.hexagonal.account.domain.Account.AccountId;

public interface LoadAccountPort {

    Account loadAccount(AccountId accountId, LocalDateTime baselineDate);
}
