package com.cartan.core.ipfCcmStrategy.domain;
import java.io.Serializable;


/**
 * IpfCcmStrategy
 */
public class IpfCcmStrategy implements Serializable{
	private String ID;//主键
	private String STRATEGY_TYPE;//策略类别
	private String STRATEGY_CODE;//策略编码
	private String STRATEGY_NAME;//策略名称
	private String STRATEGY_DES;//策略描述
	private String DRL_FILE;//DRL文件
	private String DRL_ROUTE;//DRL路径
	private String PACKAGE_NAME;//包名
	private String RULE_NO;//规则号
	private String RULE_TYPE;//规则类型
	private String SOURCE_CODE;//源代码
	private String SVN_REVISION;//SVN版本
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.ID;
	}
	
	public void setId(String Id) {
		this.ID = Id;
	}
	

	public String getStrategyType() {
		return this.STRATEGY_TYPE;
	}
	
	public void setStrategyType(String value) {
		this.STRATEGY_TYPE = value;
	}
	

	public String getStrategyCode() {
		return this.STRATEGY_CODE;
	}
	
	public void setStrategyCode(String value) {
		this.STRATEGY_CODE = value;
	}
	

	public String getStrategyName() {
		return this.STRATEGY_NAME;
	}
	
	public void setStrategyName(String value) {
		this.STRATEGY_NAME = value;
	}
	

	public String getStrategyDes() {
		return this.STRATEGY_DES;
	}
	
	public void setStrategyDes(String value) {
		this.STRATEGY_DES = value;
	}
	

	public String getDrlFile() {
		return this.DRL_FILE;
	}
	
	public void setDrlFile(String value) {
		this.DRL_FILE = value;
	}
	

	public String getDrlRoute() {
		return this.DRL_ROUTE;
	}
	
	public void setDrlRoute(String value) {
		this.DRL_ROUTE = value;
	}
	

	public String getPackageName() {
		return this.PACKAGE_NAME;
	}
	
	public void setPackageName(String value) {
		this.PACKAGE_NAME = value;
	}
	

	public String getRuleNo() {
		return this.RULE_NO;
	}
	
	public void setRuleNo(String value) {
		this.RULE_NO = value;
	}
	

	public String getRuleType() {
		return this.RULE_TYPE;
	}
	
	public void setRuleType(String value) {
		this.RULE_TYPE = value;
	}
	

	public String getSourceCode() {
		return this.SOURCE_CODE;
	}
	
	public void setSourceCode(String value) {
		this.SOURCE_CODE = value;
	}
	

	public String getSvnRevision() {
		return this.SVN_REVISION;
	}
	
	public void setSvnRevision(String value) {
		this.SVN_REVISION = value;
	}
	

}
