/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.sectionPartition;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.sectionPartition.request.*;
import com.cartan.center.ebs.sectionPartition.response.*;
import com.cartan.core.sectionPartition.domain.SectionPartition;
import com.cartan.core.sectionPartition.service.SectionPartitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class SectionPartitionServiceEbsBase {
    static Logger logger = Logger.getLogger(SectionPartitionServiceEbs.class.getName());
	private SectionPartitionService  sectionPartitionService;
	
    public SectionPartitionService getSectionPartitionService() {
        return sectionPartitionService;
    }

    @Autowired
    public void setSectionPartitionService(SectionPartitionService sectionPartitionService) {
        this.sectionPartitionService = sectionPartitionService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sectionPartition.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(SectionPartitionGetSessionRequest request) {      
    	SectionPartitionGetSessionResponse sectionPartitionGetSessionResponse = new SectionPartitionGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	sectionPartitionGetSessionResponse.setResultString("0");
        } else {
        	sectionPartitionGetSessionResponse.setResultString("1");
            sectionPartitionGetSessionResponse.setSessionId(request.getSessionId());
        }
        return sectionPartitionGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sectionPartition.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(SectionPartitionGetSessionRequest request) {
    	SectionPartitionGetSessionResponse sectionPartitionGetSessionResponse = new SectionPartitionGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            sectionPartitionGetSessionResponse.setResultString("1");
        } else {
        	sectionPartitionGetSessionResponse.setResultString("0");
        }
        sectionPartitionGetSessionResponse.setSessionId(request.getSessionId());
        return sectionPartitionGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sectionPartition.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(SectionPartitionGetSessionRequest request) {
    	SectionPartitionGetSessionResponse sectionPartitionGetSessionResponse = new SectionPartitionGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	sectionPartitionGetSessionResponse.setResultString("0");
        	sectionPartitionGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            sectionPartitionGetSessionResponse.setResultString("1");
        }
        return sectionPartitionGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sectionPartition.createSectionPartition", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createSectionPartition(SectionPartitionCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_SectionPartition_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        SectionPartition sectionPartition=new SectionPartition();
        sectionPartition.setId(request.getId());    		
        sectionPartition.setSectionName(request.getSectionName());
        sectionPartition.setStatus(request.getStatus());
        sectionPartition.setModifyDate(request.getModifyDate());
        sectionPartition.setModifyed(request.getModifyed());
        sectionPartition.setOwner(request.getOwner());
        sectionPartition.setLocked(request.getLocked());
    	sectionPartitionService.createSectionPartition(sectionPartition);
        //返回响应
        SectionPartitionCreateResponse sectionPartitionCreateResponse = new SectionPartitionCreateResponse();
        sectionPartitionCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        sectionPartitionCreateResponse.setResultJson(sectionPartition);
        return sectionPartitionCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sectionPartition.deleteSectionPartition", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteSectionPartition(SectionPartitionDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_SectionPartition_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        sectionPartitionService.deleteSectionPartition(idstr);
        //返回响应
        SectionPartitionDeleteResponse sectionPartitionDeleteResponse = new SectionPartitionDeleteResponse();
        sectionPartitionDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return sectionPartitionDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sectionPartition.updateSectionPartition", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateSectionPartition(SectionPartitionUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_SectionPartition_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        SectionPartition sectionPartition=new SectionPartition();
        sectionPartition=sectionPartitionService.getSectionPartition(request.getId());
        if (request.getId()!=null){
	        sectionPartition.setId(request.getId());
        }
        if (request.getSectionName()!=null){
	        sectionPartition.setSectionName(request.getSectionName());
        }
        if (request.getStatus()!=null){
	        sectionPartition.setStatus(request.getStatus());
        }
        if (request.getModifyDate()!=null){
	        sectionPartition.setModifyDate(request.getModifyDate());
        }
        if (request.getModifyed()!=null){
	        sectionPartition.setModifyed(request.getModifyed());
        }
        if (request.getOwner()!=null){
	        sectionPartition.setOwner(request.getOwner());
        }
        if (request.getLocked()!=null){
	        sectionPartition.setLocked(request.getLocked());
        }
    	sectionPartitionService.updateSectionPartition(sectionPartition);
        //返回响应
        SectionPartitionUpdateResponse sectionPartitionUpdateResponse = new SectionPartitionUpdateResponse();
        sectionPartitionUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        sectionPartitionUpdateResponse.setResultJson(sectionPartition);
        return sectionPartitionUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sectionPartition.getSectionPartition", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getSectionPartition(SectionPartitionGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        SectionPartition sectionPartition=new SectionPartition();
        sectionPartition=sectionPartitionService.getSectionPartition(id);
        //返回响应
        SectionPartitionGetResponse sectionPartitionGetResponse = new SectionPartitionGetResponse();
        sectionPartitionGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        sectionPartitionGetResponse.setResultJson(sectionPartition);
        return sectionPartitionGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sectionPartition.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(SectionPartitionSelectAllRequest request) {
        SectionPartitionSelectAllResponse sectionPartitionSelectAllResponse = new SectionPartitionSelectAllResponse();
        sectionPartitionSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        sectionPartitionSelectAllResponse.setResultJson(sectionPartitionService.selectAll());
        return sectionPartitionSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sectionPartition.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(SectionPartitionCountAllRequest request) {
        SectionPartitionCountAllResponse sectionPartitionCountAllResponse = new SectionPartitionCountAllResponse();
        sectionPartitionCountAllResponse.setResultString(String.valueOf(sectionPartitionService.countAll()));
        sectionPartitionCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return sectionPartitionCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sectionPartition.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(SectionPartitionSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        SectionPartitionSelectAllResponse sectionPartitionSelectAllResponse = new SectionPartitionSelectAllResponse();
        sectionPartitionSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        sectionPartitionSelectAllResponse.setResultJson(sectionPartitionService.selectBySql(sqlstr));
        return sectionPartitionSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sectionPartition.selectSectionPartition", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(SectionPartitionSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_SectionPartition_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        SectionPartition sectionPartition=new SectionPartition();
        sectionPartition.setId(request.getId());
        sectionPartition.setSectionName(request.getSectionName());
        sectionPartition.setStatus(request.getStatus());
        sectionPartition.setModifyDate(request.getModifyDate());
        sectionPartition.setModifyed(request.getModifyed());
        sectionPartition.setOwner(request.getOwner());
        sectionPartition.setLocked(request.getLocked());
    	SectionPartitionSelectResponse sectionPartitionSelectResponse = new SectionPartitionSelectResponse();
        sectionPartitionSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<SectionPartition> sectionPartitions= sectionPartitionService.selectWithCondition(sectionPartition);
        sectionPartitionSelectResponse.setResultJson(sectionPartitions);
        return sectionPartitionSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sectionPartition.isExistSectionPartition", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistSectionPartition(SectionPartitionSelectRequest request) {
        SectionPartition sectionPartition=new SectionPartition();
        sectionPartition.setId(request.getId());
        sectionPartition.setSectionName(request.getSectionName());
        sectionPartition.setStatus(request.getStatus());
        sectionPartition.setModifyDate(request.getModifyDate());
        sectionPartition.setModifyed(request.getModifyed());
        sectionPartition.setOwner(request.getOwner());
        sectionPartition.setLocked(request.getLocked());
        ArrayList<SectionPartition> sectionPartitions= sectionPartitionService.selectWithCondition(sectionPartition);
    	SectionPartitionCountAllResponse sectionPartitionCountAllResponse = new SectionPartitionCountAllResponse();
        if (sectionPartitions.size()>0){
        	sectionPartitionCountAllResponse.setResultString("1");
        } else {
        	sectionPartitionCountAllResponse.setResultString("0");
        }        
        return sectionPartitionCountAllResponse;
    }

    public Boolean validateCreateRequest(SectionPartitionCreateRequest request){
    	SectionPartition sectionPartition=new SectionPartition();
    	sectionPartition.setId(request.getId());
        ArrayList<SectionPartition> sectionPartitions= sectionPartitionService.selectWithCondition(sectionPartition);
        if (sectionPartitions!=null&&sectionPartitions.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(SectionPartitionUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(SectionPartitionDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(SectionPartitionSelectRequest request){
        return  true;
     }    
}
