package com.sn.android_mygson.gson;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by John on 2018/4/25.
 */
public class GsonTools {
    public GsonTools() {
    }

    /*
    解析方式一
     */
    public static <T> T getPerson(String jsonString,Class<T> cls){
        T t=null;//t为通用范型，可以表示任意的数据类型
        try {
            Gson gson=new Gson();
            t=gson.fromJson(jsonString,cls);
        }catch (Exception e){

        }
        return  t;
    }
    /*
    使用Gson解析List<person>
     */
    public static <T> List<T> getPersons(String jsonString,Class<T> cls){
        List<T> list=new ArrayList<T>();
        try {
            Gson gson=new Gson();
            //将json封装到List中，再从T中取出所有类型
            list=gson.fromJson(jsonString,new TypeToken<List<T>>(){}.getType());
        }catch (Exception e){

        }
        return list;
    }
    /*

     */
    public static List<String> getList(String jsonString){
        List<String> list=new ArrayList<String>();
        try {
            Gson gson=new Gson();
            list=gson.fromJson(jsonString,new TypeToken<List<String>>(){}.getType());
        }catch (Exception e){

        }
        return list;
    }

    public static List<Map<String,Object>> getListKeyMaps(String jsonString){
        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();

        try {
            Gson gson=new Gson();
            list=gson.fromJson(jsonString,new TypeToken<List<Map<String,Object>>>(){}.getType());
        }catch (Exception e) {

        }
        return list;
    }

}
