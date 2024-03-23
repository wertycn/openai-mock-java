package icu.debug.ai.mocker.core;

/**
 * token生成器
 * <p>
 * 用于模拟模型输出token的方式进行输出，支持流式及阻塞式
 * </p>
 *
 * @author hanjinxiang@debug.icu
 * @date 2024-03-20 0:07
 */
public interface TokenGenerator {

    default String generate(String token, int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new IllegalStateException("");
        }
        return token;
    }

}
