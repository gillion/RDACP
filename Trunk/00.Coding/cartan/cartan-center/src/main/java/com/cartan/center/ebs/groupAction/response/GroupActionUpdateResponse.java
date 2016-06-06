/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.groupAction.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import com.cartan.core.groupAction.domain.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "groupActionUpdateResponse")
public class GroupActionUpdateResponse {

    @XmlAttribute
    private String sessionId;
    
    private GroupAction resultJson;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public GroupAction getResultJson() {
        return resultJson;
    }

    public void setResultJson(GroupAction resultJson) {
        this.resultJson = resultJson;
    }

}
