<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package ${basepackage}.ebs.${classNameLower}.request;

import java.util.ArrayList;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;
import org.springframework.beans.BeanUtils;
import com.cartan.core.${classNameLower}.domain.${className};
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;

public class ${className}GetSessionRequest extends AbstractRopRequest {

    @XmlAttribute
    private String sessionId;
    
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

}