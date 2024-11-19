import java.util.Scanner;

public class Service {

    Repository repository = new Repository();

    void register(Scanner scanner) {
        System.out.print("명언 : ");
        String message = scanner.nextLine();

        System.out.print("작가 : ");
        String author = scanner.nextLine();

        WiseSaying data = new WiseSaying(repository.number, message, author);
        repository.register(repository.number, data);

        System.out.println(repository.number + "번 명언이 등록되었습니다.");
        repository.number++; // 명언 번호 증가
    }

    void findAll() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        repository.findAll();
    }

    void delete(String input) {
        repository.delete(input);
        try {
            repository.delete(input);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
