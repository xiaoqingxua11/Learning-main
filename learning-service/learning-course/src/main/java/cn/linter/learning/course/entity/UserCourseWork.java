package cn.linter.learning.course.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

/**
 * @ClassName UserCourseWork
 * @Description 用户提交作业
 * @Author zhangyan
 * @Date 2023/4/23 09:24
 * @Version 1.0
 **/
@Data
@ToString
@EqualsAndHashCode
public class UserCourseWork {

    /**
     * 文件id
     */
    private Long id;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 课程id
     */
    private Long courseId;
    /**
     * 文件路径
     */
    private String filePath;
    /**
     * 文件名称
     */
    private String fileName;
}
