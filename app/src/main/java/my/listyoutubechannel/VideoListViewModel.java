package my.listyoutubechannel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import java.util.List;

import my.listyoutubechannel.data.VideoListItem;
import my.listyoutubechannel.data.YouTubeRepository;

/**
 * Created by ilian.
 */
public class VideoListViewModel extends ViewModel {

    private YouTubeRepository youTubeRepository;

    //private MutableLiveData<List<Item>>
    //private static final MutableLiveData
    public VideoListViewModel(@NonNull YouTubeRepository youTubeRepository) {
        this.youTubeRepository = youTubeRepository;
    }

    public LiveData<List<VideoListItem>> getVideoList() {
        return youTubeRepository.getChannelVideos();
    }
}
