package com.coolweather.android.util;

import android.text.TextUtils;

import com.coolweather.android.db.City;
import com.coolweather.android.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by xsp on 2018/6/4.
 */

public class Utility {
    public static boolean handleProvinceResponse(String response){
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvinces = new JSONArray(response) ;
                    for(
                    int i = 0;
                    i<allProvinces.length();i++)

                    {
                        JSONObject provinceObject =allProvinces.getJSONObject(i);
                        Province province =new Province();
                        province.setProvinceName(provinceObject.getString("name"));
                        province.setProvinceCode(provinceObject.getInt("id"));
                        province.save();

                    }

                    return true;
                }catch(JSONException e){
                    e.printStackTrace();
                }
            }
            return false;
        }
    public static boolean handleCityResponse(String response,int provinceId){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allCities =new JSONArray(response);
                for (int i=0;i<allCities.length();i++){
                    JSONObject cityObject=allCities.getJSONObject(i);
                    City city=new City();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
    }

}
