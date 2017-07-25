package com.example.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


/**
 * Created by loopeer on 2017/7/25.
 */

public class LambdaPredicate {



    public static void main(String args[]){
        Lambda1();
    }

    private static void Lambda1(){
        List<String> languages = Arrays.asList("Java","Scala","C++","Haskell","Lisp");;
        System.out.println("Languages which starts with J :");
        filter(languages, (str)->str.toString().startsWith("J"));
        System.out.println("Languages which ends with a ");

        filter(languages, (str)->str.toString().endsWith("a"));
        System.out.println("Print all languages :");

        filter(languages, (str)->true);

        System.out.println("Print no language : ");

        filter(languages, (str)->false);

        System.out.println("Print language whose length greater than 4:");

        filter(languages, (str)->str.toString().length() >4);

    }
    /*private static void filter(List<String> names, Predicate condition) {

        for(String name: names) {

            if(condition.test(name)) {

                System.out.println(name +" ");

            }

        }

    }
*/
    public static void filter(List names, Predicate condition) {

        names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {

            System.out.println(name +" ");

        });

    }

}
