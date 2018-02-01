package com.avalon.service.quartz;


import java.util.ArrayList;
import java.util.List;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avalon.dao.MyBatisDao;
import com.avalon.entity.quartz.ScheduleJob;
import com.avalon.util.ScheduleUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author weir
 * @since 2017-07-10
 */
@Service
public class ScheduleJobService{
    @Autowired
    private Scheduler scheduler;

    @Autowired
    private MyBatisDao<ScheduleJob>  mybatisDao;
    
    private static final Logger LOGGER =  LoggerFactory.getLogger(ScheduleJobService.class);  
    
    public void excute(ScheduleJob scheduleJob){
        LOGGER.info("执行job任务。。。");
    }
    
    public List<ScheduleJob> selectListJobs(ScheduleJob entity){
        List<ScheduleJob> list=new ArrayList<ScheduleJob>();
        try {
            list=mybatisDao.getAllByEntity("SchedulejobMapper.select", entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean addJob(ScheduleJob entity){
        try {
            return mybatisDao.add("insertSelective.insertSelective", entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ScheduleJob findJob(String id){
        ScheduleJob entity=new ScheduleJob();
        entity.setId(id);
        try {
            entity=mybatisDao.get("SchedulejobMapper.select", entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }
    
    public boolean updateJob(ScheduleJob entity){
        try {
            return mybatisDao.edit("SchedulejobMapper.updateSelectiveById", entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delJob(String id){
        ScheduleJob entity=new ScheduleJob();
        entity.setId(id);
        try {
            return mybatisDao.remove("SchedulejobMapper.delete", entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    

    public void init() {
        List<ScheduleJob> scheduleJobs = selectListJobs(null);
        System.out.println(scheduleJobs);
        for (ScheduleJob scheduleJob : scheduleJobs) {
            CronTrigger cronTrigger;
            try {
                cronTrigger = ScheduleUtils.getCronTrigger(scheduler, scheduleJob.getName(), scheduleJob.getGroup());
                if (cronTrigger!=null) {
//                  ScheduleUtils.deleteScheduleJob(scheduler, scheduleJob.getName(), scheduleJob.getGroup());
                    // 已存在，那么更新相应的定时设置
                    ScheduleUtils.updateScheduleJob(scheduler, scheduleJob);
                }else {
                    ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
                }
                
                /*if (scheduleJob.getIsSync()) {
                    if (BaseUtil.isEmpty(scheduleJob.getClassNameSync())) {
                        continue;
                    }
                }else {
                    if (BaseUtil.isEmpty(scheduleJob.getClassName())) {
                        continue;
                    }
                }*/
                
                
                /*// 不存在，创建一个
                if (cronTrigger == null) {
                    
                } else {
                    // 已存在，那么更新相应的定时设置
                    ScheduleUtils.updateScheduleJob(scheduler, scheduleJob);
                }*/
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }
    }

    public List<ScheduleJob> queryExecutingJobList() {
        try {
            List<JobExecutionContext> executingJobs = scheduler.getCurrentlyExecutingJobs();;
            /*while (true) {
                executingJobs = scheduler.getCurrentlyExecutingJobs();
                if (executingJobs.size()>0) {
                    break;
                }
            }*/
            
            List<ScheduleJob> jobList = new ArrayList<ScheduleJob>(
                    executingJobs.size());
            for (JobExecutionContext executingJob : executingJobs) {
                ScheduleJob job = new ScheduleJob();
                JobDetail jobDetail = executingJob.getJobDetail();
                JobKey jobKey = jobDetail.getKey();
                Trigger trigger = executingJob.getTrigger();
                job.setName(jobKey.getName());
                job.setGroup(jobKey.getGroup());
                job.setJobTrigger(trigger.getKey().getName());
                Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
                job.setStatus(triggerState.name());
                if (trigger instanceof CronTrigger) {
                    CronTrigger cronTrigger = (CronTrigger) trigger;
                    String cronExpression = cronTrigger.getCronExpression();
                    job.setCronExpression(cronExpression);
                }
                jobList.add(job);
            }
            return jobList;
        } catch (SchedulerException e) {
            e.printStackTrace();
            return null;
        }

    }
    
}
