package cn.han_zi.mvpdemo.ui.fragment.daily;

import cn.han_zi.mvpdemo.base.BasePresenter;
import cn.han_zi.mvpdemo.base.BaseView;
import cn.han_zi.mvpdemo.bean.DailyListBean;

/**
 * Create by xjs
 * _______date : 17/8/2
 * _______description:
 */
public interface DailyContract {

    interface View extends BaseView{
        void showDailyList(DailyListBean lists);
    }

    interface Presenter extends BasePresenter<View>{
        void getDailyList();
    }
}
