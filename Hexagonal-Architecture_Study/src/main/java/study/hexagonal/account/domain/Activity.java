package study.hexagonal.account.domain;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import study.hexagonal.account.domain.Account.AccountId;

/**
 * {@link Account} 간의 돈 이체 활동.
 */
@Value
@RequiredArgsConstructor
public class Activity {

	@Getter
	private ActivityId id;

	/**
	 * 이 활동을 소유한 계좌.
	 */
	@Getter
	@NonNull
	private final AccountId ownerAccountId;

	/**
	 * 인출된 계좌.
	 */
	@Getter
	@NonNull
	private final AccountId sourceAccountId;

	/**
	 * 입금된 계좌.
	 */
	@Getter
	@NonNull
	private final AccountId targetAccountId;

	/**
	 * 활동의 타임스탬프.
	 */
	@Getter
	@NonNull
	private final LocalDateTime timestamp;

	/**
	 * 계좌 간에 이체된 돈.
	 */
	@Getter
	@NonNull
	private final Money money;

	public Activity(
			@NonNull AccountId ownerAccountId,
			@NonNull AccountId sourceAccountId,
			@NonNull AccountId targetAccountId,
			@NonNull LocalDateTime timestamp,
			@NonNull Money money) {
		this.id = null;
		this.ownerAccountId = ownerAccountId;
		this.sourceAccountId = sourceAccountId;
		this.targetAccountId = targetAccountId;
		this.timestamp = timestamp;
		this.money = money;
	}

	@Value
	public static class ActivityId {
		private final Long value;
	}
}
