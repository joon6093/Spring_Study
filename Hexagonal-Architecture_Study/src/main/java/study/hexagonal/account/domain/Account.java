package study.hexagonal.account.domain;

import java.time.LocalDateTime;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

/**
 * 일정 금액을 보유한 계좌입니다. {@link Account} 객체는 최신 계좌 활동의 창(window)만 포함합니다. 계좌의 총 잔액은 창에 있는 첫 번째 활동 이전에 유효했던 기준 잔액과 활동 값의
 * 합계입니다.
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Account {

    /**
     * 계좌의 고유 ID.
     */
    @Getter
    private final AccountId id;

    /**
     * 계좌의 기준 잔액. 이는 activityWindow의 첫 번째 활동 이전의 계좌 잔액입니다.
     */
    @Getter
    private final Money baselineBalance;

    /**
     * 이 계좌의 최신 활동 창.
     */
    @Getter
    private final ActivityWindow activityWindow;

    /**
     * ID 없이 {@link Account} 엔티티를 생성합니다. 아직 저장되지 않은 새 엔티티를 만들 때 사용합니다.
     */
    public static Account withoutId(
            Money baselineBalance,
            ActivityWindow activityWindow) {
        return new Account(null, baselineBalance, activityWindow);
    }

    /**
     * ID가 있는 {@link Account} 엔티티를 생성합니다. 저장된 엔티티를 재구성할 때 사용합니다.
     */
    public static Account withId(
            AccountId accountId,
            Money baselineBalance,
            ActivityWindow activityWindow) {
        return new Account(accountId, baselineBalance, activityWindow);
    }

    public Optional<AccountId> getId() {
        return Optional.ofNullable(this.id);
    }

    /**
     * 활동 값을 기준 잔액에 더하여 계좌의 총 잔액을 계산합니다.
     */
    public Money calculateBalance() {
        return Money.add(
                this.baselineBalance,
                this.activityWindow.calculateBalance(this.id));
    }

    /**
     * 이 계좌에서 일정 금액을 출금하려고 시도합니다. 성공하면 음수 값의 새 활동을 만듭니다.
     *
     * @return 출금이 성공하면 true, 실패하면 false를 반환합니다.
     */
    public boolean withdraw(Money money, AccountId targetAccountId) {

        if (!mayWithdraw(money)) {
            return false;
        }

        Activity withdrawal = new Activity(
                this.id,
                this.id,
                targetAccountId,
                LocalDateTime.now(),
                money);
        this.activityWindow.addActivity(withdrawal);
        return true;
    }

    private boolean mayWithdraw(Money money) {
        return Money.add(
                        this.calculateBalance(),
                        money.negate())
                .isPositiveOrZero();
    }

    /**
     * 이 계좌에 일정 금액을 입금하려고 시도합니다. 성공하면 양수 값의 새 활동을 만듭니다.
     *
     * @return 입금이 성공하면 true, 실패하면 false를 반환합니다.
     */
    public boolean deposit(Money money, AccountId sourceAccountId) {
        Activity deposit = new Activity(
                this.id,
                sourceAccountId,
                this.id,
                LocalDateTime.now(),
                money);
        this.activityWindow.addActivity(deposit);
        return true;
    }

    @Value
    public static class AccountId {
        private Long value;
    }

}
