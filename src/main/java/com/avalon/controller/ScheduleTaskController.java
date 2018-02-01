package com.avalon.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avalon.entity.quartz.ScheduleJob;
import com.avalon.service.quartz.ScheduleJobService;
import com.avalon.util.SysUtil;
import com.avalon.vo.Json;

@Controller
@RequestMapping("/task")
public class ScheduleTaskController {
    
    @Autowired
    private ScheduleJobService scheduleJobService;
    
    @RequestMapping("/list")
    @ResponseBody
    public Json list(Integer page, String query) {
        List<ScheduleJob> list=scheduleJobService.queryExecutingJobList();//执行中的任务
        return new Json(true,"ok",list);
    }
    
    @RequestMapping("/overLoad")
    @ResponseBody
    public Json overLoad() {
        scheduleJobService.init();
        return new Json(true,"ok","");
    }
    
    @RequestMapping("/add")
    @ResponseBody
    public Json add(ScheduleJob scheduleJob) {
        scheduleJob.setId(SysUtil.createID2());
        scheduleJob.setCreate(new Date());
        try {
            scheduleJobService.addJob(scheduleJob);
            return new Json(true,"定时任务添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Json(false,"定时任务添加失败");
        }
    }
    
    @RequestMapping("/edit")
    @ResponseBody
    public Json edit(ScheduleJob scheduleJob) {
        
        ScheduleJob job = scheduleJobService.findJob(scheduleJob.getId());
        
        try {
            scheduleJob.setModify(new Date());
            scheduleJobService.updateJob(scheduleJob);
            return new Json(true,"定时任务修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Json(true,"定时任务修改失败");
        }
    }
    
    
    
}
