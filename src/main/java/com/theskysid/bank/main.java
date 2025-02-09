package com.theskysid.bank;
import java.util.*;

public class main {

    static ArrayList<String> accounts = new ArrayList<>();
    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<String> phNumber = new ArrayList<>();
    static ArrayList<String> passwords = new ArrayList<>();
    static ArrayList<Float> amounts = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
    static boolean allowed;
    static int index;
    static String a;

    static void HomeChoice(){
        System.out.println("Welcome to the Bank !" + '\n' + "Choice:" + '\n' + "1. Create account" + '\n' +
                "2. Use account" + '\n' + "3. Update account" + '\n' + "4. Delete account");
    }

    static class CreateAcc{
         void info(){
             while (true) {
                Scanner in = new Scanner (System.in);
                System.out.println("Create Account Menu \nEnter your name :" +'\n'+"(Enter 'quit' to stop)");
                String name = in.nextLine();
                if (name.equals("quit")){break;}
                System.out.println("Enter your phone no. :");
                String no = in.nextLine();
                System.out.println("Enter a strong password :");
                String pass = in.nextLine();
                String id = "1" + "@" + name + no;

                while (true) {
                    System.out.println("Deposit an initial amount :");
                    float j = in.nextFloat();
                    if (j < 0){
                        System.out.println("Unacceptable amount. Try again!");
                    }
                    amounts.add(j); break;
                }

                System.out.println("Your ID is :" + id);
                System.out.println("Your password is :" + pass);

                accounts.add(id);
                passwords.add(pass);
                phNumber.add(no);
                names.add(name);
            } } }

    static class UseAccount {

        public void use(){
            check();
                while(true) {
                    Scanner in = new Scanner(System.in);
                if (allowed == true) {
                    System.out.println("Choice :" +'\n'+ "1. Deposit " +'\n'
                            + "2. Transfer money" +'\n'+ "3. Withdraw" +'\n'+ "4. Show current balance");
                    System.out.println("Enter choice number :" + '\n' + "(Enter 'quit' to stop)");
                    String n = in.next();
                    if (n.equals("quit")){break;}
                    switch(n){
                        case "1" : deposit(); break;
                        case "2" : transfer(); break;
                        case "3" : withdraw(); break;
                        case "4" : System.out.println(amounts);
                        default : System.out.println("Invalid. Try again!");
                    } } } } }

    static class UpAcc {

        static void upt() {
                if (accounts.isEmpty()) {
                    System.out.println("No account exits.");return;
                }
                check();
                if (allowed == true) {
                    System.out.println("Account ID :" + accounts.get(index) + '\n' + "Password :"
                            + "***..." + "Phone number :" + phNumber.get(index));
                    while (true) {
                        System.out.println("What do you wish to update ?" + '\n' + "Choice :"
                                + '\n' + "1. Account holder Name" + '\n' + "2. Password" + '\n' + "3. Phone number"
                                + '\n' + "Enter choice number" + '\n' + "(Enter 'quit to stop)");
                        String e = in.next();
                        if (e.equals("quit")) {break;}
                        Scanner in = new Scanner(System.in);
                        switch (e) {
                            case "1":
                                System.out.println("Enter name :");
                                String f = in.nextLine();
                                names.set(index, f); break;
                            case "2":
                                System.out.println("Enter current password:");
                                String p = in.nextLine();
                                if (passwords.get(index).equals(p)) {
                                    System.out.println("Enter new password");
                                    String np = in.nextLine();
                                    passwords.set(index, np);
                                } else {
                                    System.out.println("Wrong password! Try again");break;
                                } break;
                            case "3":
                                System.out.println("Enter new phone number :");
                                String ph = in.nextLine();
                                phNumber.set(index, ph); break;
                            default:
                                System.out.println("Invalid input");
                        }
                        System.out.println("Updated details :" + '\n' + names.get(index) + '\n' +
                                "***.." + '\n' + phNumber.get(index));
                    } } } }

    static class DelAcc {
        static void del() {

                if (accounts.isEmpty()) {
                    System.out.println("No account exits.");
                    return;
                }
                    check();
                    if (allowed == true) {
                        accounts.remove(index); names.remove(index); phNumber.remove(index);
                        passwords.remove(index);amounts.remove(index);System.out.println("Account deleted");
                        System.out.println(accounts);
                    } } }

    static void deposit(){
        while(true) {
            System.out.println("Enter amount to be deposited :");
            float d = in.nextInt();
            if (d < 0) {
                System.out.println("Unacceptable amount! Try again.");break;
            }
            float updatedAmount = amounts.get(index)+ d;
            amounts.set(index, updatedAmount);
            if (d>0){break;}
        } }

    static void transfer(){
        while (true){
            Scanner in = new Scanner(System.in);
            if (amounts.indexOf(a) != 0) {
                System.out.println("Enter account ID to transfer money to :");
                String t = in.nextLine();
                System.out.println(accounts);
                if (accounts.contains(t)) {
                    System.out.println("Enter amount to be transferred :");
                    float ta = in.nextFloat();
                    int ind = accounts.indexOf(t);
                    if (ta < 0 && ta > amounts.get(index)){
                        System.out.println("Unacceptable amount Or insufficient balance");break;
                    }
                    float rAmt = amounts.get(index) - ta;
                    amounts.set(index, rAmt);
                    float uAmt = amounts.get(ind)+ ta;
                    amounts.set(ind, uAmt); break;
                } else {
                    System.out.println("Account doesn't exist.");
                }
            } else {
                System.out.println("Current account has zero balance." + '\n' +
                        "First Deposit an initial amount");
            } } }

    static void withdraw(){
        while (true) {
            System.out.println("Enter amount to withdraw :");
            float wAmt = in.nextInt();
            if (wAmt < 0 && wAmt > amounts.get(index)){
                System.out.println("Unacceptable amount Or insufficient balance."); break;
            }
            float c = amounts.get(index) - wAmt;
            amounts.set(index, c); break; } }

    static void check(){

        while(true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter account ID :" + '\n' + "(Enter 'quit' to stop)");
            String a = in.nextLine();
            if (a.equals("quit")){break;}
            if (accounts.contains(a)) {
                int index = accounts.indexOf(a);
                System.out.println("Enter your password:");
                String b = in.nextLine();
                if (passwords.get(index).equals(b)) {
                    allowed = true; break;
                }
                else {
                    System.out.println("Wrong password! Start again"); break;
                }
            }
            else {
                System.out.println("Account doesn't exist. Try again");break;
            }}}

    public static void main(String[] args) {

        while (true){
            HomeChoice();
            System.out.println("Enter choice number :" +'\n'+ "(Enter 'quit' to stop)");
            String input = in.next();
            if (input.equals("quit")){
                System.out.println("Bank is closed"); break;
            }
            switch(input){
                case "1" : CreateAcc create = new CreateAcc(); create.info(); break;
                case "2" : UseAccount use = new UseAccount(); use.use(); break;
                case "3" : UpAcc update = new UpAcc(); update.upt(); break;
                case "4" : DelAcc delete = new DelAcc(); delete.del(); break;
                default  : System.out.println("Invalid input. Try again!");
            } } } }