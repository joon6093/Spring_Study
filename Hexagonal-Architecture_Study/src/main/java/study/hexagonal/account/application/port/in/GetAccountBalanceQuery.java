package study.hexagonal.account.application.port.in;


import study.hexagonal.account.domain.Account.AccountId;
import study.hexagonal.account.domain.Money;

public interface GetAccountBalanceQuery {

    Money getAccountBalance(AccountId accountId);

}
