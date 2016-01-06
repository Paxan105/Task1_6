package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int n = 10;
        
            /*
    
    
    Все задания реализованы в виде функций
    
    
    */
        
        /// масив для тестов
        //int mass[] = {15, 157, 14, 25, 2, 39, 76, 302,6547, 35, 50, 65, 47, 10, 17, 84, 62};


        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите n(количество чисел): ");
        n = Integer.parseInt(scanner.next());

        if (n > 0) {

            int mass[] = new int[n];

            for (int i = 0; i < n; i++) {
                System.out.print("Введите число: ");
                mass[i] = Integer.parseInt(scanner.next());
            }

            System.out.println(Arrays.toString(mass));

            ///Находим четные и нечотные числа

            System.out.println();
            System.out.println("Задание 6.1");
            fun_6_1(mass);

            ////Находим максимальное и минимальное число

            System.out.println();
            System.out.println("Задание 6.2");
            fun_6_2(mass);

            /////Находим числа которые делятся на 3 или на 9
            System.out.println();
            System.out.println("Задание 6.3");
            fun_6_3_4(mass);

            //// Находим трехзначные числа, в десятичной записи которых нет одинаковых цифр
            System.out.println();
            System.out.println("Задание 6.5");
            fun_6_5(mass);

            /* Находим «Счастливые» числа
                «Счастливые» числа это четные числа сумма правых цифр которых равняется сумме левых
            */

            System.out.println("Задание 6.6");
            fun_6_6(mass);

            System.out.println();
            System.out.println("Задание 6.7");
            fun_6_7(mass);

        } else System.out.println("n не может быть меньше 1");
    }


    static void fun_6_1(int a[]){

        int[] chet_mass = new int[a.length];
        int  ne_chet_mass[] = new int[a.length];
        int ch=0,n_ch=0;


        for(int i = 0; i<a.length;  i++){
            if(a[i] % 2 == 0){
                chet_mass[ch]= a[i];
                ch++;
            } else{
                ne_chet_mass[n_ch] = a[i];
                n_ch++;
            }

        }

        System.out.println("Четные числа:");
        System.out.println(Arrays.toString(chet_mass));

        System.out.println("Нечетные числа:");
        System.out.println(Arrays.toString(ne_chet_mass));

    }

    static void fun_6_2(int a[]){
        int max,min;
        min=max=a[0];
        for(int i = 0; i<a.length;  i++){
            if(min>a[i]){
                min=a[i];
            } else if(max<a[i]){
                max=a[i];
            }
        }

        System.out.println("Наибольшее число:");
        System.out.println("max = " + max);

        System.out.println("Наименьшее число:");
        System.out.println("min = " + min);
    }

    static void fun_6_3_4(int mass[]){
        int del_3_9[] = new int[mass.length];
        int del_5_7[] = new int[mass.length];
        int j=0,k=0;

        for(int i = 0; i<mass.length;  i++){
            if((mass[i] % 3 ==0) || (mass[i] % 9 ==0)){
                del_3_9[j]=mass[i];
                j++;
            } else if((mass[i] % 5 == 0) && (mass[i] % 7 ==0)){
                del_5_7[k]=mass[i];
                k++;
            }
        }
        System.out.println("Числа, которые делятся на 3 или на 9:");
        System.out.println(Arrays.toString(del_3_9));

        System.out.println();
        System.out.println("Задание 6.4");

        System.out.println("Числа, которые делятся на 5 и на 7:");
        System.out.println(Arrays.toString(del_5_7));
    }

    static void fun_6_5(int mass[]) {
        int mass_5[] = new int[mass.length];
        int j=0;

        for(int i = 0; i<mass.length;  i++){
            if (((mass[i] > 99) && (mass[i] < 1000)) || ((mass[i] < -99) && (mass[i] > -1000))) {
                int n1, n2, n3;

                n3 = mass[i] % 10;
                if (mass[i] % 100 >= 10) {
                    n2 = ((mass[i] % 100) - n3) / 10;
                } else {
                    n2 = 0;
                }
                n1 = (mass[i] - (n2 * 10) + n3) / 100;

                if ((n1 != n2) && (n2 != n3) && (n1 != n3)) {
                    mass_5[j] = mass[i];
                    j++;
                }
            }
        }

        System.out.println("Трехзначные числа, в десятичной записи которых нет одинаковых цифр:");
        System.out.println(Arrays.toString(mass_5));
    }

    static void fun_6_6(int mass[]){
        int happy_nubmer[] = new int[mass.length];
        int summa_1=0,summa_2=0,index=0;

        for(int i=0;i<mass.length; i++) {

            String number = Math.abs(mass[i]) + "";
            if (number.length() %2 == 0) {

                for (int j = 0; j < number.length() / 2; j++) {
                    summa_1+=Character.getNumericValue(number.charAt(j));
                }

                for (int j = number.length()-1; j > (number.length() / 2)-1; j--) {
                    summa_2+=Character.getNumericValue(number.charAt(j));
                }

                if(summa_1==summa_2){
                    happy_nubmer[index]=mass[i];
                    index++;
                }
                summa_1=summa_2=0;
            }
        }

        System.out.println("«Счастливые» числа:");
        System.out.println(Arrays.toString(happy_nubmer));
    }

    static void fun_6_7(int mass[]){
        int j = 0;
        int mass_7[]= new int[mass.length];

        for (int i = 0; i < mass.length; i++) {
            if (i == 0) {
                if (mass[i] == ((mass[mass.length - 1] + mass[i + 1]) / 2)) {
                    mass_7[j] = mass[i];
                    j++;
                }
            } else if (i == mass.length - 1) {
                if (mass[i] == (mass[i - 1] + mass[0]) / 2) {
                    mass_7[j] = mass[i];
                    j++;
                }
            } else {
                if (mass[i] == ((mass[i - 1] + mass[i + 1]) / 2)) {
                    mass_7[j] = mass[i];
                    j++;
                }
            }

        }

        System.out.println("Элементы, которые равны полусумме соседних элементов:");
        System.out.println(Arrays.toString(mass_7));

    }



}

