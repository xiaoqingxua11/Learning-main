package cn.linter.learning.course.service;

import cn.linter.learning.course.entity.UserCourseWork;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserCourseWorkService {
    /**
     * 获取当前用户在该课程下提交的作业
     * @param courseId
     * @param userName
     * @return
     */
    List<UserCourseWork>queryById(Long courseId, String userName);

    /**
     * 保存用户作业
     * @param courseId
     * @param url
     * @param username
     */
    void SaveCourse(Long courseId,String fileName ,String url, String username);

    /**
     * 删除文件
     * @param courseId
     * @param name
     * @param userName
     */
    void delete(Long courseId, String name, String userName);

    UserCourseWork query(Long courseId, String name, String userName);
}
