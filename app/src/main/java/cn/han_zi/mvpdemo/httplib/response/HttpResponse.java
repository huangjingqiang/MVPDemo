package cn.han_zi.mvpdemo.httplib.response;

/**
 * Create by xjs
 * _______date : 17/8/2
 * _______description:
 */
public class HttpResponse<T> {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
