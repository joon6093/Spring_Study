package study.hexagonal.account.application.port.out;

import study.hexagonal.account.domain.Account;

public interface AccountLock {

    void lockAccount(Account.AccountId accountId);

    void releaseAccount(Account.AccountId accountId);

}
