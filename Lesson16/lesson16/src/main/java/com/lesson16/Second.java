// 2.Дана JSON-строка:
// [
//   {"name": "Аня", "age": 19, "grade": 4.5},
//   {"name": "Борис", "age": 21, "grade": 3.8},
//   {"name": "Вера", "age": 20, "grade": 4.9}
// ]
// Создай класс Student, десериализуй строку в List<Student> ( нужен TypeToken), затем 
// выведи имена студентов с оценкой выше 4.0 и средний балл всей группы.
package com.lesson16;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
class Second{
  static class Student {
        String name;
        int age;
        double grade;
    }

    public static void main() {
        String json = "[{\"name\": \"Anua\", \"age\": 19, \"grade\": 4.5}, {\"name\": \"Boris\", \"age\": 21, \"grade\": 3.8}, {\"name\": \"Vera\", \"age\": 20, \"grade\": 4.9}]";

        Gson gson = new Gson();
        Type type = new TypeToken<List<Student>>() {}.getType();
        List<Student> students = gson.fromJson(json, type);

        double sum = 0;
        System.out.println("Students with grade > 4.0:");
        for (Student s : students) {
            if (s.grade > 4.0) {
                System.out.println(s.name);
            }
            sum += s.grade;
        }

        double average = sum / students.size();
        System.out.printf("Average grade: %.2f%n", average);
    }
}