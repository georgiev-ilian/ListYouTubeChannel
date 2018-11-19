package my.listyoutubechannel.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ilian.
 */
public class VideoRepository {

    private Map<String, VideoDetail> videoDetailMap = new HashMap<>();

    private VideoRepository() {
    }

    void addVideoDetail(String videoId, VideoDetail videoDetail) {
        videoDetailMap.put(videoId, videoDetail);
    }

    public static VideoRepository getInstance() {
        return SingletonHelper.INSTANCE;
    }

    private static class SingletonHelper {

        private static final VideoRepository INSTANCE = new VideoRepository();
    }
}
