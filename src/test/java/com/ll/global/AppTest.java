package com.ll.global;

import com.ll.global.app.App;
import com.ll.statandard.util.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AppTest {
    @Test
    @DisplayName("프로그램 시작 시 ==명언앱==  출력")
    void t1() {

        Scanner scanner = TestUtil.genScanner("""
                종료
                """.stripIndent());


        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

        new App(scanner).run();

        String out = byteArrayOutputStream.toString().trim();

        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);

        assertThat(out).contains("==명언앱==");
    }

    @Test
    @DisplayName("종료")
    void t2() {

        Scanner scanner = TestUtil.genScanner("""
                종료
                """.stripIndent());

        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

        new App(scanner).run();

        String out = byteArrayOutputStream.toString().trim();

        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);

    }

    @Test
    @DisplayName("등록")
    void t3() {

        Scanner scanner = TestUtil.genScanner("""
                등록
                현재를 사랑하라.
                작자미상
                종료
                """.stripIndent());

        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

        new App(scanner).run();

        String out = byteArrayOutputStream.toString().trim();

        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);

        assertThat(out).contains("명언 :")
                .contains("작가: ");
    }

}
