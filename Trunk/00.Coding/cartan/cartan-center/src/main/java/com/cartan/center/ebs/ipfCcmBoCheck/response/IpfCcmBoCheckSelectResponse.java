/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoCheck.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import com.cartan.core.ipfCcmBoCheck.domain.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ipfCcmBoCheckSelectResponse")
public class IpfCcmBoCheckSelectResponse {

    @XmlAttribute
    private String sessionId;
    
    private ArrayList<IpfCcmBoCheck> resultJson;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public ArrayList<IpfCcmBoCheck> getResultJson() {
        return resultJson;
    }

    public void setResultJson(ArrayList<IpfCcmBoCheck> resultJson) {
        this.resultJson = resultJson;
    }
    
}
