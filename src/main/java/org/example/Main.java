package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("== 명언 앱 ==");
        Scanner sc= new Scanner(System.in);
        String cmd;
        String wiseSaying="";
        String author="";
        int lastId=0;

        while(true) {
            System.out.print("명령) ");
            cmd=sc.nextLine();
            if (cmd.equals("종료")) {
                System.exit(0);
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                wiseSaying = sc.nextLine();
                System.out.print("작가 : ");
                author = sc.nextLine();
                System.out.printf("%d번 명언이 등록되었습니다.\n", ++lastId); //printf 사용

            }

        }
    }
}
