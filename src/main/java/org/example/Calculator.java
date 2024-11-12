package org.example;

public class Calculator {

    public static String calculation(String task) {
        try {
            task = task.replaceAll("\\s+", "");
            if (task.contains("+")) {
                String[] parts = task.split("\\+");
                int num1 = Integer.parseInt(parts[0].trim());
                int num2 = Integer.parseInt(parts[1].trim());
                return String.valueOf(num1 + num2);
            } else if (task.contains("-")) {
                String[] parts = task.split("-");
                int num1 = Integer.parseInt(parts[0].trim());
                int num2 = Integer.parseInt(parts[1].trim());
                return String.valueOf(num1 - num2);
            } else if (task.contains("*")) {
                String[] parts = task.split("\\*");
                int num1 = Integer.parseInt(parts[0].trim());
                int num2 = Integer.parseInt(parts[1].trim());
                return String.valueOf(num1 * num2);
            } else if (task.contains("/")) {
                String[] parts = task.split("/");
                int num1 = Integer.parseInt(parts[0].trim());
                int num2 = Integer.parseInt(parts[1].trim());
                if (num2 == 0) {
                    return "Error: Division by zero";
                }
                return String.valueOf((double) num1 / num2);
            } else {
                return "Unsupported operation or format";
            }
        } catch (Exception e) {
            return "Error in calculation: " + e.getMessage();
        }
    }
}
