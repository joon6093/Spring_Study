package study.hexagonal.account.application.service;

import org.springframework.stereotype.Component;
import study.hexagonal.account.application.port.out.AccountLock;
import study.hexagonal.account.domain.Account.AccountId;

@Component
class NoOpAccountLock implements AccountLock {

    @Override
    public void lockAccount(AccountId accountId) {
        // do nothing
    }

    @Override
    public void releaseAccount(AccountId accountId) {
        // do nothing
    }

}
