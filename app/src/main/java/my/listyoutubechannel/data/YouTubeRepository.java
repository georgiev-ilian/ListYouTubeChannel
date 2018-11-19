package my.listyoutubechannel.data;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import my.listyoutubechannel.data.service.ChannelVideosResponse;
import my.listyoutubechannel.data.service.YouTubeService;

/**
 * Created by ilian.
 */
public class YouTubeRepository {

    private String channelId = "UC_A--fhX5gea0i4UtpD99Gg";

    private String maxResults = "20";

    private String key = "AIzaSyAEV6gn8EKbAL9uQfX8XfrYG3v3vsIqEY8";

    private YouTubeService.YouTube youTube;

    //private MutableLiveData<Map<String, VideoDetail>> videoDetailMap;

    private Map<String, VideoDetail> videoDetailMap = new HashMap<>();

    public YouTubeRepository() {
        youTube = YouTubeService.create();
    }

    public Observable<ChannelVideosResponse> getChannelVideos(String pageToken) {
        return youTube.getChannelVideos(channelId, maxResults, key, pageToken);
    }

    public static YouTubeRepository getInstance() {
        return SingletonHelper.INSTANCE;
    }

    private static class SingletonHelper {

        private static final YouTubeRepository INSTANCE = new YouTubeRepository();
    }
}
