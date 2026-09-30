// 1.Создай класс Book с полями title (String), author (String), year (int), 
// price (double). Создай объект, преобразуй его в JSON-строку через Gson и 
// выведи в консоль. Затем включи красивый вывод через 
// GsonBuilder().setPrettyPrinting() и сравни результат.
package com.lesson16;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
class First{
    public record Book(String title, String author, int year, double price) {}

    public static void main() {
        Book book = new Book("1984", "Second Empire", 1966, 899.50);

        Gson gsonCompact = new Gson();
        String jsonCompact = gsonCompact.toJson(book);
        System.out.println("=== nice JSON ===");
        System.out.println(jsonCompact);

        Gson gsonPretty = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String jsonPretty = gsonPretty.toJson(book);
        
        System.out.println("\n=== JSON ===");
        System.out.println(jsonPretty);
    }
}