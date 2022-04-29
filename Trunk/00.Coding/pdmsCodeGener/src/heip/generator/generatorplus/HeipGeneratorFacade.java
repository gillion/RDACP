package heip.generator.generatorplus;

import java.io.File;

import cn.org.rapid_framework.generator.Generator;
import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorFacade.ProcessUtils;

public class HeipGeneratorFacade extends GeneratorFacade {
	
	 @Override
	 public void generateByTable(String tableName,String templateRootDir) throws Exception {
	    	new ProcessUtils().processByTable(tableName,templateRootDir,false);
	 }
	 
	 /*@Override
	 private Generator getGenerator(String templateRootDir) {
	    g.setTemplateRootDir(new File(templateRootDir).getAbsoluteFile());
	    return g;
	}*/
	 
}
