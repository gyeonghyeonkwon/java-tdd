package com.ll.global.app;

import com.ll.domain.quotaion.quotation.entity.Quotation;

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

        final List<Quotation> quotations = new ArrayList<>();
        long lastQuotationId = 0;

        while (true) {
            final String cmd = scanner.nextLine().trim();

            switch (cmd) {

               case "삭제?id=1" -> {

                   quotations
                           .removeIf(quotation -> quotation.getId() == 1); //id 값이 1번이면 삭제

                   System.out.println("1번 명언이 삭제되었습니다.");
               }


                case "등록" -> {
                    System.out.print("명언 : ");
                    final String content = scanner.nextLine().trim();
                    System.out.print("작가 : ");
                    final String authorName = scanner.nextLine().trim();

                    final long id = ++lastQuotationId;

                    Quotation quotation = new Quotation(id, authorName, content);
                    quotations.add(quotation);

                    System.out.println("%d번 명언이 등록되었습니다.".formatted(id));
                }
                case "목록" -> {

                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");

                    quotations
                            .reversed()
                            .forEach(
                                    quotation -> System.out.println(
                                            "%d / %s / %s".formatted(
                                                    quotation.getId(),
                                                    quotation.getAuthorName(),
                                                    quotation.getContent()
                                            )
                                    )
                            );
                }

                case "종료" -> {
                    return;
                }
            }


        }
    }
}