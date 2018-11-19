package my.listyoutubechannel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import my.listyoutubechannel.data.VideoRepository;
import my.listyoutubechannel.data.YouTubeRepository;

/**
 * Created by ilian.
 */
public class VideoListViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private YouTubeRepository repository;

    private VideoRepository videoRepository;

    public VideoListViewModelFactory(YouTubeRepository repository,
                                     VideoRepository videoRepository) {
        this.repository = repository;
        this.videoRepository = videoRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        VideoListViewModel videoListViewModel = new VideoListViewModel(repository, videoRepository);
        //noinspection unchecked
        return (T) videoListViewModel;
    }
}
