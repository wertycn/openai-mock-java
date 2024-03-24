package icu.debug.ai.mocker.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-23 17:21
 */
@DisplayName("Token集合测试")
class TokenCollectionTest {

    @Test
    @DisplayName("TokenCollection 创建")
    void testCreateTokenCollection() {
        TokenCollection collection = new TokenCollection();
        collection.addToken(List.of(1), "1");
        collection.addToken(List.of(2), "2");
        assertEquals(2, collection.count());
        assertEquals("12", collection.getContent());
    }

}