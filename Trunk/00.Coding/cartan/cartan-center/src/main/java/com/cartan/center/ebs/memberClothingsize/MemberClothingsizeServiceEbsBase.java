/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.memberClothingsize;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.memberClothingsize.request.*;
import com.cartan.center.ebs.memberClothingsize.response.*;
import com.cartan.core.memberClothingsize.domain.MemberClothingsize;
import com.cartan.core.memberClothingsize.service.MemberClothingsizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class MemberClothingsizeServiceEbsBase {
    static Logger logger = Logger.getLogger(MemberClothingsizeServiceEbs.class.getName());
	private MemberClothingsizeService  memberClothingsizeService;
	
    public MemberClothingsizeService getMemberClothingsizeService() {
        return memberClothingsizeService;
    }

    @Autowired
    public void setMemberClothingsizeService(MemberClothingsizeService memberClothingsizeService) {
        this.memberClothingsizeService = memberClothingsizeService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberClothingsize.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(MemberClothingsizeGetSessionRequest request) {      
    	MemberClothingsizeGetSessionResponse memberClothingsizeGetSessionResponse = new MemberClothingsizeGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	memberClothingsizeGetSessionResponse.setResultString("0");
        } else {
        	memberClothingsizeGetSessionResponse.setResultString("1");
            memberClothingsizeGetSessionResponse.setSessionId(request.getSessionId());
        }
        return memberClothingsizeGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberClothingsize.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(MemberClothingsizeGetSessionRequest request) {
    	MemberClothingsizeGetSessionResponse memberClothingsizeGetSessionResponse = new MemberClothingsizeGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            memberClothingsizeGetSessionResponse.setResultString("1");
        } else {
        	memberClothingsizeGetSessionResponse.setResultString("0");
        }
        memberClothingsizeGetSessionResponse.setSessionId(request.getSessionId());
        return memberClothingsizeGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberClothingsize.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(MemberClothingsizeGetSessionRequest request) {
    	MemberClothingsizeGetSessionResponse memberClothingsizeGetSessionResponse = new MemberClothingsizeGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	memberClothingsizeGetSessionResponse.setResultString("0");
        	memberClothingsizeGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            memberClothingsizeGetSessionResponse.setResultString("1");
        }
        return memberClothingsizeGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberClothingsize.createMemberClothingsize", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createMemberClothingsize(MemberClothingsizeCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_MemberClothingsize_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        MemberClothingsize memberClothingsize=new MemberClothingsize();
        memberClothingsize.setId(request.getId());    		
        memberClothingsize.setName(request.getName());
        memberClothingsize.setDepart(request.getDepart());
        memberClothingsize.setHeight(request.getHeight());
        memberClothingsize.setWeight(request.getWeight());
        memberClothingsize.setClothingSize(request.getClothingSize());
    	memberClothingsizeService.createMemberClothingsize(memberClothingsize);
        //返回响应
        MemberClothingsizeCreateResponse memberClothingsizeCreateResponse = new MemberClothingsizeCreateResponse();
        memberClothingsizeCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        memberClothingsizeCreateResponse.setResultJson(memberClothingsize);
        return memberClothingsizeCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberClothingsize.deleteMemberClothingsize", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteMemberClothingsize(MemberClothingsizeDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_MemberClothingsize_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        memberClothingsizeService.deleteMemberClothingsize(idstr);
        //返回响应
        MemberClothingsizeDeleteResponse memberClothingsizeDeleteResponse = new MemberClothingsizeDeleteResponse();
        memberClothingsizeDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return memberClothingsizeDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberClothingsize.updateMemberClothingsize", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateMemberClothingsize(MemberClothingsizeUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_MemberClothingsize_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        MemberClothingsize memberClothingsize=new MemberClothingsize();
        memberClothingsize=memberClothingsizeService.getMemberClothingsize(request.getId());
        if (request.getId()!=null){
	        memberClothingsize.setId(request.getId());
        }
        if (request.getName()!=null){
	        memberClothingsize.setName(request.getName());
        }
        if (request.getDepart()!=null){
	        memberClothingsize.setDepart(request.getDepart());
        }
        if (request.getHeight()!=null){
	        memberClothingsize.setHeight(request.getHeight());
        }
        if (request.getWeight()!=null){
	        memberClothingsize.setWeight(request.getWeight());
        }
        if (request.getClothingSize()!=null){
	        memberClothingsize.setClothingSize(request.getClothingSize());
        }
    	memberClothingsizeService.updateMemberClothingsize(memberClothingsize);
        //返回响应
        MemberClothingsizeUpdateResponse memberClothingsizeUpdateResponse = new MemberClothingsizeUpdateResponse();
        memberClothingsizeUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        memberClothingsizeUpdateResponse.setResultJson(memberClothingsize);
        return memberClothingsizeUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberClothingsize.getMemberClothingsize", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getMemberClothingsize(MemberClothingsizeGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        MemberClothingsize memberClothingsize=new MemberClothingsize();
        memberClothingsize=memberClothingsizeService.getMemberClothingsize(id);
        //返回响应
        MemberClothingsizeGetResponse memberClothingsizeGetResponse = new MemberClothingsizeGetResponse();
        memberClothingsizeGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        memberClothingsizeGetResponse.setResultJson(memberClothingsize);
        return memberClothingsizeGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberClothingsize.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(MemberClothingsizeSelectAllRequest request) {
        MemberClothingsizeSelectAllResponse memberClothingsizeSelectAllResponse = new MemberClothingsizeSelectAllResponse();
        memberClothingsizeSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        memberClothingsizeSelectAllResponse.setResultJson(memberClothingsizeService.selectAll());
        return memberClothingsizeSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberClothingsize.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(MemberClothingsizeCountAllRequest request) {
        MemberClothingsizeCountAllResponse memberClothingsizeCountAllResponse = new MemberClothingsizeCountAllResponse();
        memberClothingsizeCountAllResponse.setResultString(String.valueOf(memberClothingsizeService.countAll()));
        memberClothingsizeCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return memberClothingsizeCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberClothingsize.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(MemberClothingsizeSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        MemberClothingsizeSelectAllResponse memberClothingsizeSelectAllResponse = new MemberClothingsizeSelectAllResponse();
        memberClothingsizeSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        memberClothingsizeSelectAllResponse.setResultJson(memberClothingsizeService.selectBySql(sqlstr));
        return memberClothingsizeSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberClothingsize.selectMemberClothingsize", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(MemberClothingsizeSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_MemberClothingsize_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        MemberClothingsize memberClothingsize=new MemberClothingsize();
        memberClothingsize.setId(request.getId());
        memberClothingsize.setName(request.getName());
        memberClothingsize.setDepart(request.getDepart());
        memberClothingsize.setHeight(request.getHeight());
        memberClothingsize.setWeight(request.getWeight());
        memberClothingsize.setClothingSize(request.getClothingSize());
    	MemberClothingsizeSelectResponse memberClothingsizeSelectResponse = new MemberClothingsizeSelectResponse();
        memberClothingsizeSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<MemberClothingsize> memberClothingsizes= memberClothingsizeService.selectWithCondition(memberClothingsize);
        memberClothingsizeSelectResponse.setResultJson(memberClothingsizes);
        return memberClothingsizeSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "memberClothingsize.isExistMemberClothingsize", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistMemberClothingsize(MemberClothingsizeSelectRequest request) {
        MemberClothingsize memberClothingsize=new MemberClothingsize();
        memberClothingsize.setId(request.getId());
        memberClothingsize.setName(request.getName());
        memberClothingsize.setDepart(request.getDepart());
        memberClothingsize.setHeight(request.getHeight());
        memberClothingsize.setWeight(request.getWeight());
        memberClothingsize.setClothingSize(request.getClothingSize());
        ArrayList<MemberClothingsize> memberClothingsizes= memberClothingsizeService.selectWithCondition(memberClothingsize);
    	MemberClothingsizeCountAllResponse memberClothingsizeCountAllResponse = new MemberClothingsizeCountAllResponse();
        if (memberClothingsizes.size()>0){
        	memberClothingsizeCountAllResponse.setResultString("1");
        } else {
        	memberClothingsizeCountAllResponse.setResultString("0");
        }        
        return memberClothingsizeCountAllResponse;
    }

    public Boolean validateCreateRequest(MemberClothingsizeCreateRequest request){
    	MemberClothingsize memberClothingsize=new MemberClothingsize();
    	memberClothingsize.setId(request.getId());
        ArrayList<MemberClothingsize> memberClothingsizes= memberClothingsizeService.selectWithCondition(memberClothingsize);
        if (memberClothingsizes!=null&&memberClothingsizes.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(MemberClothingsizeUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(MemberClothingsizeDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(MemberClothingsizeSelectRequest request){
        return  true;
     }    
}
