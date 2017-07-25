package com.example.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by loopeer on 2017/7/25.
 */

public class lambdaTest {
    public static void main(String args[]){
//        noLa();
//        lambda1();
        lambda2();
    }

    private static void noLa(){
        List<String> features = Arrays.asList("Lambdas","Default Method","Stream API","Date and Time API");
        for(String feature : features){
            System.out.println(feature);
        }
    }

    private static void lambda1(){
        List features = Arrays.asList("Lambdas","Default Method","Stream API","Date and Time API");
        features.forEach(n->System.out.println(n));
        // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
    }

    private static void lambda2(){
        List features = Arrays.asList("Lambdas","Default Method","Stream API","Date and Time API");
        // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
        features.forEach(System.out::println);
    }


}
