package icu.debug.ai.mocker.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-23 15:16
 */
@Getter
@Setter
@ToString
public class Message {

    private String role;

    private String content;

}
