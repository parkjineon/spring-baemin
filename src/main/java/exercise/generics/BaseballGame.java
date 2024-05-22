package exercise.generics;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
    public static void main(String[] args) {
        Game game = new Game();
    }
}

class Game{
    int[] answer = new int[3];
    int[] input = {-1,-1,-1};

    Game(){
        getAnswer();

        int round = 1;
        System.out.println("Round" + round);
        getUserInput();
        round++;
        while(printResult() == 1 && round < 11){
            System.out.println("Round" + round);
            getUserInput();
            round++;
        }

        if(round == 11){
            System.out.println("Game Over");
        }
    }

    private void getAnswer(){
        Random random = new Random();

        answer[0] = random.nextInt(10);

        answer[1] = random.nextInt(10);
        while(answer[0] == answer[1]){
            answer[1] = random.nextInt(10);
        }

        answer[2] = random.nextInt(10);
        while(answer[0] == answer[2] || answer[1] == answer[2]){
            answer[2] = random.nextInt(10);
        }
    }

    private void getUserInput(){
        Scanner scanner = new Scanner(System.in);

        for(int i = 0 ; i < 3; i++){
            boolean invalid = true;
            while(invalid){
                System.out.println("Enter number");
                try {
                    input[i] = scanner.nextInt();

                    if(-1 < input[i] && input[i] < 10){
                        invalid = false;
                    }else{
                        System.out.println("Enter number between 0 and 9");
                        invalid = true;
                    }
                }catch(InputMismatchException e){
                    System.out.println("Enter number, Not character");
                    scanner.next();
                }
            }
        }
    }

    private int printResult(){
        int ball = 0;
        int strike = 0;

        for(int i = 0 ; i < 3; i++){
            for(int j = 0 ; j < 3; j++){
                if(answer[i] == input[j] && i == j){
                    strike++;
                }else if(answer[i] == input[j]){
                    ball++;
                }
            }
        }

        if(strike == 3){
            System.out.println("You win!");
            return 0;
        }else{
            System.out.println("" + input[0] + input[1] + input[2] + " " + ball +" ball " + strike + " strike " + (3-ball-strike) + " out");
            return 1;
        }
    }

}
