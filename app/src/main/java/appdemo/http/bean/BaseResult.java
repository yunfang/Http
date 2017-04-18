package appdemo.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhouyunfang on 17/4/13.
 */
public class BaseResult {

    private String Code;

    private String Message;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
