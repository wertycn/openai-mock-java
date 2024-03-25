package icu.debug.ai.mocker.entity;

import lombok.*;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-23 15:16
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private String role;

    private String content;

}
