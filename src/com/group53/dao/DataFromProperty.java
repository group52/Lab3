package com.group53.dao;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class DataFromProperty {
    public BasicDataSource getOracleDataSource(){

        Locale.setDefault(Locale.ENGLISH);
        Properties props = new Properties();
        FileInputStream fis = null;


        try {

            File file = new File("D:/OnlineJournal-master/src/main/resources/application.properties");
            fis = new FileInputStream(file);
            props.load(fis);
            BasicDataSource ds = new BasicDataSource();
            ds.setDriverClassName(props.getProperty("ORACLE_DB_DRIVER_CLASS"));
            ds.setUrl(props.getProperty("ORACLE_DB_URL"));
            ds.setUsername(props.getProperty("ORACLE_DB_USERNAME"));
            ds.setPassword(props.getProperty("ORACLE_DB_PASSWORD"));

            return ds;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}


