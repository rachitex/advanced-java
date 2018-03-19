package bankinfo;

import java.beans.*;
import java.io.Serializable;
import java.util.HashMap;

public class BankBean implements Serializable {  
    public BankBean() {
        
    }
    private String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }
   
    private String phone;

    /**
     * Get the value of phone
     *
     * @return the value of phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the value of phone
     *
     * @param phone new value of phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String accountNumber;

    /**
     * Get the value of accountNumber
     *
     * @return the value of accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Set the value of accountNumber
     *
     * @param accountNumber new value of accountNumber
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    private long balance;

    /**
     * Get the value of balance
     *
     * @return the value of balance
     */
    public long getBalance() {
        return balance;
    }

    /**
     * Set the value of balance
     *
     * @param balance new value of balance
     */
    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long withdraw(long withdrawAmount) {
        if(balance >= withdrawAmount) {
            balance = balance - withdrawAmount;
        }else {
            System.out.println("Sorry! Not Enough Balance");
        }
        
        return balance;
    } 
    
    public long deposit(long depositAmount) {
        balance = balance + depositAmount;
        return balance;
    }
    
    public HashMap displayInfo() {
        HashMap<Object, Object> hm = new HashMap<Object, Object>();
        hm.put("Name", name);
        hm.put("Phone", phone);
        hm.put("AccountNumber", accountNumber);
        hm.put("Balance", balance);
        return hm;
    }
}
