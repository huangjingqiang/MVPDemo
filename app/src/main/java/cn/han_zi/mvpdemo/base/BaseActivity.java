package cn.han_zi.mvpdemo.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.han_zi.mvpdemo.MyApp;
import cn.han_zi.mvpdemo.R;
import cn.han_zi.mvpdemo.di.component.ActivityComponent;
import cn.han_zi.mvpdemo.di.component.DaggerActivityComponent;
import cn.han_zi.mvpdemo.di.module.ActivityModule;
import cn.han_zi.mvpdemo.utils.StatusBarUtil;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Create by xjs
 * _______date : 17/7/24
 * _______description:实现mvp的基类
 */
public abstract class BaseActivity<T extends BasePresenter> extends SupportActivity implements BaseView {
    @Inject
    protected T mPresenter;
    protected Activity mContext;
    private Unbinder mUnBinder;

    private ProgressDialog progressDialog;

    protected ActivityComponent getActivityComponent(){
        return DaggerActivityComponent.builder()
                .appComponent(MyApp.getAppComponent())
                .activityModule(getActivityModel())
                .build();
    }

    protected ActivityModule getActivityModel(){
        return new ActivityModule(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mUnBinder = ButterKnife.bind(this);
        mContext = this;
        initInject();
        setStatusBar();
        if (mPresenter != null){
            mPresenter.attachView(this);
        }

        initEventAndData();
    }

    /**
     * 设置默认状态栏颜色
     */
    protected void setStatusBar(){
        StatusBarUtil.setColor(this,getResources().getColor(R.color.colorPrimary));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null){
            mPresenter.detachView();
        }
        mUnBinder.unbind();
    }



    @Override
    public void showProgress() {
        showProgressDialog(null);
    }

    @Override
    public void hideProgress() {
        closeProgressDialog();
    }

    private void showProgressDialog(String tips) {
        if (progressDialog == null || !TextUtils.isEmpty(tips)) {
            progressDialog = new ProgressDialog(mContext);
            String tipsNow = TextUtils.isEmpty(tips) ? "正在加载" : tips;
            progressDialog.setMessage(tipsNow);
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.show();
    }

    private void closeProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    protected abstract void initInject();

    protected abstract int getLayout();

    protected abstract void initEventAndData();

}
