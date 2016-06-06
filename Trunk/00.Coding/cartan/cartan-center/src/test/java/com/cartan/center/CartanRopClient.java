/**
 * @author 刘溪滨 (13720880048@163.com)
 * @version 1.0 @Date: 2015-11-18 上午9:10
 */
package com.cartan.center;

import com.rop.client.DefaultRopClient;
import com.rop.client.RopClient;

/**
 * @author : chenxh(quickselect@163.com)
 * @date: 13-6-25
 */
public class CartanRopClient {

    private  static String serverUrl = "http://localhost:8088/router";

    private static String appKey = "000001";

    private static String secret="SEPU!PWO@LVE&045#67$";

    private static RopClient ropClient ;

    private CartanRopClient(){}

    public static RopClient getRopClient(){
        if(ropClient == null){
            ropClient = new DefaultRopClient(serverUrl,appKey,secret);
        }
        return ropClient;
    }
}
