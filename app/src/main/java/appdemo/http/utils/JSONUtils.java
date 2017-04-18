package appdemo.http.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * Created by zhouyunfang on 17/4/13.
 */
public class JSONUtils {

    private static Gson mGson = new GsonBuilder().serializeNulls().create();

    public static Gson gsonInstance() {
        return mGson;
    }

    public static <T> T fromJsonString(String jsonString, Class<T> clazz) {
        try {
            return gsonInstance().fromJson(jsonString, clazz);
        } catch (com.google.gson.JsonSyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
