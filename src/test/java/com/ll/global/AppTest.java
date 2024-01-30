package com.ll.global;

import com.ll.global.app.App;
import com.ll.statandard.util.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AppTest {

    private static String run(final String cmd) {


        final Scanner scanner = TestUtil.genScanner(cmd.stripIndent().trim() + "\n종료");


        final  ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

        new App(scanner).run();

        final String out = byteArrayOutputStream.toString().trim();

        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);

        return out.trim();
    }

    @Test
    @DisplayName("프로그램 시작 시 ==명언앱==  출력")
    void t1() {
        final String out = run("");

        assertThat(out).contains("==명언앱==");
    }

    @Test
    @DisplayName("종료")
    void t2() {
        final  String out = run("");


    }

    @Test
    @DisplayName("등록")
    void t3() {
        final String out = run("""
                등록
                현재를 사랑하라.
                작자미상
                종료""");

        assertThat(out).contains("명언 :")
                         .contains("작가 :")
                        .contains("1번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("등록할 때 마다 번호 증가 ")
    void t4() {
        final String out = run("""
                등록
                현재를 사랑하라.
                작자미상
                종료""");

        assertThat(out).contains("명언 :")
                .contains("작가 :")
                .contains("1번 명언이 등록되었습니다.")
                .doesNotContain("2번 명언이 등록되었습니다"); //1 번 등록 시  2번 명언이 등록되었습니다 가 출력되면안됨

        final String out2 = run(""" 
                등록
                현재를 사랑하라.
                작자미상
                등록
                현재를 사랑하라.
                작자미상
                종료"""); //2번 등록 시 3번 명언이 등록 되었습니다 가 출력되면 안됨

        assertThat(out2).contains("명언 :")
                .contains("작가 :")
                .contains("1번 명언이 등록되었습니다.")
                .contains("2번 명언이 등록되었습니다")
                .doesNotContain("3번 명언이 등록되었습니다");  //3번 등록시

    }


}
