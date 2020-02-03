package com.company;

import javax.annotation.processing.Messager;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    static  int number_version = 5;

    public static void main(String[] args) {
        int border_top = 0;
        int border_bottom = 0;
        double step = 0;
        double result ;
        long startTime ;

        Scanner sc = new Scanner(System.in);

        try {
	    System.out.println("Ввведите нижнию границу: ");
        border_bottom = sc.nextInt();

        System.out.println("Ввведите верхнюю границу: ");
        border_top = sc.nextInt();

        System.out.println("Ввведите шаг интегрированния: ");
        step = sc.nextDouble();

        }catch (InputMismatchException e){
            System.out.println("Ошибка Ввода данных");
             e.getMessage();
        }

        startTime = System.currentTimeMillis();

        if(border_bottom >= border_top || border_top <= 0 || border_bottom < 0
                || step <= 0 || step > (border_top - border_bottom) ){
            System.out.println("Введены некоректные данные ");
            return;
        }else {
           result = computationIntegrals(border_top, border_bottom, step);
        }

        System.out.println(result + " " +" Время рассчёта - " + (System.currentTimeMillis() - startTime) +" ml.sec");

    }


    //N*√x
    private static double computationIntegrals(double border_t, double border_b, double step){
        double sum = 0;

        double resultOne = number_version*Math.sqrt( border_b);

                for(double i = border_b; i<= border_t - step; i= i + step ){

                    double resultTwo = number_version*Math.sqrt( (i + step));
                    sum += ( resultOne + resultTwo )/2 *step;
                    resultOne = resultTwo;
                }
        return  sum;
    }
}
