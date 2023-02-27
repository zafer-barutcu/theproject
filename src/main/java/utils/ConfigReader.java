package utils;

import org.bouncycastle.asn1.cmc.IdentityProofV2;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;


    static {

        try{
            String path = "src/main/resources/dev.properties";
            FileInputStream input=new FileInputStream(path);
            properties =new Properties();
            properties.load(input);

        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public static String get(String keyName){
        return properties.getProperty(keyName);
    }




}
