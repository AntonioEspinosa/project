package initialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFiles implements DefaultAppConfig{

    private static Properties propFile = null;

    public static Properties getPropertiesFromFile(String configProperties) {


        if (propFile==null) {
            try (InputStream configPropertiesFileReader
                         = ReadConfigFiles.class.getClassLoader().getResourceAsStream(configProperties)) {
                Properties pro = new Properties();
                pro.load(configPropertiesFileReader);
                return pro;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        else return propFile;
    }

    public static Properties getPropFileFromDefaultConfigFile(){
        return getPropertiesFromFile(DEFAULT_APP_CONFIG_FILE);
    }

    private ReadConfigFiles(){

    }

}
