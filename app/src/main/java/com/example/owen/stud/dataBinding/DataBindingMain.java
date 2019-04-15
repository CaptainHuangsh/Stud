package com.example.owen.stud.dataBinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.owen.stud.R;


/**
 * Created by loopeer on 2017/7/25.
 */

public class DataBindingMain extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
/*        //setContentView(R.layout.activity_databinding_main);
        //databinding用下面的方式绑定
        com.example.owen.stud.dataBinding.DataBindingMain binding = DataBindingUtil.setContentView(this,
                R.layout.activity_databinding_main);
        //不知道怎么改的，就好了 ！ ！ ！
        User user = new User("huang","shaohua",21);
        binding.setUser(user);
*/

    }
}
