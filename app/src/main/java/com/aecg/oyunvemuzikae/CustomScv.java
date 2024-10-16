package com.aecg.oyunvemuzikae;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
public class CustomScv extends HorizontalScrollView {
    private boolean enableScrolling = true;

    public CustomScv(Context context) {
        super(context);
    }

    public CustomScv(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomScv(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(scrollingEnabled()){
            return super.onInterceptTouchEvent(ev);
        }else {return false;}
    }

    private boolean scrollingEnabled() {
        return enableScrolling;
    }
    public void setScrolling(boolean enableScrolling){
        this.enableScrolling = enableScrolling;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(scrollingEnabled()){
            return super.onTouchEvent(ev);}
        else {return false;}

    }

}
