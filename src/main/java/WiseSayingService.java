import java.util.Scanner;

public class WiseSayingService {

    WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();

    void register(Scanner scanner) {
        System.out.print("명언 : ");
        String message = scanner.nextLine();

        System.out.print("작가 : ");
        String author = scanner.nextLine();

        WiseSaying data = new WiseSaying(wiseSayingRepository.number, message, author);
        wiseSayingRepository.register(wiseSayingRepository.number, data);

        System.out.println(wiseSayingRepository.number + "번 명언이 등록되었습니다.");
        wiseSayingRepository.number++; // 명언 번호 증가
    }

    void findAll() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        wiseSayingRepository.findAll();
    }

    void delete(String input) {
        int id = Integer.parseInt(input.substring(6));

        try {
            wiseSayingRepository.delete(id);
            System.out.println(id + "번 명언이 삭제되었습니다.");

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    void update(String input, Scanner scanner) {
        int id = Integer.parseInt(input.substring(6));
        if (wiseSayingRepository.wiseSayingMap.get(id) == null) {
            throw new NullPointerException(id + "번 명언은 존재하지 않습니다.");
        } else {
            System.out.println("명언(기존) : " + wiseSayingRepository.findById(id).getMessage());
            System.out.print("명언 : ");
            String updateMessage = scanner.nextLine();
            System.out.println("명언(기존) : " + wiseSayingRepository.findById(id).getAuthor());
            System.out.print("작가 : ");
            String updateAuthor = scanner.nextLine();
            wiseSayingRepository.update(id, updateMessage, updateAuthor);
        }

    }
}
