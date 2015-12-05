package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here


//       pythagoreanTheoremet();

//        maxMin();

//        problem3();

        hangman("test");

    }

    static void pythagoreanTheoremet (){

        System.out.println("Enter values to compute the Pythagorean theorem.");

        System.out.print("a: ");
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();

        System.out.print("b: ");
        Scanner in2 = new Scanner(System.in);
        double b = in2.nextDouble();

        double total = (a*a + b*b);

        double c = Math.sqrt(total);

        System.out.println("c = " + c);
    }


    static void maxMin (){
        System.out.println("This program finds the largest and smallest numbers.");
        System.out.print("? ");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        if (input == 0){
            System.out.println("No values have been entered");

        } else {
            int max = 0;
            int min = 0;

            while(input != 0)
            {
                System.out.print("? ");

                input = in.nextInt();
                if(input > max) max = input;
                if(input < min) min = input;
            }

            System.out.println("smallest: " + min);
            System.out.println("largest: " + max);
        }
    }

    static void problem3 (){
        System.out.println("Enter a number: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;

        while (n != 1) {

            int result= n % 2;

            if(result == 1){
                result = 3 * n +1;
                System.out.println(n + " is odd, so I make 3n+1: " + result);
            }

            if(result == 0){
                result = n / 2;
                System.out.println(n + " is even, so I take half: " + result);
            }
            count ++;
            n = result;
        }

        System.out.println("The process took " + count + " to reach 1");

    }

    public static void hangman (String str){

        int guessLeft = str.length();
        System.out.println("Welcome to Hangman!");

        String hiddenStr = new String(new char[guessLeft]).replace("\0", "-");
        StringBuilder newStr = new StringBuilder(hiddenStr);
        int wrongCount = 0;


        while (guessLeft >0 && wrongCount < 8){

            System.out.println("The word now looks like this: " + newStr );

            System.out.println("You have " + guessLeft + " guesses left.");

            System.out.println("Your guess: ");
            Scanner in = new Scanner(System.in);
            String guess= in.next();

            if(guess.length()==1){

                if (str.toLowerCase().contains(guess.toLowerCase())){

                    System.out.println("Your guess if correct.");


                    for (int i = 0; i < str.length(); i++){

                        char letter = str.charAt(i);
                        if(String.valueOf(letter).contains(guess)) {

                            newStr.setCharAt(i, guess.charAt(0));
                            guessLeft--;
                        }


                    }




                    //TODO replace char if there are more then 1 in str

                } else {

                    System.out.println("There are no "+ guess + " in the word");

                    wrongCount++;
                }
            }else {
                System.out.println("Your guess is illegal.  Try again");

            }


        }


        if(wrongCount < 8) {
            System.out.println("You guessed the word: " + str);
            System.out.println("You win");

        }else{
            System.out.println("You lose.");

        }

    }
}
