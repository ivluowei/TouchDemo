package cn.lw.touch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * 作者: Created by luow on 2017/10/11.
 * 注释：
 */

public class TestViewB extends LinearLayout {
    public TestViewB(Context context) {
        super(context);
    }

    public TestViewB(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TestViewB(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("lw", "dispatchTouchEvent---B");
        //true:不分发,打印log直走了dispatchTouchEvent --- A
        //false: 不分发，向上传递,上个控件执行onTouchEvent方法
        //super.dispatchTouchEvent(ev): 分发，如果是view执行onTouchEvent的方法，
        // 如果是viewGroup执行onInterceptTouchEvent的方法
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("lw", "onInterceptTouchEvent---B");
        //true: 表示拦截，然后执行当前控件的onTouchEvent方法
        //false和super.onInterceptTouchEvent(ev): 表示不拦截，向下传递
        //false和super.onInterceptTouchEvent(ev)的区别是，
        // 通过super.onInterceptTouchEvent(ev)，
        // 会调用到该控件内部的方法做一些处理之后再交给子元素处理，false是不拦截，直接交给子元素处理
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("lw", "onTouchEvent---B");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("lw", "MyLinear onTouchEvent ACTION_DOWN");

                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("lw", "MyLinear onTouchEvent ACTION_MOVE");

                break;

            case MotionEvent.ACTION_UP:
                Log.d("lw", "MyLinear onTouchEvent ACTION_UP");

                break;
            default:
                break;
        }
        //true:表示消费当前view的onTouchEvent事件,不在向上传递,并且move，up它的onInterceptTouchEvent不在执行
        //false：表示不消费当前view的onTouchEvent事件，继续向上传递

        //super.onTouchEvent(event):如果这个view是可点击的(比如:button)，也就是clickable或者longClickable为true，
        // View的longClickable默认都为false,这种情况super.onTouchEvent(event)返回的是true,
        // 表示在消费当前view的onTouchEvent事件,不在向上传递；
        //如果这个view是不可点击的(比如:TextView)，也就是clickable和longClickable都为false，这种情况super.onTouchEvent(event)返回的是false,
        //表示不消费当前view的onTouchEvent事件，继续向上传递
        return super.onTouchEvent(event);
    }

}
