package com.sphinx.job.service;

import org.quartz.SchedulerException;

import com.sphinx.common.base.CoreService;
import com.sphinx.job.domain.TaskDO;


/**
 * <pre>
 * 定时任务
 * </pre>
 * <small> 2018年3月22日 | Aron</small>
 */
public interface JobService extends CoreService<TaskDO> {
	
	void initSchedule() throws SchedulerException;

	void changeStatus(Long jobId, String cmd) throws SchedulerException;

	void updateCron(Long jobId) throws SchedulerException;

	void runNowOnce(Long jobId)  throws SchedulerException ;
}
