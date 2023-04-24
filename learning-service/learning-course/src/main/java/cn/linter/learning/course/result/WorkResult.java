package cn.linter.learning.course.result;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @ClassName WorkResult
 * @Description TODO
 * @Author zhangyan
 * @Date 2023/4/23 14:06
 * @Version 1.0
 **/
@Data
@ToString
@EqualsAndHashCode
public class WorkResult {
    private String name;
    private  String url;

}
