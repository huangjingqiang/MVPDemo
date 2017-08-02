package cn.han_zi.mvpdemo.ui.fragment.hot;

import cn.han_zi.mvpdemo.R;
import cn.han_zi.mvpdemo.base.BaseFragment;
import cn.han_zi.mvpdemo.bean.HotListBean;

/**
 * Create by xjs
 * _______date : 17/8/2
 * _______description:
 */
public class HotFragment extends BaseFragment<HotPresenter> implements HotContract.View{
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
    public void showHotList(HotListBean lists) {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showSuccess(String msg) {

    }
}
