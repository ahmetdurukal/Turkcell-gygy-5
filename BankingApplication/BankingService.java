import java.util.ArrayList;
import java.util.List;

public class BankingService {
    private List<User> users = new ArrayList<>();

    public void register(User user) {
        users.add(user);
        System.out.println("Kayıt işlemi başarıyla tamamlandı.");
    }

    public User login(String name, String surname,String pin) {
        for (User u : users) {
            if (u.getName().equalsIgnoreCase(name) && u.getSurname().equalsIgnoreCase(surname)&&
             u.getPin().equals(pin)) {
                return u;
            }
        }
        return null;
    }

    public void applyForLoan(User user, double amount) {
        double limit = user.getMonthlyIncome() * 10;
        if (amount <= limit) {
            user.setBalance(user.getBalance() + amount);
            user.setLoanDebt(user.getLoanDebt() + amount);
            System.out.println("Kredi onaylandı ve hesaba tanımlandı.");
        } else {
            System.out.println("Limit yetersiz. Maksimum alabileceğiniz kredi: " + limit);
        }
    }

    public void payDebt(User user, double amount, boolean isMinimum) {
        double totalToPay = isMinimum ? user.getLoanDebt() * 0.2 : amount;
        
        if (user.getBalance() >= totalToPay) {
            user.setBalance(user.getBalance() - totalToPay);
            user.setLoanDebt(user.getLoanDebt() - totalToPay);
            System.out.println("Ödeme başarılı. Güncel borç: " + user.getLoanDebt());
        } else {
            System.out.println("Hata: Yetersiz bakiye.");
        }
    }
}