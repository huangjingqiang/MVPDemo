package cn.han_zi.mvpdemo.base;

/**
 * Create by xjs
 * _______date : 17/7/24
 * _______description:
 */
public interface BasePresenter<T extends BaseView> {
    void attachView(T view);

    void detachView();
}
