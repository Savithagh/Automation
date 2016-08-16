package com.tweet.util;

import org.apache.log4j.Logger;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

    public String BaseUrl;
    public String BaseURI;
    public String TestResultPath;
    public String TestDataPath;
    public int WaitTimeout;
    private Logger _logger;
    public String DataFileName;
    public boolean TakeScreenShot;
  


    public Configuration(String type){//boolean isWebTest) {
        try {
            _logger = Logger.getLogger(Configuration.class);

            Properties props = loadProperties(type);
            setCommonProps(props);
            if(type=="rest")
            {
                props.load(new FileReader(String.format("%s/restConfig.properties", System.getProperty("user.dir"))));
            }
        } catch (Exception ex) {
            _logger.error(ex);
        }

    }

    private Properties loadProperties(String type)//boolean isWebTest)
    {
        Properties props = new Properties();
        try {
                props.load(new FileReader(String.format("%s/config.properties", System.getProperty("user.dir"))));
            
        } catch (IOException e) {
            _logger.error(e);
        }

        return props;
    }

    public void setCommonProps(Properties mProps)
    {
        WaitTimeout = Integer.parseInt(mProps.getProperty("wait-timeout"));
        DataFileName = mProps.getProperty("data-file-name");
    }
   /* public void setWebProps(Properties mProps)
    {
        //Browser = Browsers.valueOf(props.getProperty("browser"));
        String browser = mProps.getProperty("browser");
        Browsers = Browsers.Firefox;
        if(browser.toLowerCase().equals("firefox"))
        {
            Browsers = Browsers.Firefox;
        }
        else if(browser.toLowerCase().equals("chrome"))
        {
            Browsers = Browsers.Chrome;
        }
        else if(browser.toLowerCase().equals("htmlunit"))
        {
            Browsers = Browsers.HtmlUnit;
        }
        else if(browser.toLowerCase().equals("ie"))
        {
            Browsers = Browsers.InternetExplorer;
        }

        BaseUrl = mProps.getProperty("url");
        TestResultPath = mProps.getProperty("test-result-path");
        TestDataPath = mProps.getProperty("test-data-path");
        TakeScreenShot = Boolean.valueOf(mProps.getProperty("takeScreenShot"));
       // ScreenFolderPath = mProps.getProperty("screenshot-folder-path");
    }
*/
    public void setRestProps(Properties mProps)
    {
        BaseURI = mProps.getProperty("uri");
        //  Browser = Browsers.Android;
        
    }

}
