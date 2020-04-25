package com.mysql_api.utility;

import com.google.gson.JsonObject;

public class UserUtility {

    public static boolean isNullOrEmpty(String value){
        if(value == null){
            return true;
        }
        if(value.length() == 0){
            return true;
        }
        return false;
    }

    public static boolean isNullOrEmpty(JsonObject jsonObject){
        if(jsonObject == null){
            return true;
        }
        if(jsonObject.entrySet().isEmpty()){
            return true;
        }
        return false;
    }
}
