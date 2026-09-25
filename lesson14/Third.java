// 3.Дан список объектов Student с полями name (String) и grade (int, средний балл). 
// С помощью Stream API отобрать студентов с баллом выше заданного порога (например, 
// 4), собрать их в новый список (collect(Collectors.toList())) и вывести количество 
// отобранных студентов через .size() этого списка, а затем — их имена.
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
class Third{
    static record Student(String name, int grade){
    }
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Anrei", 4),
            new Student("Visili", 3),
            new Student("Masha", 5),
            new Student("Roma", 5)
        );
        List<Student> bStudents = students.stream()
            .filter(s->s.grade>4)
            .collect(Collectors.toList());
        bStudents.stream().map(Third.Student::name).forEach(System.out::println);
    }
}