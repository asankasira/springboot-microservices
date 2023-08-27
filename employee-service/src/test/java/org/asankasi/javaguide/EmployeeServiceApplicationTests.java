package org.asankasi.javaguide;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EmployeeServiceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void sampleTest() {
        String name = "Hello, World!";
        assertThat(name).contains("Hello");
    }

}
