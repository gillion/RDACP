/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoFormCell;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.rop.session.SimpleSession;
import com.cartan.center.ebs.ipfCcmBoFormCell.request.*;
import com.cartan.center.ebs.ipfCcmBoFormCell.response.*;
import com.cartan.core.ipfCcmBoFormCell.domain.IpfCcmBoFormCell;
import com.cartan.core.ipfCcmBoFormCell.service.IpfCcmBoFormCellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import com.ridge.util.CodeUtils;

@ServiceMethodBean
public class IpfCcmBoFormCellServiceEbsBase {
    static Logger logger = Logger.getLogger(IpfCcmBoFormCellServiceEbs.class.getName());
	private IpfCcmBoFormCellService  ipfCcmBoFormCellService;
	
    public IpfCcmBoFormCellService getIpfCcmBoFormCellService() {
        return ipfCcmBoFormCellService;
    }

    @Autowired
    public void setIpfCcmBoFormCellService(IpfCcmBoFormCellService ipfCcmBoFormCellService) {
        this.ipfCcmBoFormCellService = ipfCcmBoFormCellService;
    }
    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormCell.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
         public Object getSession(IpfCcmBoFormCellGetSessionRequest request) {      
    	IpfCcmBoFormCellGetSessionResponse ipfCcmBoFormCellGetSessionResponse = new IpfCcmBoFormCellGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoFormCellGetSessionResponse.setResultString("0");
        } else {
        	ipfCcmBoFormCellGetSessionResponse.setResultString("1");
            ipfCcmBoFormCellGetSessionResponse.setSessionId(request.getSessionId());
        }
        return ipfCcmBoFormCellGetSessionResponse;
    }
    


    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormCell.addSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object addSession(IpfCcmBoFormCellGetSessionRequest request) {
    	IpfCcmBoFormCellGetSessionResponse ipfCcmBoFormCellGetSessionResponse = new IpfCcmBoFormCellGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
            SimpleSession session = new SimpleSession();
            request.getRopRequestContext().getRopContext().getSessionManager().addSession(request.getSessionId(), session);
            ipfCcmBoFormCellGetSessionResponse.setResultString("1");
        } else {
        	ipfCcmBoFormCellGetSessionResponse.setResultString("0");
        }
        ipfCcmBoFormCellGetSessionResponse.setSessionId(request.getSessionId());
        return ipfCcmBoFormCellGetSessionResponse;
    }

    /**
     * 返回报文id
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormCell.removeSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object removeSession(IpfCcmBoFormCellGetSessionRequest request) {
    	IpfCcmBoFormCellGetSessionResponse ipfCcmBoFormCellGetSessionResponse = new IpfCcmBoFormCellGetSessionResponse();
        if (request.getRopRequestContext().getRopContext().getSessionManager().getSession(request.getSessionId())==null){
        	ipfCcmBoFormCellGetSessionResponse.setResultString("0");
        	ipfCcmBoFormCellGetSessionResponse.setSessionId(request.getSessionId());
        } else {
            request.getRopRequestContext().getRopContext().getSessionManager().removeSession(request.getSessionId());
            ipfCcmBoFormCellGetSessionResponse.setResultString("1");
        }
        return ipfCcmBoFormCellGetSessionResponse;
    }
    /**
     * 新增记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormCell.createIpfCcmBoFormCell", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object createIpfCcmBoFormCell(IpfCcmBoFormCellCreateRequest request) {
        if (request.getId().equals("")){
            request.setId(CodeUtils.uuid());
        }
    	if(!validateCreateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "CREATE_IpfCcmBoFormCell_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoFormCell ipfCcmBoFormCell=new IpfCcmBoFormCell();
        ipfCcmBoFormCell.setId(request.getId());    		
        ipfCcmBoFormCell.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmBoFormCell.setFormType(request.getFormType());
        ipfCcmBoFormCell.setIsDefault(request.getIsDefault());
        ipfCcmBoFormCell.setCellName(request.getCellName());
        ipfCcmBoFormCell.setCellType(request.getCellType());
        ipfCcmBoFormCell.setCellHeigh(request.getCellHeigh());
        ipfCcmBoFormCell.setIsShowGroup(request.getIsShowGroup());
        ipfCcmBoFormCell.setGroupWidget(request.getGroupWidget());
        ipfCcmBoFormCell.setElementCode(request.getElementCode());
        ipfCcmBoFormCell.setGroupTitle(request.getGroupTitle());
        ipfCcmBoFormCell.setUnitCount(request.getUnitCount());
        ipfCcmBoFormCell.setIsParent(request.getIsParent());
        ipfCcmBoFormCell.setChildrenLineCount(request.getChildrenLineCount());
        ipfCcmBoFormCell.setParentCellName(request.getParentCellName());
        ipfCcmBoFormCell.setRowNo(request.getRowNo());
        ipfCcmBoFormCell.setColumnNo(request.getColumnNo());
        ipfCcmBoFormCell.setLabelUnitCount(request.getLabelUnitCount());
    	ipfCcmBoFormCellService.createIpfCcmBoFormCell(ipfCcmBoFormCell);
        //返回响应
        IpfCcmBoFormCellCreateResponse ipfCcmBoFormCellCreateResponse = new IpfCcmBoFormCellCreateResponse();
        ipfCcmBoFormCellCreateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoFormCellCreateResponse.setResultJson(ipfCcmBoFormCell);
        return ipfCcmBoFormCellCreateResponse;
        }
    }
    /**
     * 删除记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormCell.deleteIpfCcmBoFormCell", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object deleteIpfCcmBoFormCell(IpfCcmBoFormCellDeleteRequest request) {
    	if(!validateDeleteRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "DELETE_IpfCcmBoFormCell_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        String idstr=request.getRopRequestContext().getParamValue("id");
        ipfCcmBoFormCellService.deleteIpfCcmBoFormCell(idstr);
        //返回响应
        IpfCcmBoFormCellDeleteResponse ipfCcmBoFormCellDeleteResponse = new IpfCcmBoFormCellDeleteResponse();
        ipfCcmBoFormCellDeleteResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoFormCellDeleteResponse;
        }
    }
    /**
     * 变更记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormCell.updateIpfCcmBoFormCell", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object updateIpfCcmBoFormCell(IpfCcmBoFormCellUpdateRequest request) {
    	if(!validateUpdateRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "UPDATE_IpfCcmBoFormCell_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoFormCell ipfCcmBoFormCell=new IpfCcmBoFormCell();
        ipfCcmBoFormCell=ipfCcmBoFormCellService.getIpfCcmBoFormCell(request.getId());
        if (request.getId()!=null){
	        ipfCcmBoFormCell.setId(request.getId());
        }
        if (request.getIpfCcmBoId()!=null){
	        ipfCcmBoFormCell.setIpfCcmBoId(request.getIpfCcmBoId());
        }
        if (request.getFormType()!=null){
	        ipfCcmBoFormCell.setFormType(request.getFormType());
        }
        if (request.getIsDefault()!=null){
	        ipfCcmBoFormCell.setIsDefault(request.getIsDefault());
        }
        if (request.getCellName()!=null){
	        ipfCcmBoFormCell.setCellName(request.getCellName());
        }
        if (request.getCellType()!=null){
	        ipfCcmBoFormCell.setCellType(request.getCellType());
        }
        if (request.getCellHeigh()!=null){
	        ipfCcmBoFormCell.setCellHeigh(request.getCellHeigh());
        }
        if (request.getIsShowGroup()!=null){
	        ipfCcmBoFormCell.setIsShowGroup(request.getIsShowGroup());
        }
        if (request.getGroupWidget()!=null){
	        ipfCcmBoFormCell.setGroupWidget(request.getGroupWidget());
        }
        if (request.getElementCode()!=null){
	        ipfCcmBoFormCell.setElementCode(request.getElementCode());
        }
        if (request.getGroupTitle()!=null){
	        ipfCcmBoFormCell.setGroupTitle(request.getGroupTitle());
        }
        if (request.getUnitCount()!=null){
	        ipfCcmBoFormCell.setUnitCount(request.getUnitCount());
        }
        if (request.getIsParent()!=null){
	        ipfCcmBoFormCell.setIsParent(request.getIsParent());
        }
        if (request.getChildrenLineCount()!=null){
	        ipfCcmBoFormCell.setChildrenLineCount(request.getChildrenLineCount());
        }
        if (request.getParentCellName()!=null){
	        ipfCcmBoFormCell.setParentCellName(request.getParentCellName());
        }
        if (request.getRowNo()!=null){
	        ipfCcmBoFormCell.setRowNo(request.getRowNo());
        }
        if (request.getColumnNo()!=null){
	        ipfCcmBoFormCell.setColumnNo(request.getColumnNo());
        }
        if (request.getLabelUnitCount()!=null){
	        ipfCcmBoFormCell.setLabelUnitCount(request.getLabelUnitCount());
        }
    	ipfCcmBoFormCellService.updateIpfCcmBoFormCell(ipfCcmBoFormCell);
        //返回响应
        IpfCcmBoFormCellUpdateResponse ipfCcmBoFormCellUpdateResponse = new IpfCcmBoFormCellUpdateResponse();
        ipfCcmBoFormCellUpdateResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoFormCellUpdateResponse.setResultJson(ipfCcmBoFormCell);
        return ipfCcmBoFormCellUpdateResponse;
        }
    }
    /**
     * 获取记录
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormCell.getIpfCcmBoFormCell", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getIpfCcmBoFormCell(IpfCcmBoFormCellGetRequest request) {  	
        String id=request.getRopRequestContext().getParamValue("id");
        IpfCcmBoFormCell ipfCcmBoFormCell=new IpfCcmBoFormCell();
        ipfCcmBoFormCell=ipfCcmBoFormCellService.getIpfCcmBoFormCell(id);
        //返回响应
        IpfCcmBoFormCellGetResponse ipfCcmBoFormCellGetResponse = new IpfCcmBoFormCellGetResponse();
        ipfCcmBoFormCellGetResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoFormCellGetResponse.setResultJson(ipfCcmBoFormCell);
        return ipfCcmBoFormCellGetResponse;
    }
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormCell.selectAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectAll(IpfCcmBoFormCellSelectAllRequest request) {
        IpfCcmBoFormCellSelectAllResponse ipfCcmBoFormCellSelectAllResponse = new IpfCcmBoFormCellSelectAllResponse();
        ipfCcmBoFormCellSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoFormCellSelectAllResponse.setResultJson(ipfCcmBoFormCellService.selectAll());
        return ipfCcmBoFormCellSelectAllResponse;
    }
    /**
     * 获取记录数
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormCell.countAll", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object countAll(IpfCcmBoFormCellCountAllRequest request) {
        IpfCcmBoFormCellCountAllResponse ipfCcmBoFormCellCountAllResponse = new IpfCcmBoFormCellCountAllResponse();
        ipfCcmBoFormCellCountAllResponse.setResultString(String.valueOf(ipfCcmBoFormCellService.countAll()));
        ipfCcmBoFormCellCountAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        return ipfCcmBoFormCellCountAllResponse;
    }
    
    /**
     * 获取列表
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormCell.selectBySql", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectBySql(IpfCcmBoFormCellSelectRequest request) {
        String sqlstr=request.getRopRequestContext().getParamValue("sqlstr");
        IpfCcmBoFormCellSelectAllResponse ipfCcmBoFormCellSelectAllResponse = new IpfCcmBoFormCellSelectAllResponse();
        ipfCcmBoFormCellSelectAllResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ipfCcmBoFormCellSelectAllResponse.setResultJson(ipfCcmBoFormCellService.selectBySql(sqlstr));
        return ipfCcmBoFormCellSelectAllResponse;
    }
    
    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormCell.selectIpfCcmBoFormCell", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object selectwithCondition(IpfCcmBoFormCellSelectRequest request) {
    	if(!validateSelectRequest(request)){
            return new BusinessServiceErrorResponse(
                    request.getRopRequestContext().getMethod(), "SELECT_IpfCcmBoFormCell_RESERVED",
                    request.getRopRequestContext().getLocale(), request.getId());
        } else{
        IpfCcmBoFormCell ipfCcmBoFormCell=new IpfCcmBoFormCell();
        ipfCcmBoFormCell.setId(request.getId());
        ipfCcmBoFormCell.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmBoFormCell.setFormType(request.getFormType());
        ipfCcmBoFormCell.setIsDefault(request.getIsDefault());
        ipfCcmBoFormCell.setCellName(request.getCellName());
        ipfCcmBoFormCell.setCellType(request.getCellType());
        ipfCcmBoFormCell.setCellHeigh(request.getCellHeigh());
        ipfCcmBoFormCell.setIsShowGroup(request.getIsShowGroup());
        ipfCcmBoFormCell.setGroupWidget(request.getGroupWidget());
        ipfCcmBoFormCell.setElementCode(request.getElementCode());
        ipfCcmBoFormCell.setGroupTitle(request.getGroupTitle());
        ipfCcmBoFormCell.setUnitCount(request.getUnitCount());
        ipfCcmBoFormCell.setIsParent(request.getIsParent());
        ipfCcmBoFormCell.setChildrenLineCount(request.getChildrenLineCount());
        ipfCcmBoFormCell.setParentCellName(request.getParentCellName());
        ipfCcmBoFormCell.setRowNo(request.getRowNo());
        ipfCcmBoFormCell.setColumnNo(request.getColumnNo());
        ipfCcmBoFormCell.setLabelUnitCount(request.getLabelUnitCount());
    	IpfCcmBoFormCellSelectResponse ipfCcmBoFormCellSelectResponse = new IpfCcmBoFormCellSelectResponse();
        ipfCcmBoFormCellSelectResponse.setSessionId(request.getRopRequestContext().getSessionId());
        ArrayList<IpfCcmBoFormCell> ipfCcmBoFormCells= ipfCcmBoFormCellService.selectWithCondition(ipfCcmBoFormCell);
        ipfCcmBoFormCellSelectResponse.setResultJson(ipfCcmBoFormCells);
        return ipfCcmBoFormCellSelectResponse;
        }
    }

    /**
     * 获取对象
     * @param request 输入请求
     * @return Response 输出报文
     */
    @ServiceMethod(method = "ipfCcmBoFormCell.isExistIpfCcmBoFormCell", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object isExistIpfCcmBoFormCell(IpfCcmBoFormCellSelectRequest request) {
        IpfCcmBoFormCell ipfCcmBoFormCell=new IpfCcmBoFormCell();
        ipfCcmBoFormCell.setId(request.getId());
        ipfCcmBoFormCell.setIpfCcmBoId(request.getIpfCcmBoId());
        ipfCcmBoFormCell.setFormType(request.getFormType());
        ipfCcmBoFormCell.setIsDefault(request.getIsDefault());
        ipfCcmBoFormCell.setCellName(request.getCellName());
        ipfCcmBoFormCell.setCellType(request.getCellType());
        ipfCcmBoFormCell.setCellHeigh(request.getCellHeigh());
        ipfCcmBoFormCell.setIsShowGroup(request.getIsShowGroup());
        ipfCcmBoFormCell.setGroupWidget(request.getGroupWidget());
        ipfCcmBoFormCell.setElementCode(request.getElementCode());
        ipfCcmBoFormCell.setGroupTitle(request.getGroupTitle());
        ipfCcmBoFormCell.setUnitCount(request.getUnitCount());
        ipfCcmBoFormCell.setIsParent(request.getIsParent());
        ipfCcmBoFormCell.setChildrenLineCount(request.getChildrenLineCount());
        ipfCcmBoFormCell.setParentCellName(request.getParentCellName());
        ipfCcmBoFormCell.setRowNo(request.getRowNo());
        ipfCcmBoFormCell.setColumnNo(request.getColumnNo());
        ipfCcmBoFormCell.setLabelUnitCount(request.getLabelUnitCount());
        ArrayList<IpfCcmBoFormCell> ipfCcmBoFormCells= ipfCcmBoFormCellService.selectWithCondition(ipfCcmBoFormCell);
    	IpfCcmBoFormCellCountAllResponse ipfCcmBoFormCellCountAllResponse = new IpfCcmBoFormCellCountAllResponse();
        if (ipfCcmBoFormCells.size()>0){
        	ipfCcmBoFormCellCountAllResponse.setResultString("1");
        } else {
        	ipfCcmBoFormCellCountAllResponse.setResultString("0");
        }        
        return ipfCcmBoFormCellCountAllResponse;
    }

    public Boolean validateCreateRequest(IpfCcmBoFormCellCreateRequest request){
    	IpfCcmBoFormCell ipfCcmBoFormCell=new IpfCcmBoFormCell();
    	ipfCcmBoFormCell.setId(request.getId());
        ArrayList<IpfCcmBoFormCell> ipfCcmBoFormCells= ipfCcmBoFormCellService.selectWithCondition(ipfCcmBoFormCell);
        if (ipfCcmBoFormCells!=null&&ipfCcmBoFormCells.size()>0)   {
        	request.setId("主键"+request.getId()+"已存在,"); 
        	return false;             
        }else
            return  true;
     }
    public Boolean validateUpdateRequest(IpfCcmBoFormCellUpdateRequest request){
        return  true;
     }
    public Boolean validateDeleteRequest(IpfCcmBoFormCellDeleteRequest request){
        return  true;
     }    
    public Boolean validateSelectRequest(IpfCcmBoFormCellSelectRequest request){
        return  true;
     }    
}
