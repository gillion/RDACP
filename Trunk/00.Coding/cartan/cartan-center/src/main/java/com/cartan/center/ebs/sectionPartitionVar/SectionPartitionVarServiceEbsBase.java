/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.sectionPartitionVar;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.sectionPartitionVar.request.*;
import com.cartan.center.ebs.sectionPartitionVar.response.*;
import com.cartan.core.sectionPartitionVar.domain.SectionPartitionVar;
import com.cartan.core.sectionPartitionVar.service.SectionPartitionVarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class SectionPartitionVarServiceEbsBase {
    static Logger logger = Logger.getLogger(SectionPartitionVarServiceEbs.class.getName());
	private SectionPartitionVarService  sectionPartitionVarService;
	
    public SectionPartitionVarService getSectionPartitionVarService() {
        return sectionPartitionVarService;
    }

    @Autowired
    public void setSectionPartitionVarService(SectionPartitionVarService sectionPartitionVarService) {
        this.sectionPartitionVarService = sectionPartitionVarService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sectionPartitionVar.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(SectionPartitionVarGetSessionRequest request) {      
    	SectionPartitionVarGetSessionResponse sectionPartitionVarGetSessionResponse = new SectionPartitionVarGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	sectionPartitionVarGetSessionResponse.setResultString("0");
        } else {
        	sectionPartitionVarGetSessionResponse.setResultString("1");
            sectionPartitionVarGetSessionResponse.setSessionId(request.getSessionId());
        }
        return sectionPartitionVarGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sectionPartitionVar.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(SectionPartitionVarGetSessionRequest request) {
    	SectionPartitionVarGetSessionResponse sectionPartitionVarGetSessionResponse = new SectionPartitionVarGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            sectionPartitionVarGetSessionResponse.setResultString("1");
        } else {
        	sectionPartitionVarGetSessionResponse.setResultString("0");
        }
        sectionPartitionVarGetSessionResponse.setSessionId(request.getSessionId());
        return sectionPartitionVarGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sectionPartitionVar.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(SectionPartitionVarGetSessionRequest request) {
    	SectionPartitionVarGetSessionResponse sectionPartitionVarGetSessionResponse = new SectionPartitionVarGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	sectionPartitionVarGetSessionResponse.setResultString("0");
        	sectionPartitionVarGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            sectionPartitionVarGetSessionResponse.setResultString("1");
        }
        return sectionPartitionVarGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sectionPartitionVar.createSectionPartitionVar", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createSectionPartitionVar(SectionPartitionVarCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_SectionPartitionVar_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        SectionPartitionVar sectionPartitionVar=new SectionPartitionVar();
        sectionPartitionVar.setId(request.getId());    		
        sectionPartitionVar.setSectionParitionId(request.getSectionParitionId());
        sectionPartitionVar.setVarName(request.getVarName());
        sectionPartitionVar.setSectionLowerMark(request.getSectionLowerMark());
        sectionPartitionVar.setSectionLowerLimit(request.getSectionLowerLimit());
        sectionPartitionVar.setSectionUpperMark(request.getSectionUpperMark());
        sectionPartitionVar.setSectionUpperLimit(request.getSectionUpperLimit());
    	sectionPartitionVarService.createSectionPartitionVar(sectionPartitionVar);
        //返回响应
        SectionPartitionVarCreateResponse sectionPartitionVarCreateResponse = new SectionPartitionVarCreateResponse();
        sectionPartitionVarCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        sectionPartitionVarCreateResponse.setResultJson(sectionPartitionVar);
        return sectionPartitionVarCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sectionPartitionVar.deleteSectionPartitionVar", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteSectionPartitionVar(SectionPartitionVarDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_SectionPartitionVar_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        sectionPartitionVarService.deleteSectionPartitionVar(idstr);
        //返回响应
        SectionPartitionVarDeleteResponse sectionPartitionVarDeleteResponse = new SectionPartitionVarDeleteResponse();
        sectionPartitionVarDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return sectionPartitionVarDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sectionPartitionVar.updateSectionPartitionVar", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateSectionPartitionVar(SectionPartitionVarUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_SectionPartitionVar_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        SectionPartitionVar sectionPartitionVar=new SectionPartitionVar();
        sectionPartitionVar=sectionPartitionVarService.getSectionPartitionVar(request.getId());
        if (request.getId()!=null){
	        sectionPartitionVar.setId(request.getId());
        }
        if (request.getSectionParitionId()!=null){
	        sectionPartitionVar.setSectionParitionId(request.getSectionParitionId());
        }
        if (request.getVarName()!=null){
	        sectionPartitionVar.setVarName(request.getVarName());
        }
        if (request.getSectionLowerMark()!=null){
	        sectionPartitionVar.setSectionLowerMark(request.getSectionLowerMark());
        }
        if (request.getSectionLowerLimit()!=null){
	        sectionPartitionVar.setSectionLowerLimit(request.getSectionLowerLimit());
        }
        if (request.getSectionUpperMark()!=null){
	        sectionPartitionVar.setSectionUpperMark(request.getSectionUpperMark());
        }
        if (request.getSectionUpperLimit()!=null){
	        sectionPartitionVar.setSectionUpperLimit(request.getSectionUpperLimit());
        }
    	sectionPartitionVarService.updateSectionPartitionVar(sectionPartitionVar);
        //返回响应
        SectionPartitionVarUpdateResponse sectionPartitionVarUpdateResponse = new SectionPartitionVarUpdateResponse();
        sectionPartitionVarUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        sectionPartitionVarUpdateResponse.setResultJson(sectionPartitionVar);
        return sectionPartitionVarUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sectionPartitionVar.getSectionPartitionVar", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getSectionPartitionVar(SectionPartitionVarGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        SectionPartitionVar sectionPartitionVar=new SectionPartitionVar();
        sectionPartitionVar=sectionPartitionVarService.getSectionPartitionVar(id);
        //返回响应
        SectionPartitionVarGetResponse sectionPartitionVarGetResponse = new SectionPartitionVarGetResponse();
        sectionPartitionVarGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        sectionPartitionVarGetResponse.setResultJson(sectionPartitionVar);
        return sectionPartitionVarGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sectionPartitionVar.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(SectionPartitionVarSelectAllRequest request) {
        SectionPartitionVarSelectAllResponse sectionPartitionVarSelectAllResponse = new SectionPartitionVarSelectAllResponse();
        sectionPartitionVarSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        sectionPartitionVarSelectAllResponse.setResultJson(sectionPartitionVarService.selectAll());
        return sectionPartitionVarSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sectionPartitionVar.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(SectionPartitionVarCountAllRequest request) {
        SectionPartitionVarCountAllResponse sectionPartitionVarCountAllResponse = new SectionPartitionVarCountAllResponse();
        sectionPartitionVarCountAllResponse.setResultString(String.valueOf(sectionPartitionVarService.countAll()));
        sectionPartitionVarCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return sectionPartitionVarCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sectionPartitionVar.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(SectionPartitionVarSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        SectionPartitionVarSelectAllResponse sectionPartitionVarSelectAllResponse = new SectionPartitionVarSelectAllResponse();
        sectionPartitionVarSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        sectionPartitionVarSelectAllResponse.setResultJson(sectionPartitionVarService.selectBySql(sqlstr));
        return sectionPartitionVarSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sectionPartitionVar.selectSectionPartitionVar", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(SectionPartitionVarSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_SectionPartitionVar_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        SectionPartitionVar sectionPartitionVar=new SectionPartitionVar();
        sectionPartitionVar.setId(request.getId());
        sectionPartitionVar.setSectionParitionId(request.getSectionParitionId());
        sectionPartitionVar.setVarName(request.getVarName());
        sectionPartitionVar.setSectionLowerMark(request.getSectionLowerMark());
        sectionPartitionVar.setSectionLowerLimit(request.getSectionLowerLimit());
        sectionPartitionVar.setSectionUpperMark(request.getSectionUpperMark());
        sectionPartitionVar.setSectionUpperLimit(request.getSectionUpperLimit());
    	SectionPartitionVarSelectResponse sectionPartitionVarSelectResponse = new SectionPartitionVarSelectResponse();
        sectionPartitionVarSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<SectionPartitionVar> sectionPartitionVars= sectionPartitionVarService.selectWithCondition(sectionPartitionVar);
        sectionPartitionVarSelectResponse.setResultJson(sectionPartitionVars);
        return sectionPartitionVarSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "sectionPartitionVar.isExistSectionPartitionVar", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistSectionPartitionVar(SectionPartitionVarSelectRequest request) {
        SectionPartitionVar sectionPartitionVar=new SectionPartitionVar();
        sectionPartitionVar.setId(request.getId());
        sectionPartitionVar.setSectionParitionId(request.getSectionParitionId());
        sectionPartitionVar.setVarName(request.getVarName());
        sectionPartitionVar.setSectionLowerMark(request.getSectionLowerMark());
        sectionPartitionVar.setSectionLowerLimit(request.getSectionLowerLimit());
        sectionPartitionVar.setSectionUpperMark(request.getSectionUpperMark());
        sectionPartitionVar.setSectionUpperLimit(request.getSectionUpperLimit());
        ArrayList<SectionPartitionVar> sectionPartitionVars= sectionPartitionVarService.selectWithCondition(sectionPartitionVar);
    	SectionPartitionVarCountAllResponse sectionPartitionVarCountAllResponse = new SectionPartitionVarCountAllResponse();
        if (sectionPartitionVars.size()>0){
        	sectionPartitionVarCountAllResponse.setResultString("1");
        } else {
        	sectionPartitionVarCountAllResponse.setResultString("0");
        }        
        return sectionPartitionVarCountAllResponse;
    }

    public Boolean validateCreateRequest(SectionPartitionVarCreateRequest request){
    	SectionPartitionVar sectionPartitionVar=new SectionPartitionVar();
    	sectionPartitionVar.setId(request.getId());
        ArrayList<SectionPartitionVar> sectionPartitionVars= sectionPartitionVarService.selectWithCondition(sectionPartitionVar);
        if (sectionPartitionVars!=null&&sectionPartitionVars.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(SectionPartitionVarUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(SectionPartitionVarDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(SectionPartitionVarSelectRequest request){
        return  true;
     }    
}
