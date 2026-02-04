package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("== 명언 앱 ==");
        Scanner sc= new Scanner(System.in);
        String cmd;
        int lastId=0;

        WiseSaying[] wiseSayings = new WiseSaying[10]; // 객체 한 개 생성은 배열에 안 들어감

        while(true) {
            System.out.print("명령) ");
            cmd=sc.nextLine();
            if (cmd.equals("종료")) {
                System.exit(0);
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                wiseSayings[lastId] = new WiseSaying(); // 객체를 먼저 생성 후 값을 넣어야 함.
                wiseSayings[lastId].content = sc.nextLine(); // 생성 안하고 바로 값을 넣으면 없는 객체여서 오류 발생
                System.out.print("작가 : ");
                wiseSayings[lastId].author = sc.nextLine();
                System.out.printf("%d번 명언이 등록되었습니다.\n", ++lastId); //printf 사용

            } else if (cmd.equals("목록")){
                for(int i=lastId-1;i>=0;i--){
                    System.out.printf("%d / %s / %s\n", i+1, wiseSayings[i].author,wiseSayings[i].content);
                }
            }

        }
    }
}
