/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center.ebs.ipfCcmBoControlEvent.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import com.cartan.core.ipfCcmBoControlEvent.domain.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ipfCcmBoControlEventUpdateResponse")
public class IpfCcmBoControlEventUpdateResponse {

    @XmlAttribute
    private String sessionId;
    
    private IpfCcmBoControlEvent resultJson;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public IpfCcmBoControlEvent getResultJson() {
        return resultJson;
    }

    public void setResultJson(IpfCcmBoControlEvent resultJson) {
        this.resultJson = resultJson;
    }

}
