package cn.linter.learning.course.dao;

import cn.linter.learning.course.entity.UserCourseWork;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName UserCourseWorkDao
 * @Description TODO
 * @Author zhangyan
 * @Date 2023/4/23 09:33
 * @Version 1.0
 **/
@Mapper
public interface UserCourseWorkDao {
    /**
     * 获取文件列表
     * @param courseId
     * @param userName
     * @return
     */
    List<UserCourseWork> selectById(Long courseId,String userName);

    /**
     * 保存
     * @param userCourseWork
     */
    void save(UserCourseWork userCourseWork);

    /**
     * 删除
     * @param courseId
     * @param name
     * @param userName
     */
    void delete(Long courseId, String name, String userName);

    /**
     * 获取文件
     * @param courseId
     * @param name
     * @param userName
     * @return
     */
    UserCourseWork query(Long courseId, String name, String userName);
}
