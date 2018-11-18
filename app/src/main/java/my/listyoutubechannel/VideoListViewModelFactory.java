package my.listyoutubechannel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import my.listyoutubechannel.data.YouTubeRepository;

/**
 * Created by ilian.
 */
public class VideoListViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private YouTubeRepository repository;

    public VideoListViewModelFactory(YouTubeRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        VideoListViewModel videoListViewModel = new VideoListViewModel(repository);
        //noinspection unchecked
        return (T) videoListViewModel;
    }
}
