package com.wf.mn.home.contract;


import com.wf.mvplibrary.base.BaseIView;
import com.wf.mvplibrary.base.BaseModel;

/**
 * @author : wf
 * @time : 2020-11-10-9:00
 */
public class MainContract {
    public interface IMainModel extends BaseModel {
        public void getData();
    }

    public interface IMainPresenter {
        public void getDate();
        public  void mCallBackData(String string);
    }

    public interface IMainView extends BaseIView {
        public void setData(String string);
    }

}
