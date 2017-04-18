package appdemo.http.net.biz;


import appdemo.http.bean.BaseResult;

/**
 * Created by zhouyunfang on 17/4/13.
 */
public class GetMethodRequest<R extends BaseResult> extends Request<R> {


    public GetMethodRequest(Class<R> resultClass, String url) {
        super(0, resultClass, url);
    }

    
}
