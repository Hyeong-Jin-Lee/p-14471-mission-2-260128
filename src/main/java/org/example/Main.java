package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("== 명언 앱 ==");
        Scanner sc= new Scanner(System.in);
        System.out.print("명령) ");
        sc.nextLine();

        if(sc.equals("종료")){
            System.exit(0) ;
        }
    }
}
