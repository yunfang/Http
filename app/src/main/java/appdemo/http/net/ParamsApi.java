package appdemo.http.net;



import java.util.HashMap;

import appdemo.http.bean.PatentBean;
import appdemo.http.bean.PatentBean2;
import appdemo.http.net.biz.GetMethodRequest;
import appdemo.http.net.biz.PostMethodRequest;
import appdemo.http.net.biz.Request;

/**
 * Created by zhouyunfang on 17/4/13.
 * 所有的访问网络方法都在此定义
 */
public class ParamsApi {

    //get请求  GetMethodRequest
    public final static Request<PatentBean> getPatientCode(HashMap<String ,Object> map) {

        return new GetMethodRequest<PatentBean>(PatentBean.class, Api.API+Api.GETPATIENT_URL).addArgument(map);
    }

    //post请求方式   PostMethodRequest
    public final static Request<PatentBean2> getPatient2(HashMap<String ,Object> map) {

        return new PostMethodRequest<PatentBean2>(PatentBean2.class, Api.API+Api.GETPATIENT_URL).addArgument(map);
    }


}
