package my.listyoutubechannel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import my.listyoutubechannel.service.ChannelVideosResponse;
import my.listyoutubechannel.service.YouTubeService;

public class ListYouTubeChannelActivity extends AppCompatActivity {

    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        YouTubeService.YouTube youTube = YouTubeService.create();

        String channelId = "UC_A--fhX5gea0i4UtpD99Gg";
        String maxResults = "20";
        String key = "AIzaSyAEV6gn8EKbAL9uQfX8XfrYG3v3vsIqEY8";

        Observable<ChannelVideosResponse> call = youTube.getChannelVideos(channelId,
                                                                          maxResults,
                                                                          key);

        /*this.disposable =
                call.observeOn(AndroidSchedulers.mainThread()).subscribeWith(new Observable<>() {

        });*/

        /*call.enqueue(new Callback<ChannelVideosResponse>() {
            @Override
            public void onResponse(Call<ChannelVideosResponse> call,
                                   Response<ChannelVideosResponse> response) {
                ChannelVideosResponse channelVideosResponse = response.body();
                Log.d("MainActivity", "onResponse: " + channelVideosResponse);
            }

            @Override
            public void onFailure(Call<ChannelVideosResponse> call, Throwable t) {

            }
        });*/

        /*try {
            ChannelVideosResponse response = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
