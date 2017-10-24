package ${basepackage}.common.service;

import cn.cst.kcgl.common.shiro.BusinessShiroUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author zhengsd
 */
public abstract class HandlerAdapter<T> implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(HandlerAdapter.class);

    private T oneService;

    private T twoService;

    private T getOneService() {
        logger.info("获取一级经销商的service", oneService);
        return oneService;
    }

    protected void setOneService(T oneService) {
        this.oneService = oneService;
    }

    private T getTwoService() {
        logger.info("获取二级经销商的service", twoService);
        return twoService;
    }

    protected void setTwoService(T twoService) {
        this.twoService = twoService;
    }

    /**
     * 获取一二级经销商的service
     *
     * @return T
     * @throws Exception
     */
    public T getService() throws Exception {
        String userType = BusinessShiroUtils.getPrincipal().getUser().getUserType();
        int dealerType = BusinessShiroUtils.getDealerType(userType);
        if (dealerType == 1) {
            return getOneService();
        } else if (dealerType == 2) {
            return getTwoService();
        } else {
            logger.error("当前用户类型不是一二级经销商。");
            throw new Exception("当前用户类型不是一二级经销商。");
        }
    }

}
