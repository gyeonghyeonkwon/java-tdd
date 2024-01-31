package com.ll;

import com.ll.global.app.App;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");

        Scanner scanner = new Scanner(System.in);
        App app = new App(scanner);
        app.run();
    }
}