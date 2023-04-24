package cn.linter.learning.course.service.impl;

import cn.linter.learning.course.dao.QuestionDao;
import cn.linter.learning.course.dao.UserCourseWorkDao;
import cn.linter.learning.course.entity.UserCourseWork;
import cn.linter.learning.course.service.UserCourseWorkService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName UserCourseWorkServiceImpl
 * @Description TODO
 * @Author zhangyan
 * @Date 2023/4/23 09:32
 * @Version 1.0
 **/
@Service
public class UserCourseWorkServiceImpl  implements UserCourseWorkService {

    private final UserCourseWorkDao userCourseWorkDao;

    public UserCourseWorkServiceImpl(UserCourseWorkDao userCourseWorkDao) {
        this.userCourseWorkDao = userCourseWorkDao;
    }
    @Override
    public List<UserCourseWork> queryById(Long courseId, String userName) {
        List<UserCourseWork> userCourseWorks = userCourseWorkDao.selectById(courseId, userName);
        return userCourseWorks;
    }

    @Override
    public void SaveCourse(Long courseId, String fileName,String url, String username) {
        UserCourseWork userCourseWork = new UserCourseWork();
        userCourseWork.setCourseId(courseId);
        userCourseWork.setCreatedTime(Date.valueOf(LocalDate.now()));
        userCourseWork.setFilePath(url);
        userCourseWork.setFileName(fileName);
        userCourseWork.setCreatedBy(username);
        userCourseWorkDao.save(userCourseWork);
    }

    @Override
    public void delete(Long courseId, String name, String userName) {
        userCourseWorkDao.delete(courseId,name,userName);
    }

    @Override
    public UserCourseWork query(Long courseId, String name, String userName) {
         return userCourseWorkDao.query(courseId,name,userName);
    }
}
