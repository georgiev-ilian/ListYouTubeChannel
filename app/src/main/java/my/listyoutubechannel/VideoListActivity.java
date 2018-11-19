package my.listyoutubechannel;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import my.listyoutubechannel.databinding.ActivityVideoListBinding;

public class VideoListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityVideoListBinding binding = DataBindingUtil.setContentView(this,
                                                                          R.layout.activity_video_list);
        setSupportActionBar(binding.toolbar);
    }
}
