package com.github.hyr0318.customview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import com.github.hyr0318.customview_library.CustomView;

/**
 * Description:
 * 作者：hyr on 2016/10/27 10:05
 * 邮箱：2045446584@qq.com
 */
public class RightBtnAndEtActivity extends Activity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout4);
        CustomView customView = (CustomView) findViewById(R.id.cccc);

        customView.setOnRightBtnClicklistener(new CustomView.OnRightBtnClicklistener() {
            @Override public void onRightBtnClick() {
                Toast.makeText(getApplicationContext(),"点我干嘛?",Toast.LENGTH_LONG).show();
            }
        });

    }

}
