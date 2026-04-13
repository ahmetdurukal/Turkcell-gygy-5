import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankingService bank = new BankingService();

        while (true) {
            System.out.println("\n--- BANKAMIZA HOŞGELDİNİZ ---");
            System.out.println("1. Hesap Aç\n2. Giriş Yap\n3. Çıkış");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Adınız: "); String name = sc.next();
                System.out.print("Soyadınız: "); String surname = sc.next();
                System.out.print("Aylık Geliriniz: "); 
                double income = sc.nextDouble(); 

                System.out.print("4 Haneli Şifreniz: "); 
                String pin = sc.next();

                bank.register(new User(name, surname, income, pin));

            } else if (choice == 2) {
                System.out.print("Adınız: "); 
                String loginName = sc.next();
                System.out.print("Soyadınız: "); 
                String loginSurname = sc.next();
                System.out.print("Şifreniz: "); 
                String loginPin = sc.next();
                
                User activeUser = bank.login(loginName,loginSurname, loginPin);

                if (activeUser != null) {
                    showMenu(sc, bank, activeUser);
                } else {
                    System.out.println("Giriş başarısız! Bilgileri kontrol edin.");
                }
            } else break;
        }
    }

    private static void showMenu(Scanner sc, BankingService bank, User user) {
        while (true) {
            System.out.println("\nSayın " + user.getName().toUpperCase() + " | Bakiye: " + user.getBalance() + " | Borç: " + user.getLoanDebt());
            System.out.println("1. Para Yatır\n2. Para Çek\n3. Kredi Başvurusu\n4. Borç Öde\n5. Oturumu Kapat");
            int op = sc.nextInt();

            if (op == 1) {
                System.out.print("Miktar: ");
                double amount = sc.nextDouble();
                user.setBalance(user.getBalance() + amount);
            } else if (op == 2) {
                System.out.print("Miktar: ");
                double amount = sc.nextDouble();
                if (user.getBalance() >= amount) user.setBalance(user.getBalance() - amount);
                else System.out.println("Yetersiz bakiye!");
            } else if (op == 3) {
                System.out.print("İstenen Kredi Tutarı: ");
                bank.applyForLoan(user, sc.nextDouble());
            } else if (op == 4) {
                System.out.println("1. Asgari Ödeme (%20)\n2. Tutar Belirle");
                int sub = sc.nextInt();
                if (sub == 1) bank.payDebt(user, 0, true);
                else {
                    System.out.print("Tutar: ");
                    bank.payDebt(user, sc.nextDouble(), false);
                }
            } else break;
        }
    }
}