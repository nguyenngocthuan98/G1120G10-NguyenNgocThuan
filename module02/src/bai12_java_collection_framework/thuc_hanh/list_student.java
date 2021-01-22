package bai12_java_collection_framework.thuc_hanh;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/*
Tạo HashMap, LinkedHashMap, TreeMap để lưu danh sách sinh viên theo độ tuổi.
Chương trình đầu tiên tạo ra một HashMap lưu tên sinh viên như là khoá (key) và tuổi của mỗi sinh viên đó.
Chương trình sau đó tạo ra một TreeMap hiển thị toàn bộ key theo thứ tự giảm/tăng.
Cuối cùng, chương trình tạo ra một LinkedHashMap để lưu danh sách tương tự như HashMap và hiển thị dữ liệu.
 */
public class list_student {
    public static void main(String[] args) {
//        Tạo HashMap trong main để lưu danh sách sinh viên
        Map<String, Integer> studentsHasMap = new HashMap<>();
        studentsHasMap.put("thuan", 23);
        studentsHasMap.put("hoang", 25);
        studentsHasMap.put("quang", 27);
        studentsHasMap.put("van", 24);
        studentsHasMap.put("nghia", 24);
        studentsHasMap.put("ngoc", 24);
        System.out.println("HashMap: " + studentsHasMap);

//        Tạo TreeMap trong main để lưu key theo thứ tự giảm dần, lấy các phần tử trừ map khác
        Map<String, Integer> studentTreeMap = new TreeMap<>(studentsHasMap);
        System.out.println("TreeMap: " + studentTreeMap);

//        Tạo LinkedHashMap trong main lấy phần tử từ map khác và hiển thị dữ liệu
        Map<String, Integer> studentLinkedHashMap = new LinkedHashMap<>(studentTreeMap);
        System.out.println("Value of key \"thuan\" is: " + studentLinkedHashMap.get("thuan"));

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(12, 0.6f, true);
//        initialCapacity  – Dung lượng của linked hashmap này là 12. Ý nghĩa: nó có thể lưu trữ 12 mục.
//        loadFactor - Hệ số tải của LinkedHashMap này là 0,6.
//              Điều này có nghĩa là, bất cứ khi nào HashMap của chúng ta được lấp đầy 60%,
//              các mục nhập vào sau đó sẽ được chuyển sang hash table mới có kích thước gấp đôi hash table ban đầu.
//        AccessOrder là false: sắp xếp trên theo thứ tự chèn vào của chúng.
//        AccessOrder là true: xếp theo thứ tự truy cập ít nhất đến truy cập nhiều nhất.
//        Theo mặc định LinkedHashMap<>(), dung lượng của LinkedHashMap sẽ là 16. Hệ số tải sẽ là 0,75f. AccessOrder là false
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);
        System.out.println(linkedHashMap);
        System.out.println("The age for " + "Lewis is " + linkedHashMap.get("Lewis"));
    }
}
