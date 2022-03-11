package com.atguigu.eduservice.controller;


import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.atguigu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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

    @ApiOperation(value="分页查询讲师列表")
    @GetMapping("getTeacherPage/{current}/{limit}")
    public  R getTeacherPage(@PathVariable Long current, @PathVariable Long limit) {
        Page<EduTeacher> page = new Page<>(current, limit);
        teacherService.page(page, null);
        List<EduTeacher> records = page.getRecords();
        long total = page.getTotal();
        return R.ok().data("list", records).data("total", total);
    }

    @ApiOperation(value="分页查询讲师列表")
    @PostMapping("getTeacherPageVo/{current}/{limit}")
    public  R getTeacherPageVo(@PathVariable Long current, @PathVariable Long limit, @RequestBody TeacherQuery teacherQuery) {
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(name)){
            wrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(level)){
            wrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_create",begin);
        }
        if(!StringUtils.isEmpty(end)){
            wrapper.le("gmt_create",end);
        }
        Page<EduTeacher> page = new Page<>(current, limit);
        teacherService.page(page, wrapper);
        List<EduTeacher> records = page.getRecords();
        long total = page.getTotal();
        return R.ok().data("list", records).data("total", total);
    }

    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean save = teacherService.save(eduTeacher);
        if (save) {
            return R.ok();
        } else {
            return R.error();
        }
    }

}

