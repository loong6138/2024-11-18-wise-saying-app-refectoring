import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Service service = new Service();

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input.equals("등록")) {
                service.register(scanner);
            } else if (input.equals("목록")) {
                service.findAll();
            } else if (input.startsWith("삭제?id=")) {
                service.delete(input);
            } else if (input.equals("종료")) {
                scanner.close();
                break;
            }


        }
    }
}
