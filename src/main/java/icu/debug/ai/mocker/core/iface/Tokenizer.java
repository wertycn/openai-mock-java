package icu.debug.ai.mocker.core.iface;

import icu.debug.ai.mocker.entity.TokenCollection;

import java.util.List;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-23 23:07
 */
public interface Tokenizer {

    List<TokenCollection> split(String content);

}
