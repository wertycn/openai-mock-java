package icu.debug.ai.mocker.core.iface;

import icu.debug.ai.mocker.entity.TokenCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-23 23:09
 */
@DisplayName("tokenizer 测试")
class TokenizerTest {

    @Test
    @DisplayName("CL100K-Base-Tokenizer 测试")
    void testCl100kBaseTokenizer() {
        Cl100kBaseTokenizer tokenizer = new Cl100kBaseTokenizer();
        List<TokenCollection> collections = tokenizer.split("很久");
        assertEquals(2, collections.size());
        TokenCollection tokenCollection = collections.get(0);
        assertEquals("很", tokenCollection.getContent());
        assertEquals(2, tokenCollection.count());

    }

}