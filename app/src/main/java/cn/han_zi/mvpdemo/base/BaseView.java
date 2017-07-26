package cn.han_zi.mvpdemo.base;

/**
 * Create by xjs
 * _______date : 17/7/24
 * _______description:view基类
 */
public interface BaseView{
    void showError(String msg);

    void showSuccess(String msg);

    void showProgress();

    void hideProgress();
}
