public class User {
    private String name;
    private String surname;
    private double monthlyIncome;
    private String pin;
    private double balance;
    private double loanDebt;

    public User(String name, String surname, double monthlyIncome, String pin) {
        this.name = name;
        this.surname = surname;
        this.monthlyIncome = monthlyIncome;
        this.pin = pin;
        this.balance = 0.0;
        this.loanDebt = 0.0;
    }

    public String getName() { 
        return name; 
    }

    public String getSurname() { 
        return surname; 
    }
    
    public String getPin() { 
        return pin; 
    }
    public double getMonthlyIncome() { 
        return monthlyIncome; 
    }
    public double getBalance() { 
        return balance; 
    }
    public void setBalance(double balance) { 
        this.balance = balance; 
    }
    public double getLoanDebt() { 
        return loanDebt; 
    }
    public void setLoanDebt(double loanDebt) {
        this.loanDebt = loanDebt; 
    }
}