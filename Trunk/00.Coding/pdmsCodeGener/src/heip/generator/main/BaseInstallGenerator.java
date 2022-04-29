package heip.generator.main;

import heip.generator.generer.BaseGenerator;

import java.io.File;
import java.io.IOException;

import cn.org.rapid_framework.generator.GeneratorProperties;

@Deprecated
public class BaseInstallGenerator extends BaseAbstractCodeGenerator {
	public static void main(String[] args)throws Exception{
		clearDir(GeneratorProperties.getRequiredProperty("outRoot"));	
		BaseGenerator eg = new BaseGenerator();
		if ((null!=args)&(args.length>0)) {
			System.out.println("正在根据"+args[0].trim()+"子目录的模板生成配置文件..");
			eg.generatorBase(args[0].trim());
		} else {
			System.out.println("程序带参使用方式，例如：");
			System.out.println("根据template/Base子目录的模板生成配置文件：heip.generator.main.BaseInstallGenerator base;");
			System.out.println("根据template/bde子目录的模板生成配置文件：heip.generator.main.BaseInstallGenerator bde;");

			eg.generatorBase("base");
		}
		//open();
	}
    public static void clearDir(String sourceDirPath) throws IOException {
        File[] file = (new File(sourceDirPath)).listFiles();
     
        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
            	file[i].delete();
            }
        }
    }
	public BaseInstallGenerator(){
		
	}	
	
}

