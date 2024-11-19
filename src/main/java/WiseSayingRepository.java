import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class WiseSayingRepository {

    LinkedHashMap<Integer, WiseSaying> wiseSayingMap = new LinkedHashMap<>();
    int number = 1; // 명언 번호

    void register(int number, WiseSaying wiseSaying) {
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

    void delete(int id) {
        if (wiseSayingMap.get(id) == null) {
            throw new NullPointerException(id + "번 명언은 존재하지 않습니다.");
        } else {
            wiseSayingMap.remove(id);
        }

    }

    void update(int id, String message, String author) {
            WiseSaying wiseSaying = new WiseSaying(id, message, author);
            wiseSayingMap.put(id, wiseSaying);

    }

    WiseSaying findById(int id) {
        return wiseSayingMap.get(id);
    }
}
