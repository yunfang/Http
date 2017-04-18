package appdemo.http.net.biz;


import appdemo.http.bean.BaseResult;

/**
 * Created by zhouyunfang on 17/4/13.
 */
public class UploadMethodRequest<R extends BaseResult> extends Request<R> {

    public UploadMethodRequest(Class<R> resultClass, String url) {
        super(2, resultClass, url);
    }
}
