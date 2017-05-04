package appdemo.http.utils;

import android.app.Activity;
import android.app.Dialog;
import android.view.Window;


import org.xutils.x;


/**
 * Created by zhouyunfang on 2015/11/4.
 * 继承Dialog
 */
public abstract class AbsDialog extends Dialog {

    public AbsDialog(Activity activity) {
        this(activity, null);
    }
    public AbsDialog(Activity activity, int theme) {
        super(activity, theme);
    }
    /**
     * @param activity
     * @param obj     Dialog的寄主
     */
    public AbsDialog(Activity activity, Object obj) {
        super(activity);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(setLayoutId());
//        ButterKnife.inject(this);
        x.view().inject(activity);
    }

    public abstract void setInitView();

    @Override
    public void dismiss() {
        super.dismiss();
        System.gc();
    }

    /**
     * 设置资源布局
     *
     * @return
     */
    protected abstract int setLayoutId();

    /**
     * 数据回调
     */
    protected abstract void dataCallback(int result, Object obj);

}
