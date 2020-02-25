package com.joeso.designpattern_mvp;

public class MyPresenter implements Ipresenter {
    Iview myView;
    Imodel myModel;

    public MyPresenter(Iview myView){
        this.myView=myView;
        this.myModel=new MyModel();
    }

    @Override
    public void onGetNumber() {
        if(myView!=null) {
            myView.showProgress();
            myView.updateNumber( myModel.getNumber());
            myView.hideProgress();
        }
    }
    @Override
    public void onDestroy() {
        myView=null;
    }
}
