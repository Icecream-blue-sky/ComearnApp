package com.example.team.wang.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.team.comearnlib.base.mvp_mode.base_model.BaseModel;
import com.example.team.comearnlib.base.mvp_mode.base_presenter.BasePresenter;
import com.example.team.comearnlib.base.mvp_mode.base_view.IBaseView;
import com.example.team.comearnlib.receiver.BaseReceiver;
import com.example.team.commonlibrary.base.application.MyApp;
import com.example.team.commonlibrary.base.util.Retrofit.RetroHttpUtil;
import com.example.team.commonlibrary.base.util.Retrofit.bean.BaseResponse;
import com.example.team.commonlibrary.base.util.Retrofit.bean.FriendTest;
import com.example.team.commonlibrary.base.util.Retrofit.callback.AbstractCommonHttpCallback;
import com.example.team.commonlibrary.base.util.ToastUtil;
import com.example.team.wang_part.R;
import com.jaeger.library.StatusBarUtil;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.rengwuxian.materialedittext.MaterialEditText;

import retrofit2.Call;


class AddFriendModel extends BaseModel {
    /**
     * 发送好友请求
     * @param text 验证消息
     */
    public void sendOutMessage(String text, Context context) {
        FriendTest friendTest = new FriendTest();//TODO 汪神在这里把FriendTest里面包含的信息（除了status）都放到FriendTest中
        Call<BaseResponse<Object>> addFriendCall = RetroHttpUtil.build().addFriendCall(friendTest);
        RetroHttpUtil.sendRequest(addFriendCall, new AbstractCommonHttpCallback<BaseResponse<Object>>() {
            @Override
            public void onSuccess(BaseResponse<Object> result) {
                ToastUtil.ToastShortShow("请求发送成功！", MyApp.getGlobalContext());
            }

            @Override
            public void onFail() {
                ToastUtil.ToastShortShow("请求发送失败！", MyApp.getGlobalContext());
            }
        });
    }
}

class AddFriendPresenter extends BasePresenter<AddFriendView> {
    private AddFriendModel mModel = new AddFriendModel();

    public void sendOutMessage(String text) {
        mModel.sendOutMessage(text, mContext);
    }
}

interface AddFriendView extends IBaseView {

}

public class AddFriendActivity extends AppCompatActivity implements AddFriendView {

    private QMUITopBar mTopBar;
    private AddFriendPresenter mPresenter = new AddFriendPresenter();
    private MaterialEditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);

        mPresenter.attachView(this);

        StatusBarUtil.setColor(AddFriendActivity.this, getResources().getColor(R.color.green), 50);

        initUI();

        initListeners();
    }

    private void initListeners() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button sendBtn = mTopBar.addRightTextButton("发送", 123);
        sendBtn.setTextColor(getResources().getColor(R.color.white));
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.sendOutMessage(mEditText.getText().toString());
                finish();
            }
        });
    }

    private void initUI() {
        mTopBar = findViewById(R.id.act_add_friend_top_bar);
        mEditText = findViewById(R.id.act_add_friend_et_message);

    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public Context getContext() {
        return this;
    }
}
