package heip.generator.main;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Properties;

public class FileProperties extends Properties
{
  public FileProperties()
  {
  }

  public FileProperties(String paramString)
  {
    try
    {
      InputStreamReader localInputStream = new InputStreamReader(super.getClass().getResourceAsStream(paramString), "UTF-8"); 
      
      super.load(localInputStream);
      localInputStream.close();
    }
    catch (Exception localException)
    {
      System.err.println("Exception in FileProperties(String): " + localException.toString() + " for filename=" + paramString);
    }
  }

  public FileProperties(Properties paramProperties)
  {
    super(paramProperties);
  }
}