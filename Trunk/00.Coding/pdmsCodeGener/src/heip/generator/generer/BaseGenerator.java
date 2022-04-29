package heip.generator.generer;

import java.util.HashMap;
import java.util.Map;
/**
 * 实体生成
 * @author HSWHM
 *
 *
 */
public class BaseGenerator extends AbstractGenerator{
	public void execute() throws Exception{
		
	}	
	
	public static void main(String[] args) throws Exception{
		BaseGenerator eg = new BaseGenerator();
		eg.execute();
		open();
	}
	public BaseGenerator(){
		
	}
	public BaseGenerator(String moduleName){
		
	}	

	public void generatorBase(String moduleName) throws Exception{
		Map<String,String> tt = new HashMap<String,String>();
		tt.put("id","id");
		generator.generateByMap(tt, "template/"+moduleName.trim());
		//generator.generateByTable("","template/"+moduleName.trim());
	}
	
}
