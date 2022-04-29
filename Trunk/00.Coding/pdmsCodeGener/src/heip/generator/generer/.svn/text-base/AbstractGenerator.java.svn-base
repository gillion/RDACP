package heip.generator.generer;

import heip.generator.generatorplus.HeipGeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorProperties;
import cn.org.rapid_framework.generator.GeneratorFacade.GeneratorContext;

public abstract class AbstractGenerator {

	protected HeipGeneratorFacade generator = new HeipGeneratorFacade();
	protected GeneratorFacade.GeneratorContext gg =new GeneratorContext();
	
	//打开
	protected static void open() throws Exception{
		Runtime.getRuntime().exec("cmd.exe /c start "
				+ GeneratorProperties.getRequiredProperty("outRoot"));
	}
	
}
