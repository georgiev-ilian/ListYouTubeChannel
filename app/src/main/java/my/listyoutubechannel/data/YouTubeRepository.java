package my.listyoutubechannel.data;

import io.reactivex.Observable;
import my.listyoutubechannel.data.service.YouTubeService;
import my.listyoutubechannel.data.service.video.ChannelVideosResponse;

/**
 * Created by ilian.
 */
public class YouTubeRepository {

    public static final int MAX_RESULTS = 20;

    private static final String CHANNEL_ID = "UC_A--fhX5gea0i4UtpD99Gg";

    private static final String KEY = "AIzaSyAEV6gn8EKbAL9uQfX8XfrYG3v3vsIqEY8";

    private YouTubeService.YouTube youTube;

    private YouTubeRepository() {
        youTube = YouTubeService.create();
    }

    public Observable<ChannelVideosResponse> getChannelVideos(String pageToken) {
        return youTube.getChannelVideos(CHANNEL_ID, String.valueOf(MAX_RESULTS), KEY, pageToken);
    }

    public static YouTubeRepository getInstance() {
        return SingletonHelper.INSTANCE;
    }

    private static class SingletonHelper {

        private static final YouTubeRepository INSTANCE = new YouTubeRepository();
    }
}
