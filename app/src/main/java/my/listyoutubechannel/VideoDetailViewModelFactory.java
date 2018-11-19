package my.listyoutubechannel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import my.listyoutubechannel.data.VideoRepository;
import my.listyoutubechannel.data.YouTubeRepository;

/**
 * Created by ilian.
 */
public class VideoDetailViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private YouTubeRepository repository;

    private VideoRepository videoRepository;

    private String videoId;

    public VideoDetailViewModelFactory(YouTubeRepository repository,
                                       VideoRepository videoRepository,
                                       String videoId) {
        this.repository = repository;
        this.videoRepository = videoRepository;
        this.videoId = videoId;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        VideoDetailViewModel videoDetailViewModel = new VideoDetailViewModel(repository,
                                                                             videoRepository,
                                                                             videoId);
        //noinspection unchecked
        return (T) videoDetailViewModel;
    }
}
