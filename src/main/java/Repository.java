import java.util.*;

public class Repository {

    LinkedHashMap<Integer, WiseSaying> wiseSayingMap = new LinkedHashMap<>();
    int number = 1; // 명언 번호

    void register(int id, WiseSaying wiseSaying) {
        wiseSayingMap.put(this.number, wiseSaying);
    }

    void findAll() {
        // 키 내림차순 정렬
        List<Integer> numbers = new ArrayList<>(wiseSayingMap.keySet());
        numbers.sort(Collections.reverseOrder());

        // 정렬된 키 순서로 출력
        for (Integer number : numbers) {
            System.out.println(wiseSayingMap.get(number));
        }
    }

    void delete(String input) {
        int id = Integer.parseInt(input.substring(6));

        if (wiseSayingMap.get(id) == null) {
            throw new NullPointerException(id + "번 명언은 존재하지 않습니다.");
        }

        wiseSayingMap.remove(id);
        System.out.println(id + "번 명언이 삭제되었습니다.");
    }
}
