/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.groupMember.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import com.cartan.core.groupMember.domain.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "groupMemberGetResponse")
public class GroupMemberGetResponse {

    @XmlAttribute
    private String sessionId;
    
    private GroupMember resultJson;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public GroupMember getResultJson() {
        return resultJson;
    }

    public void setResultJson(GroupMember resultJson) {
        this.resultJson = resultJson;
    }

}
