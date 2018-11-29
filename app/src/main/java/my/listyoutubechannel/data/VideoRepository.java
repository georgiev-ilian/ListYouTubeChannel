package my.listyoutubechannel.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.schedulers.Schedulers;
import my.listyoutubechannel.data.service.video.VideoListResponse;

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

    public LiveData<VideoDetail> getVideoDetail(YouTubeRepository youTubeRepository,
                                                String videoId) {
        LiveData<VideoDetail> data = new MutableLiveData<>();
        final VideoDetail videoDetail = videoDetailMap.get(videoId);
        ((MutableLiveData<VideoDetail>) data).postValue(videoDetail);

        youTubeRepository.getVideoList(videoId)
                         .subscribeOn(Schedulers.io())
                         .subscribe((VideoListResponse videoResult) -> {
                             if (videoDetail != null) {
                                 final String duration = videoResult.getItems()
                                                                    .get(0)
                                                                    .getContentDetails()
                                                                    .getDuration();
                                 videoDetail.setDuration(duration);

                                 ((MutableLiveData<VideoDetail>) data).postValue(videoDetail);
                             }
                         }, throwable -> {
                         });

        return data;
    }

    public static VideoRepository getInstance() {
        return SingletonHelper.INSTANCE;
    }

    private static class SingletonHelper {

        private static final VideoRepository INSTANCE = new VideoRepository();
    }
}
