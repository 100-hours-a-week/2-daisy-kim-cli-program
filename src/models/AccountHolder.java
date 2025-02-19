package models;

public class AccountHolder extends Account {
    public AccountHolder(User owner, String accountNumber) {
        super(owner, accountNumber);
    }

    public void transfer(AccountHolder toAccount, int amount) {
        if (balance >= amount) {
            balance -= amount;
            toAccount.balance += amount;
            System.out.println("💸 " + amount + "원이 " + toAccount.getOwner().getName() + "님에게 송금되었습니다.");
        } else {
            System.out.println("❌ 잔액이 부족하여 송금할 수 없습니다.");
        }
    }
}