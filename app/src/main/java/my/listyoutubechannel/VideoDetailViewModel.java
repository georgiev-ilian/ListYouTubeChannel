package my.listyoutubechannel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import my.listyoutubechannel.data.VideoDetail;
import my.listyoutubechannel.data.VideoRepository;
import my.listyoutubechannel.data.YouTubeRepository;

/**
 * Created by ilian.
 */
public class VideoDetailViewModel extends ViewModel {

    private final YouTubeRepository youTubeRepository;

    private final VideoRepository videoRepository;

    private LiveData<VideoDetail> videoDetail;

    public VideoDetailViewModel(YouTubeRepository youTubeRepository,
                                VideoRepository videoRepository,
                                String videoId) {
        this.videoRepository = videoRepository;
        this.youTubeRepository = youTubeRepository;
        this.videoDetail = videoRepository.getVideoDetail(videoId);
    }

    public LiveData<VideoDetail> getVideoDetail() {
        return videoDetail;
    }
}
