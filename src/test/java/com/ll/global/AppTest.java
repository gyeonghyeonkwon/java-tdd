package com.ll.global;

import com.ll.global.app.App;
import com.ll.statandard.util.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AppTest {
    @Test
    @DisplayName("테스트 명언앱")
    void t1() {
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

        new App();

        String out = byteArrayOutputStream.toString().trim();

        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);

        assertThat(out).contains("==명언앱==");
    }

}
