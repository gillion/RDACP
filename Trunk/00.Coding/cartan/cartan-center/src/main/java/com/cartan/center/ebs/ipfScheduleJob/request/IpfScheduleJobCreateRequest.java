/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfScheduleJob.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfScheduleJob.domain.IpfScheduleJob;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfScheduleJobCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String jobName;//任务名称
	@Size(min = 0, max = 50)
	private String jobGroup;//任务分组
	@Size(min = 0, max = 50)
	private String jobStatus;//任务状态
	@Size(min = 0, max = 1000)
	private String cronExpression;//执行频率
	@Size(min = 0, max = 1000)
	private String jobDesc;//任务描述
	@Size(min = 0, max = 50)
	private String ruleNo;//规则号
	@Size(min = 0, max = 50)
	private String jobService;//任务对象
	@Size(min = 0, max = 50)
	private String jobMethod;//任务方法
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getJobName() {
		return this.jobName;
	}
	
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobGroup() {
		return this.jobGroup;
	}
	
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}
	public String getJobStatus() {
		return this.jobStatus;
	}
	
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	public String getCronExpression() {
		return this.cronExpression;
	}
	
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}
	public String getJobDesc() {
		return this.jobDesc;
	}
	
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	public String getRuleNo() {
		return this.ruleNo;
	}
	
	public void setRuleNo(String ruleNo) {
		this.ruleNo = ruleNo;
	}
	public String getJobService() {
		return this.jobService;
	}
	
	public void setJobService(String jobService) {
		this.jobService = jobService;
	}
	public String getJobMethod() {
		return this.jobMethod;
	}
	
	public void setJobMethod(String jobMethod) {
		this.jobMethod = jobMethod;
	}
	
	public IpfScheduleJobCreateRequest(){}
	
	public IpfScheduleJobCreateRequest(IpfScheduleJob ipfScheduleJob){
		BeanUtils.copyProperties(ipfScheduleJob,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfScheduleJob bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfScheduleJob cloneBO(){
		IpfScheduleJob bo = new IpfScheduleJob();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfScheduleJob> cloneBOList(List<IpfScheduleJobCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfScheduleJob>(0);
		List<IpfScheduleJob> result = new ArrayList<IpfScheduleJob>(vos.size());
		for(IpfScheduleJobCreateRequest vo: vos){
			IpfScheduleJob bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}

