package com.atguigu.eduservice.controller;


import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.service.EduTeacherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.atguigu.commonutils.R;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-03-10
 */
@RestController
@RequestMapping("/eduservice/eduteacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService teacherService;

    @GetMapping
    public R getAllTeacher() {
        List<EduTeacher> list = teacherService.list(null);
        return R.ok().data("list",list);
    }

    @DeleteMapping("{id}")
    public R delTeacher(@PathVariable String id) {
        boolean remove = teacherService.removeById(id);
       if(remove) {
           return R.ok();
       } else {
           return R.error();
       }
    }

//    @ApiOperation(value="分页查询讲师列表")
//    @GetMapping("")
//    public  R getTeacherPage(@PathVariable Long current, @PathVariable Long limit) {
//
//    }

}

