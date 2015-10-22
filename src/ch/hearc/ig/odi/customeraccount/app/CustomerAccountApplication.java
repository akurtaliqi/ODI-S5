/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.customeraccount.app;


import static ch.hearc.ig.odi.customeraccount.business.Account.transfer;
import ch.hearc.ig.odi.customeraccount.business.Customer;

/**
 *
 * @author ajtene.kurtaliq
 */
public class CustomerAccountApplication {

    public static void main(String[] args) {
        Customer newCustomer1 = new Customer(1, "Kurtaliqi", "Ajtene");
        Customer newCustomer2 = new Customer(2, "Kurtaliqi", "Lejla");
        Customer newCustomer3 = new Customer(1, "Kurtaliqi", "Byrsene");

        newCustomer1.addAccount("123-001", "Juste pour la littérature", 0.250);
        newCustomer1.addAccount("123-002", "Pour aller au Japon", 0.250);
        newCustomer2.addAccount("124-001", "Pour acheter des clopes", 0.250);
        newCustomer3.addAccount("125-001", "Pour les voyages", 0.250);
        newCustomer3.addAccount("125-002", "Pour tester", 0.250);

        //crédit
        newCustomer1.getAccountByNumber("123-001").credit(50000);
        newCustomer1.getAccountByNumber("123-002").credit(0);
        newCustomer2.getAccountByNumber("124-001").credit(50000);
        newCustomer3.getAccountByNumber("125-001").credit(50000);
        newCustomer3.getAccountByNumber("125-002").credit(0);

        System.out.println(newCustomer1.getAccountByNumber("123-001").getBalance());
        //50000 -----> OK
        
        
        //test débit correct
        newCustomer1.getAccountByNumber("123-001").debit(30000);
        
        
        //test transfère
        transfer(3500,  newCustomer3.getAccountByNumber("125-001"), newCustomer1.getAccountByNumber("123-002"));
        //125-001 : 46500 -----> OK
        //123-002 : 3500 -----> OK
        System.out.println(newCustomer3.getAccountByNumber("125-001").getBalance());
        System.out.println(newCustomer1.getAccountByNumber("123-002").getBalance());
        
        
        System.out.println("------------------------------------");
        System.out.println("------------------------------------");
        System.out.println("------------------------------------");
        //test crédit sur compte qui est à 0 -----> OK
        newCustomer3.getAccountByNumber("125-002").debit(10);

    }

}
