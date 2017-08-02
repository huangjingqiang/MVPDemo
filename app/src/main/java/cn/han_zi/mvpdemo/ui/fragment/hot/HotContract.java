package cn.han_zi.mvpdemo.ui.fragment.hot;

import cn.han_zi.mvpdemo.base.BasePresenter;
import cn.han_zi.mvpdemo.base.BaseView;
import cn.han_zi.mvpdemo.bean.HotListBean;

/**
 * Create by xjs
 * _______date : 17/8/2
 * _______description:
 */
public interface HotContract {

    interface View extends BaseView{
        void showHotList(HotListBean lists);
    }

    interface Presenter extends BasePresenter<View>{
        void getHotList();
    }
}
