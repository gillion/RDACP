/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.center.ebs.sysUser.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import com.cartan.core.sysUser.domain.*;

/**
 * @author : liuxb(13720880048@163.com)
 * @date: 2013-09-05
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "sysUserCountAllResponse")
public class SysUserCountAllResponse {

    @XmlAttribute
    private String sessionId;
    
    @XmlAttribute
    private String resultString;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getResultString() {
        return resultString;
    }

    public void setResultString(String resultString) {
        this.resultString = resultString;
    }

}
