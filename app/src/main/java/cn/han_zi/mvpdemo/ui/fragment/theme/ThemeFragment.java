package cn.han_zi.mvpdemo.ui.fragment.theme;

import cn.han_zi.mvpdemo.R;
import cn.han_zi.mvpdemo.base.BaseFragment;

/**
 * Create by xjs
 * _______date : 17/8/2
 * _______description:
 */
public class ThemeFragment extends BaseFragment<ThemePresenter> implements ThemeContract.View{
    @Override
    protected void initInject() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_daily;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showSuccess(String msg) {

    }
}
