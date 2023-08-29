package basic.exams;

import java.util.Scanner;

public class balls {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        int points=0;
        int redCount=0;
        int orangeCount=0;
        int yellowCount=0;
        int whiteCount=0;
        int blackCount=0;
        int otherColors=0;
        int dividedFromBlack=0;

        for (int i =1; i <=n ; i++) {

            String color=scanner.nextLine();

            if (color.equals("red")){
                points+=5;
                redCount++;
            }else if(color.equals("orange")){
                points+=10;
                orangeCount++;
            }else if (color.equals("yellow")){
                points+=15;
                yellowCount++;
            }else if (color.equals("white")){
                points+=20;
                whiteCount++;
            }else if (color.equals("black")){
                points=points/2;

                dividedFromBlack++;

            }else {
                otherColors++;
            }
        }

        System.out.printf("Total points: %d%n",points);
        System.out.printf("Red balls: %d%n",redCount);
        System.out.printf("Orange balls: %d%n",orangeCount);
        System.out.printf("Yellow balls: %d%n",yellowCount);
        System.out.printf("White balls: %d%n",whiteCount);
        System.out.printf("Other colors picked: %d%n",otherColors);
        System.out.printf("Divides from black balls: %d",dividedFromBlack);
    }
}

