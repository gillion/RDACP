package com.cartan.core.ipfScheduleJob.domain;
import java.io.Serializable;


/**
 * IpfScheduleJob
 */
public class IpfScheduleJob implements Serializable{
	private String ID;//主键
	private String JOB_NAME;//任务名称
	private String JOB_GROUP;//任务分组
	private String JOB_STATUS;//任务状态
	private String CRON_EXPRESSION;//执行频率
	private String JOB_DESC;//任务描述
	private String RULE_NO;//规则号
	private String JOB_SERVICE;//任务对象
	private String JOB_METHOD;//任务方法
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getJobName() {
		return this.JOB_NAME;
	}
	
	public void setJobName(String value) {
		this.JOB_NAME = value;
	}
	

	public String getJobGroup() {
		return this.JOB_GROUP;
	}
	
	public void setJobGroup(String value) {
		this.JOB_GROUP = value;
	}
	

	public String getJobStatus() {
		return this.JOB_STATUS;
	}
	
	public void setJobStatus(String value) {
		this.JOB_STATUS = value;
	}
	

	public String getCronExpression() {
		return this.CRON_EXPRESSION;
	}
	
	public void setCronExpression(String value) {
		this.CRON_EXPRESSION = value;
	}
	

	public String getJobDesc() {
		return this.JOB_DESC;
	}
	
	public void setJobDesc(String value) {
		this.JOB_DESC = value;
	}
	

	public String getRuleNo() {
		return this.RULE_NO;
	}
	
	public void setRuleNo(String value) {
		this.RULE_NO = value;
	}
	

	public String getJobService() {
		return this.JOB_SERVICE;
	}
	
	public void setJobService(String value) {
		this.JOB_SERVICE = value;
	}
	

	public String getJobMethod() {
		return this.JOB_METHOD;
	}
	
	public void setJobMethod(String value) {
		this.JOB_METHOD = value;
	}
	

}
