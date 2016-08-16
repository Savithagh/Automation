package com.tweet.util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Savi on 7/16/2016.
 */


public class ResourceMethodType {

        private static HashMap<String, String> _locators;
            public static void loadJsonMap(String jsonPath)
        {
            if (_locators != null)
                return;
            _locators = new HashMap<String, String>();
            JSONParser parser = new JSONParser();
            try
            {
                Object obj = parser.parse(new FileReader(jsonPath));
                JSONObject jsonObject = (JSONObject) obj;
                for (Object key : jsonObject.keySet())
                {
                    _locators.put((String) key, (String) jsonObject.get(key));
                }
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }
        public static String getValue(String key) {
            try
            {
                return _locators.get(key);
            }
            catch (Exception ex)
            {

            }
            return "";
        }

        public static String get(String locator) throws Exception {
            try {
                if (locator.contains("="))
                {
                    String[] values = locator.split("=");
                    if (values[0].toLowerCase().equals("get"))
                    {
                        return getValue(values[1]);
                        //   By.class()
                    }
                    if (values[0].toLowerCase().equals("put"))
                    {
                        return getValue(values[1]);
                        //   By.class()
                    }
                }
                    return getValue(locator);
                }catch(Exception ex)
                {
                    throw ex;
                }
            }

}

