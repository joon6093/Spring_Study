package study.hexagonal.account.application.port.out;

import study.hexagonal.account.domain.Account;

public interface UpdateAccountStatePort {

    void updateActivities(Account account);

}
