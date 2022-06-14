package com.github.bmi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println("Enter Your Name");
        Scanner scanner = new Scanner(System.in);
        person.name = scanner.nextLine();

        System.out.println("Enter Your Family");
        person.family = scanner.nextLine();

        System.out.println("Enter Your Weight");
        person.weight = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Your Height");
        person.height = Integer.parseInt(scanner.nextLine());


        PersonServiceImp personServiceImp = new PersonServiceImp();

        float bmi = personServiceImp.clacBmi(person);
        System.out.println();
        System.out.println(person.name+"\n"+person.family +"\n"+"Your BMI is  ="+bmi);

    }
}
