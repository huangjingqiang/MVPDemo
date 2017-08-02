package cn.han_zi.mvpdemo.ui.fragment.daily;

import cn.han_zi.mvpdemo.R;
import cn.han_zi.mvpdemo.base.BaseFragment;
import cn.han_zi.mvpdemo.bean.DailyListBean;

/**
 * Create by xjs
 * _______date : 17/8/2
 * _______description:
 */
public class DailyFragment extends BaseFragment<DailyPresenter> implements DailyContract.View {

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
    public void showDailyList(DailyListBean lists) {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showSuccess(String msg) {

    }
}
