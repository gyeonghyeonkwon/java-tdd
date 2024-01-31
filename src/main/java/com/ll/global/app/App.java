package com.ll.global.app;

import com.ll.domain.quotaion.quotation.controller.QuotationController;
import com.ll.domain.quotaion.quotation.entity.Quotation;
import com.ll.global.rq.Rq;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final Scanner scanner;


    public App(final Scanner scanner) {
        this.scanner = scanner;


    }


    public void run() {

        System.out.println("==명언 앱==");
        final QuotationController quotationController = new QuotationController(scanner);

        while (true) {
            final String cmd = scanner.nextLine().trim();

            final Rq rq = new Rq(cmd);
            final String action = rq.getAction();

            switch (action) {

                case "삭제" -> {
                    quotationController.actionRemove(rq);
                }

                case "수정" -> {
                    quotationController.actionModify(rq);
                }

                case "등록" -> {
                    quotationController.actionWrite();
                }
                case "목록" -> {

                    quotationController.actionShowList();
                }

                case "종료" -> {
                    return;
                }
            }


        }
    }

    private void actionRemove(final Rq rq) {



    }

    private void actionModify(final Rq rq) {


    }

    private void actionShowList() {


    }

    private void actionWrite() {


    }
}