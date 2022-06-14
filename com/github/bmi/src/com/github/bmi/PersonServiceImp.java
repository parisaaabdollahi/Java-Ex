package com.github.bmi;

public class PersonServiceImp implements PersonService {
    @Override
    public float clacBmi(Person person) {

        float bmi =(float) person.weight/(float) (person.height*person.height);
        return bmi;


    }
}
