package appdemo.http.utils.notify;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import appdemo.http.R;
import appdemo.http.utils.AbsDialog;

/**
 * Created by zhouyunfang on 16/7/19.
 */
public class DetailDialog extends AbsDialog {

    private String article_id;
    private String to_discuss_id;
    private String to_user_id;
    private String to_user_name;

    public DetailDialog(Activity activity, int theme) {
        super(activity, theme);
    }


    public DetailDialog(Activity activity) {
        super(activity);
        setInitView();
    }

    /**
     *
     * @param article_id
     * @param to_discuss_id  会话的ID
     * @param to_user_id     被评论人的ID
     * @param to_user_name   被评论人的名字
     */
    public void setDetailMessage(String article_id, String to_discuss_id, String to_user_id, String to_user_name){
        this.article_id = article_id;
        this.to_discuss_id = to_discuss_id;
        this.to_user_id = to_user_id;
        this.to_user_name = to_user_name;
    }


    @Override
    protected int setLayoutId() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        return R.layout.layout_detail_popuwindow;

     }

    @Override
    public void setInitView() {

    }

    @Override
    protected void dataCallback(int result, Object obj) {

    }


}
