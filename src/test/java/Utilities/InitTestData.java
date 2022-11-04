package Utilities;

import io.qameta.allure.Step;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class InitTestData {
    public Properties testdata;

    public InitTestData(String env) throws IOException {
        testdata = new Properties();
        if (env.equalsIgnoreCase("alpha")) {
            FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\env_configs\\alpha.properties");
            testdata.load(objfile);
        } else if (env.equalsIgnoreCase("omega")) {
            FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\env_configs\\omega.properties");
            testdata.load(objfile);
        } else if (env.equalsIgnoreCase("neo")) {
            FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\env_configs\\neo.properties");
            testdata.load(objfile);
        } else if (env.equalsIgnoreCase("super")) {
            FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\env_configs\\super.properties");
            testdata.load(objfile);
        }
    }
}
