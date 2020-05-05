package com.Crawler;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.File;

public class AppConfig  {

    private static String CONFIG_PATH =new File("").getAbsolutePath()+"\\application.conf";
    private static Config config;

    private AppConfig(){}

    public synchronized static Config getInstance(){
        File file = new File(CONFIG_PATH);
        System.out.println(file.getAbsoluteFile());
        if (config==null){
            return (CONFIG_PATH==null || CONFIG_PATH.length()==0) ? ConfigFactory.load(): ConfigFactory.parseFile(new File(CONFIG_PATH));
        }
        return config;
    }
}