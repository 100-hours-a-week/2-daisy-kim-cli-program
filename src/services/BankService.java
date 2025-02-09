package services;
import models.AccountHolder;

public class BankService {
    private UserService userService;
    private AccountService accountService;
    private AccountHolder account;

    public BankService() {
        this.userService = new UserService();
        this.account = new AccountHolder(userService.getUser(), "010-123-456");
        this.accountService = new AccountService(account);
    }

    public boolean isLoggedIn() {
        return userService.isLoggedIn();
    }

    public void login(String userId, String password) {
        userService.login(userId, password);
    }

    public void deposit(int amount) {
        if (!isLoggedIn()) {
            System.out.println("🔑 로그인 후 이용 가능합니다.");
            return;
        }
        accountService.deposit(amount);
    }

    public void withdraw(int amount) {
        if (!isLoggedIn()) {
            System.out.println("🔑 로그인 후 이용 가능합니다.");
            return;
        }
        accountService.withdraw(amount);
    }

    public void checkBalance() {
        if (!isLoggedIn()) {
            System.out.println("🔑 로그인 후 이용 가능합니다.");
            return;
        }
        accountService.checkBalance();
    }

    public void viewPremiumBenefits() {
        if (!isLoggedIn()) {
            System.out.println("🔑 로그인 후 이용 가능합니다.");
            return;
        }
        accountService.viewPremiumBenefits();
    }

    public void sendToFriends(String friendId, int amount) {
        if (!isLoggedIn()) {
            System.out.println("🔑 로그인 후 이용 가능합니다.");
            return;
        }

        accountService.sendToFriends(friendId, amount);
    }
}