package com.firstproject.argumentparser;


/**
 * Created by johmcali on 4/8/17.
 */
public class ArgumentParser {

    public static void main(final String[] args) {
        //try {
        Args arg = new  Args("d*", args);
        //} catch (ArgsException) {

        //}
    }

    public static void helloWorld() {
        System.out.println("Hello, World!");
    }

}
