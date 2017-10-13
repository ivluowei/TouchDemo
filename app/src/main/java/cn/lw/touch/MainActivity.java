package cn.lw.touch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TestViewC mBtnClick;
    private TestViewB ll;
    private TestViewA lll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnClick = (TestViewC) findViewById(R.id.btn_click);
//        ll = (MyLinear) findViewById(R.id.ll);
        lll = (TestViewA) findViewById(R.id.lll);
//
//        ll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("lw", "onclick---ll");
//            }
//        });
//
//        lll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("lw", "onclick---lll");
//            }
//        });
//
//        mBtnClick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("lw", "onclick");
//            }
//        });
//
//        mBtnClick.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//
//                Log.d("lw", "onTouch");
//                return false;
//            }
//        });
//
//
//        mBtnClick.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                Log.d("lw", "onLongClick");
//                return false;
//            }
//        });
    }
}
