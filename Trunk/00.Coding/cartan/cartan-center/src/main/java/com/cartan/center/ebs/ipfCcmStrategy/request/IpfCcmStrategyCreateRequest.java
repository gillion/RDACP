/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmStrategy.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.ipfCcmStrategy.domain.IpfCcmStrategy;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class IpfCcmStrategyCreateRequest extends AbstractRopRequest {
	@Size(min = 0, max = 50)
	private String id;//主键
	@Size(min = 0, max = 50)
	private String strategyType;//策略类别
	@Size(min = 0, max = 50)
	private String strategyCode;//策略编码
	@Size(min = 0, max = 50)
	private String strategyName;//策略名称
	@Size(min = 0, max = 1000)
	private String strategyDes;//策略描述
	@Size(min = 0, max = 1000)
	private String drlFile;//DRL文件
	@Size(min = 0, max = 1000)
	private String drlRoute;//DRL路径
	@Size(min = 0, max = 50)
	private String packageName;//包名
	@Size(min = 0, max = 50)
	private String ruleNo;//规则号
	@Size(min = 0, max = 50)
	private String ruleType;//规则类型
	@Size(min = 0, max = 50)
	private String sourceCode;//源代码
	@Size(min = 0, max = 50)
	private String svnRevision;//SVN版本
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	public String getStrategyType() {
		return this.strategyType;
	}
	
	public void setStrategyType(String strategyType) {
		this.strategyType = strategyType;
	}
	public String getStrategyCode() {
		return this.strategyCode;
	}
	
	public void setStrategyCode(String strategyCode) {
		this.strategyCode = strategyCode;
	}
	public String getStrategyName() {
		return this.strategyName;
	}
	
	public void setStrategyName(String strategyName) {
		this.strategyName = strategyName;
	}
	public String getStrategyDes() {
		return this.strategyDes;
	}
	
	public void setStrategyDes(String strategyDes) {
		this.strategyDes = strategyDes;
	}
	public String getDrlFile() {
		return this.drlFile;
	}
	
	public void setDrlFile(String drlFile) {
		this.drlFile = drlFile;
	}
	public String getDrlRoute() {
		return this.drlRoute;
	}
	
	public void setDrlRoute(String drlRoute) {
		this.drlRoute = drlRoute;
	}
	public String getPackageName() {
		return this.packageName;
	}
	
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getRuleNo() {
		return this.ruleNo;
	}
	
	public void setRuleNo(String ruleNo) {
		this.ruleNo = ruleNo;
	}
	public String getRuleType() {
		return this.ruleType;
	}
	
	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}
	public String getSourceCode() {
		return this.sourceCode;
	}
	
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
	public String getSvnRevision() {
		return this.svnRevision;
	}
	
	public void setSvnRevision(String svnRevision) {
		this.svnRevision = svnRevision;
	}
	
	public IpfCcmStrategyCreateRequest(){}
	
	public IpfCcmStrategyCreateRequest(IpfCcmStrategy ipfCcmStrategy){
		BeanUtils.copyProperties(ipfCcmStrategy,this);
	}
	/**
	 * 拷贝属性值到制定BO
	 */
	public void copyValueTo(IpfCcmStrategy bo){
		BeanUtils.copyProperties(this,bo);
	}
	public IpfCcmStrategy cloneBO(){
		IpfCcmStrategy bo = new IpfCcmStrategy();
		this.copyValueTo(bo);
		return bo;
	}
	
	public static List<IpfCcmStrategy> cloneBOList(List<IpfCcmStrategyCreateRequest> vos){
		if(vos==null||vos.isEmpty())return new ArrayList<IpfCcmStrategy>(0);
		List<IpfCcmStrategy> result = new ArrayList<IpfCcmStrategy>(vos.size());
		for(IpfCcmStrategyCreateRequest vo: vos){
			IpfCcmStrategy bo = vo.cloneBO();
			result.add(bo);
		}
		return result;
	}

}

