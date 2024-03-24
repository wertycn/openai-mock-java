package icu.debug.ai.mocker.core.impl;

import com.knuddels.jtokkit.Encodings;
import com.knuddels.jtokkit.api.Encoding;
import com.knuddels.jtokkit.api.EncodingRegistry;
import com.knuddels.jtokkit.api.EncodingType;
import com.knuddels.jtokkit.api.IntArrayList;
import icu.debug.ai.mocker.core.iface.Tokenizer;
import icu.debug.ai.mocker.entity.TokenCollection;
import io.netty.util.internal.StringUtil;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于OpenAI cl100k-base 词表的token分词器
 *
 * @author hanjinxiang@debug.icu
 * @date 2024-03-23 23:09
 */
public class Cl100kBaseTokenizer implements Tokenizer {

    private final Encoding encoding;

    public Cl100kBaseTokenizer() {
        EncodingRegistry registry = Encodings.newDefaultEncodingRegistry();
        this.encoding = registry.getEncoding(EncodingType.CL100K_BASE);
    }

    @Override
    public List<TokenCollection> split(String content) {
        List<TokenCollection> result = new ArrayList<>();
        if (content == null || content.isEmpty()) {
            return result;
        }
        List<Integer> tokens = encoding.encode(content).boxed();
        StringBuilder contentBuilder = new StringBuilder(content);

        // 内容指针
        int builderPoint = 0;
        // token 收集器
        IntArrayList tokenCollect = new IntArrayList();
        for (Integer token : tokens) {
            tokenCollect.add(token);
            //对每个token尝试进行解码
            String decodeResult = encoding.decode(tokenCollect);
            String exp = contentBuilder.substring(builderPoint, builderPoint + decodeResult.length());
            // 如果解码结果和预期结果不符，继续增加一个token再尝试
            if (!exp.equals(decodeResult)) {
                continue;
            }
            builderPoint += decodeResult.length();
            // copy token 列表
            List<Integer> thatTokens = new ArrayList<>(tokenCollect.boxed());
            result.add(new TokenCollection(thatTokens, decodeResult));
            // 清空token收集器，重新开始新一轮收集
            tokenCollect.clear();
        }
        Assert.isTrue(tokenCollect.isEmpty(), "token collect not empty! please confirm decode result!");
        return result;
    }
}
