package com.avalon.service.quartz.factory;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.avalon.entity.quartz.ScheduleJob;
import com.avalon.service.quartz.ScheduleJobService;

/**
 * 
 * @类名: JobSyncFactory
 * @功能描述:同步的任务工厂类
 * @类创建人: Evan
 * @类创建时间： 2018-1-22 下午04:29:59
 */
public class JobSyncFactory implements Job{
    
    @Autowired
    private ScheduleJobService scheduleJobService;
    
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap mergedJobDataMap = jobExecutionContext.getMergedJobDataMap();
        ScheduleJob scheduleJob = (ScheduleJob) mergedJobDataMap.get("jobParam");
        System.out.println("jobName:" + scheduleJob.getName() + "  " + scheduleJob);
        if(scheduleJobService!=null){
            scheduleJobService.excute(scheduleJob);
        }
    }
}
