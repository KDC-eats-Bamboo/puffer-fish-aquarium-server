package kdc.eats.bamboo.server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class BogeoServerApplicationTests {

    @Test
    void test_normalized() {
        for (int i = 0; i < 100; i++) {
            Float value = new Random().nextFloat() * 70 + 5;
            System.out.println(value);
            Integer normalized = BogeoService.normalize(value, 5f, 75f);
            System.out.println(normalized);
            Boolean result = normalized >= 0f && normalized <= 100f;
            System.out.println(result);
            if (!result) {
                System.out.println("❌테스트 실패");
                return;
            }
        }
        System.out.println("✅테스트 성공");
    }
}
