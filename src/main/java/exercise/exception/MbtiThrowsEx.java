package exercise.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MbtiThrowsEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("=== MBTI 검사를 시작합니다. ===");
            System.out.println(checkEorI(scanner));
            /**
            * 1. 나는 밖에서 에너지를 얻는다.
            * 2. 나는 이불 속에서 에너지를 얻는다.
            * 당신의 선택은? ___ ( 숫자로 입력 받기 )
            * 1 -> E, 2 -> I
             * 만약 1a 처럼 잘못 입력하면, 예외!
             */

            System.out.println("=== MBTI 검사가 종료되었습니다. ===");


        }catch(InputMismatchException e){
            System.out.println("키보드 입력이 잘못되었습니다.");

        } finally {
            if(scanner != null){
                System.out.println("스캐너가 닫겼습니다.");
                scanner.close();
            }
        }


    }

    public static String checkEorI(Scanner scanner) throws InputMismatchException{

        /**
         * 1. 나는 밖에서 에너지를 얻는다.
         * 2. 나는 이불 속에서 에너지를 얻는다.
         * 당신의 선택은? ___ ( 숫자로 입력 받기 )
         * 1 -> E, 2 -> I
         * 만약 1a 처럼 잘못 입력하면, 예외!
         */
        System.out.println("1. 나는 밖에서 에너지를 얻는다.");
        System.out.println("2. 나는 이불 속에서 에너지를 얻는다.");
        System.out.print("당신의 선택은? ");
        int ei = scanner.nextInt();

        if(ei != 1 && ei != 2) System.out.println("1과 2중 선택하셔야 합니다.");

        return ei == 1 ? "E" : "I";
    }


}
