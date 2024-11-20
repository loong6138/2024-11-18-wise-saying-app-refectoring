package com.llwiseSaying;

import java.util.Scanner;

public class WiseSayingController {

    WiseSayingService wiseSayingService = new WiseSayingService();

    void run() {

        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input.equals("등록")) {
                wiseSayingService.register(scanner);
            } else if (input.equals("목록")) {
                wiseSayingService.findAll();
            } else if (input.contains("삭제?id=")) {
                wiseSayingService.delete(input);
            } else if (input.contains("수정?id=")) {
                try {
                    wiseSayingService.update(input, scanner);
                } catch (NullPointerException e) {
                    System.out.println(e.getMessage());
                }
            } else if (input.equals("종료")) {
                scanner.close();
                break;
            }
        }
    }
}

