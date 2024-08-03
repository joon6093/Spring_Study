package study.hexagonal.account.application.service;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import study.hexagonal.account.application.port.in.GetAccountBalanceQuery;
import study.hexagonal.account.application.port.out.LoadAccountPort;
import study.hexagonal.account.domain.Account.AccountId;
import study.hexagonal.account.domain.Money;

/**
 * 계좌 잔액을 조회하는 서비스를 제공.
 */
@RequiredArgsConstructor
class GetAccountBalanceService implements GetAccountBalanceQuery {

    private final LoadAccountPort loadAccountPort;

    @Override
    public Money getAccountBalance(AccountId accountId) {
        return loadAccountPort.loadAccount(accountId, LocalDateTime.now())
                .calculateBalance();
    }
}
