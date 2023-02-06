<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package ${basepackage}.ebs.${classNameLower}.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import com.cartan.core.${classNameLower}.domain.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "${classNameLower}GetResponse")
public class ${className}GetResponse {

    @XmlAttribute
    private String sessionId;
    
    private ${className} resultJson;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public ${className} getResultJson() {
        return resultJson;
    }

    public void setResultJson(${className} resultJson) {
        this.resultJson = resultJson;
    }

}