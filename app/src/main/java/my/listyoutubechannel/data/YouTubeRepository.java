package my.listyoutubechannel.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import my.listyoutubechannel.data.service.ChannelVideosResponse;
import my.listyoutubechannel.data.service.Item;
import my.listyoutubechannel.data.service.YouTubeService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ilian.
 */
public class YouTubeRepository {

    String channelId = "UC_A--fhX5gea0i4UtpD99Gg";

    String maxResults = "20";

    String key = "AIzaSyAEV6gn8EKbAL9uQfX8XfrYG3v3vsIqEY8";

    private YouTubeService.YouTube youTube;

    public YouTubeRepository() {
        youTube = YouTubeService.create();
    }

    public LiveData<List<VideoListItem>> getChannelVideos() {
        final MutableLiveData<List<VideoListItem>> data = new MutableLiveData<>();

        youTube.getChannelVideos(channelId, maxResults, key)
               .enqueue(new Callback<ChannelVideosResponse>() {
                   @Override
                   public void onResponse(Call<ChannelVideosResponse> call,
                                          Response<ChannelVideosResponse> response) {
                       if (response.isSuccessful()) {
                           ChannelVideosResponse channelVideosResponse = response.body();
                           List<VideoListItem> list = new ArrayList<>();

                           for (Item item : channelVideosResponse.getItems()) {
                               list.add(new VideoListItem(item.getId().getVideoId(),
                                                          item.getSnippet().getTitle(),
                                                          item.getSnippet()
                                                              .getThumbnails()
                                                              .getMedium()
                                                              .getUrl()));
                           }

                           data.setValue(list);
                       }
                   }

                   @Override
                   public void onFailure(Call<ChannelVideosResponse> call, Throwable t) {
                       data.setValue(null);
                   }
               });

        return data;
    }

    public static YouTubeRepository getInstance() {
        return SingletonHelper.INSTANCE;
    }

    private static class SingletonHelper {

        private static final YouTubeRepository INSTANCE = new YouTubeRepository();
    }
}
