package appdemo.http.net.biz;


import appdemo.http.bean.BaseResult;

/**
 * Created by zhouyunfang on 17/4/13.
 */
public interface RequestCallback<R extends BaseResult> {
    /**
     * 当请求成功后回调
     *
     * @param dataResult 数据结果
     */
    public void onRequestSuccess(R dataResult);

    /**
     *
     * 当请求失败后回调
     *
     * @param dataResult 数据结果
     */
    public void onRequestFailure(R dataResult);
}
