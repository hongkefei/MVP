package com.wf.mvplibrary.base;

/**
 * @author : wf
 * @time : 2020-11-10-10:49
 */
public abstract  class BasePresenter<V extends BaseIView,M extends BaseModel> {

    public M iModel;

    public BasePresenter() {
    }
    public V iView;
    public void initViewModel(V t){
        this.iView = t;
       this.iModel =  setModel();
    }
//    当页面销毁得时候，需要解除view得关联
    public void ditcahView(){
        iView = null;
    }

    public abstract M setModel();


}
