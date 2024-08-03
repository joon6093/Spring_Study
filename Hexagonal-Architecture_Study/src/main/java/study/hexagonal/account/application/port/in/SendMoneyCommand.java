package study.hexagonal.account.application.port.in;

import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Value;
import study.hexagonal.account.domain.Account;
import study.hexagonal.account.domain.Account.AccountId;
import study.hexagonal.account.domain.Money;
import study.hexagonal.common.SelfValidating;

@Value
@EqualsAndHashCode(callSuper = false)
public
class SendMoneyCommand extends SelfValidating<SendMoneyCommand> {

    @NotNull
    private final Account.AccountId sourceAccountId;

    @NotNull
    private final Account.AccountId targetAccountId;

    @NotNull
    private final Money money;

    public SendMoneyCommand(
            AccountId sourceAccountId,
            AccountId targetAccountId,
            Money money) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.money = money;
        this.validateSelf();  // 검증
    }
}
