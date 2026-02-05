package org.example;

import java.util.Scanner;

public class App {
    Scanner sc= new Scanner(System.in);
    int lastId=0;
    WiseSaying[] wiseSayings = new WiseSaying[10]; // 객체 한 개 생성은 배열에 안 들어감
    int lastWiseSayingIndex = -1;

    public void run(){
        System.out.println("== 명언 앱 ==");

        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();
            if (cmd.equals("종료")) {
                System.exit(0);
            } else if (cmd.equals("등록")) {
                actionWrite();
            } else if (cmd.equals("목록")){
                actionList();
            } else if (cmd.startsWith("삭제")){
                actionDelete(cmd);
            }
        }
    }

    private void actionDelete(String cmd) {
        String idStr = cmd.split("=")[1];
        int id = Integer.parseInt(idStr);

        boolean rst = delete(id);
        if(!rst){
            System.out.println("해당 명언은 존재 하지 않습니다.");
            return ;
        }

        System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
    }

    private boolean delete(int deleteTarget) {
        int foundIndex = -1;
        for(int i=0; i<=lastWiseSayingIndex; i++){
            WiseSaying foundedWiseSaying=wiseSayings[i];
            if(deleteTarget==foundedWiseSaying.id){
                foundIndex=i;
            }
        }

        if(foundIndex == -1) return false;

        for(int i=foundIndex;i<lastWiseSayingIndex;i++){
            wiseSayings[i]=wiseSayings[i+1];
        }

        lastWiseSayingIndex--; // 목록을 출력할 때
        return true;
    }


    private void actionList() {
        System.out.println("-----------------");
        System.out.println("번호 / 작가 / 명언 ");

        for(int i=lastWiseSayingIndex;i>=0;i--){
            System.out.printf("%d / %s / %s\n", wiseSayings[i].id, wiseSayings[i].author,wiseSayings[i].content);
        }
    }

    private void actionWrite() {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        write(content, author);
        System.out.println("%d번 명언이 등록되었습니다.".formatted(lastId)); //printf 사용
    }

    private void write(String content, String author){
        WiseSaying wiseSaying = new WiseSaying();

        wiseSaying.id = ++lastId;
        wiseSaying.content=content;
        wiseSaying.author=author;

        wiseSayings[++lastWiseSayingIndex]=wiseSaying;

    }

}
