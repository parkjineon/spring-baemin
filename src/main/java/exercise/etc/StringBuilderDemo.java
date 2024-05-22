package exercise.etc;

import java.util.Scanner;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        String str1 = scanner.next();
        String str2 = scanner.next();

        stringBuilder.append(str1);
        stringBuilder.append(str2);

        System.out.println(stringBuilder.toString());
    }
}
