package com.vti.utils;

import java.util.Scanner;

public class Scannerutils {
    static Scanner scanner = new Scanner(System.in);
    // Tạo một method để nhập vào một chuỗi bất kỳ
    public static String inputString(){
        return scanner.nextLine();
    }
    // Tạo một method để nhập vào một số nguyên dương
    public static int inputNumber(){
        int number = 0;
        while (true) {
            try {
                number = Integer.parseInt(scanner.nextLine());
                if (number <= 0) {
                    System.out.println("Số phải lớn hơn 0");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Mời nhập lại");
            }
        }
        return number;
    }

    // Tạo 1 method nhập vào đúng định dạng email
    public static String emailString(){
        String email = scanner.nextLine();
        while (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z0-9.-]+$")) {
            System.out.println("Mời bạn nhập lại");
            email = scanner.nextLine();
        };
        return email;
    }
    // Tạo 1 method nhập vào 1 số min và max do người dùng truyền vào
    public static int inputNumber(int min, int max){
        int number = 0;
        while (true){
            try {
                number = Integer.parseInt(scanner.nextLine());
                if (number< min || number > max){
                    System.out.println("Số ko đúng định dạng, mời bạn nhập lại");
                    continue;
                }
                break;
            } catch(NumberFormatException ex){
                System.err.println("Nhập vào phải là số, mời nhập lại!");
            }
        }
        return number;
    }

    // Tạo method nhập vào chuỗi là password, chứa 6-12 ký tự
    public static String inputPassword(){
        String password = scanner.nextLine();
        while (password.length()<6 || password.length()>12){
            System.out.println("Mời bạn nhập lại");
            password = scanner.nextLine();
        }
        return password;
    }
}
