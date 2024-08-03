package study.hexagonal.account.service;

import org.springframework.stereotype.Component;
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
