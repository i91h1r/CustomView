package com.github.hyr0318.customview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.github.hyr0318.customview_library.CustomView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.custom1)
    CustomView customView1 ;

    @Bind(R.id.custom2)
    CustomView customView2 ;

    @Bind(R.id.custom3)
    CustomView customView3 ;


    @Bind(R.id.custom4)
    CustomView customView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initListener();
    }


    private void initListener() {

        customView1.setOnClickListener(this);
        customView2.setOnClickListener(this);
        customView3.setOnClickListener(this);
        customView4.setOnClickListener(this);
    }


    @Override public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){



            case R.id.custom1:
                startActivity(intent.setClass(this,SettingActivity.class));
                break;

            case R.id.custom2:
                startActivity(intent.setClass(this,CenterActiity.class));
                break;
            case R.id.custom3:
                startActivity(intent.setClass(this,LeftTextAndImgActiity.class));
                break;
            case R.id.custom4:
                startActivity(intent.setClass(this,RightBtnAndEtActivity.class));
                break;
        }
    }
}
