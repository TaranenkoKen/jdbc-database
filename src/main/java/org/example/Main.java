package org.example;

public class Main {
    public static void main(String[] args) {
        // 1. Ініціалізація
        System.out.println("--- DB Init ---");
        DatabaseInitService.main(args);

        // 2. Наповнюємо даними
        System.out.println("\n--- DB Populate ---");
        DatabasePopulateService.main(args);

        // 3. Перевіряємо запити
        System.out.println("\n--- Query Results ---");
        DatabaseQueryService queryService = new DatabaseQueryService();

        System.out.println("Max Projects Client:");
        System.out.println(queryService.findMaxProjectsClient());

        System.out.println("\nLongest Project:");
        System.out.println(queryService.findLongestProject());

        System.out.println("\nMax Salary Worker:");
        System.out.println(queryService.findMaxSalaryWorker());

        System.out.println("\nYoungest Eldest Workers:");
        System.out.println(queryService.findYoungestEldestWorkers());

        System.out.println("\nProject Prices:");
        System.out.println(queryService.printProjectPrices());
    }
}