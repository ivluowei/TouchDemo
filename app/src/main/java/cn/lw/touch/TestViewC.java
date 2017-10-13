package cn.lw.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * 作者: Created by luow on 2017/10/11.
 * 注释：
 */

public class TestViewC extends View {
    public TestViewC(Context context) {
        super(context);
    }

    public TestViewC(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestViewC(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("lw", "MotionEventViewC dispatchTouchEventC");
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("lw", "dispatchTouchEvent ACTION_DOWN");
                //requestDisallowInterceptTouchEvent(true):
                //执行拦截的前提是onTouchEvent返回时true，即是当前view消费事件,
                // true表示此子View的所有父ViewGroup会跳过onInterceptTouchEvent回调，父view执行完dispatchTouchEvent后，
                // 直接传递到子view，子view执行dispatchTouchEvent，
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("lw", "dispatchTouchEvent ACTION_MOVE");
                break;

            case MotionEvent.ACTION_UP:
                getParent().requestDisallowInterceptTouchEvent(false);
                Log.d("lw", "dispatchTouchEvent ACTION_UP");

                break;
            default:
                break;
        }
        //true:不分发,打印log直走了dispatchTouchEvent --- A
        //false: 不分发，向上传递,上个元素执行onTouchEvent方法
        //super.dispatchTouchEvent(ev): 分发，如果是view执行onTouchEvent的方法，
        // 如果是viewGroup执行onInterceptTouchEvent的方法
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("lw", "MotionEventViewC onTouchEventC");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("lw", "onTouchEvent ACTION_DOWN");

                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("lw", "onTouchEvent ACTION_MOVE");

                break;

            case MotionEvent.ACTION_UP:
                Log.d("lw", "onTouchEvent ACTION_UP");

                break;
            default:
                break;
        }
        //true:表示在消费当前view的onTouchEvent事件,不在向上传递,并且move，up它的onInterceptTouchEvent不在执行
        //false：表示不消费当前view的onTouchEvent事件，继续向上传递

        //super.onTouchEvent(event):如果这个view是可点击的(比如:button)，也就是clickable或者longClickable为true，
        // View的longClickable默认都为false,这种情况super.onTouchEvent(event)返回的是true,
        // 表示在消费当前view的onTouchEvent事件,不在向上传递；
        //如果这个view是不可点击的(比如:TextView)，也就是clickable和longClickable都为false，这种情况super.onTouchEvent(event)返回的是false,
        //表示不消费当前view的onTouchEvent事件，继续向上传递
        return super.onTouchEvent(event);

    }
}
