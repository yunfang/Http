package appdemo.http.net.biz;


import appdemo.http.bean.BaseResult;

/**
 * Created by zhouyunfang on 17/4/13.
 */
public class PostMethodRequest<R extends BaseResult> extends Request<R> {


    public PostMethodRequest( Class<R> resultClass, String url) {
        super(1, resultClass, url);
    }
}
