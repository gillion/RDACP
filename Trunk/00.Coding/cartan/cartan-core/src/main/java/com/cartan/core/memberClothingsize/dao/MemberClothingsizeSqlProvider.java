/**
 * Copyright：志远数字商务有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core.memberClothingsize.dao;

import com.cartan.core.memberClothingsize.domain.MemberClothingsize;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**mabatis  sql拼装类
 * @author : liuxb(13720880048@163.com)
 * @date: 13-6-26
 */
public class MemberClothingsizeSqlProvider {

    public static String getSql(Map<String, Object> parameter){

        StringBuffer conditionsStr=new StringBuffer("select * from cartan_common.t_member_clothingsize where 1=1 ");


        if(parameter.get("conditions")!=null){
            String conditions    =parameter.get("conditions").toString();
            conditionsStr.append(conditions);
        }
        MemberClothingsize memberClothingsize=new MemberClothingsize();
        memberClothingsize=(MemberClothingsize)parameter.get("memberClothingsize");

        if(StringUtils.isNotBlank(memberClothingsize.getId())){
        	conditionsStr.append(" and id = #{memberClothingsize.id} ");
        }    		
        if(StringUtils.isNotBlank(memberClothingsize.getName())){
        	conditionsStr.append(" and name like  CONCAT('%',#{memberClothingsize.name},'%')");
        }
        if(StringUtils.isNotBlank(memberClothingsize.getDepart())){
        	conditionsStr.append(" and depart like  CONCAT('%',#{memberClothingsize.depart},'%')");
        }
        if(StringUtils.isNotBlank(memberClothingsize.getHeight())){
        	conditionsStr.append(" and height like  CONCAT('%',#{memberClothingsize.height},'%')");
        }
        if(StringUtils.isNotBlank(memberClothingsize.getWeight())){
        	conditionsStr.append(" and weight like  CONCAT('%',#{memberClothingsize.weight},'%')");
        }
        if(StringUtils.isNotBlank(memberClothingsize.getClothingSize())){
        	conditionsStr.append(" and clothingSize like  CONCAT('%',#{memberClothingsize.clothingSize},'%')");
        }
        return  conditionsStr.toString();
    }
}


