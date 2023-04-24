package cn.linter.learning.course.controller;

import cn.linter.learning.common.entity.Result;
import cn.linter.learning.common.entity.ResultStatus;
import cn.linter.learning.common.utils.JwtUtil;
import cn.linter.learning.course.entity.Course;
import cn.linter.learning.course.entity.UserCourseWork;
import cn.linter.learning.course.service.AnswerService;
import cn.linter.learning.course.service.UserCourseWorkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName UserCourseWorkController
 * @Description TODO
 * @Author zhangyan
 * @Date 2023/4/23 09:32
 * @Version 1.0
 **/
@RestController
@RequestMapping("work")
public class UserCourseWorkController {

    private final UserCourseWorkService userCourseWorkService;

    public UserCourseWorkController(UserCourseWorkService userCourseWorkService) {
        this.userCourseWorkService = userCourseWorkService;
    }
    @GetMapping("/{courseId}")
    public Result<List<UserCourseWork>> queryCourse(@PathVariable("courseId") Long courseId,@RequestHeader("Authorization") String token) {
        return Result.of(ResultStatus.SUCCESS, userCourseWorkService.queryById(courseId,JwtUtil.getUsername(token)));
    }

    @PostMapping("/save/{courseId}")
    public ResultStatus SaveCourse(@PathVariable("courseId") Long courseId,@RequestParam("name") String fileName,@RequestParam("url") String url,@RequestHeader("Authorization") String token) {

        UserCourseWork query = userCourseWorkService.query(courseId, fileName, JwtUtil.getUsername(token));
        if (null==query){
            return ResultStatus.SUCCESS;
        }
        userCourseWorkService.SaveCourse(courseId,fileName,url,JwtUtil.getUsername(token));
       return ResultStatus.SUCCESS;
    }

    @DeleteMapping("/{courseId}")
    public ResultStatus delete(@PathVariable("courseId") Long courseId,@RequestParam("name") String name,@RequestHeader("Authorization") String token) {
        userCourseWorkService.delete(courseId,name,JwtUtil.getUsername(token));
        return ResultStatus.SUCCESS;
    }
}
