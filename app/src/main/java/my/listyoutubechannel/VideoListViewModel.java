package my.listyoutubechannel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import io.reactivex.disposables.CompositeDisposable;
import my.listyoutubechannel.data.VideoListDataSourceClass;
import my.listyoutubechannel.data.VideoListDataSourceFactory;
import my.listyoutubechannel.data.VideoListItem;
import my.listyoutubechannel.data.YouTubeRepository;

/**
 * Created by ilian.
 */
public class VideoListViewModel extends ViewModel {

    private LiveData<PagedList<VideoListItem>> listLiveData;

    private VideoListDataSourceFactory videoListDataSourceFactory;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private LiveData<String> progressLoadStatus = new MutableLiveData<>();

    public VideoListViewModel(@NonNull YouTubeRepository youTubeRepository) {
        videoListDataSourceFactory = new VideoListDataSourceFactory(youTubeRepository,
                                                                    compositeDisposable);
        initializePaging();
    }

    private void initializePaging() {
        PagedList.Config pagedListConfig =
                new PagedList.Config.Builder().setEnablePlaceholders(true).setInitialLoadSizeHint(
                        YouTubeRepository.MAX_RESULTS).setPageSize(YouTubeRepository.MAX_RESULTS)
                                              .build();

        listLiveData = new LivePagedListBuilder<>(videoListDataSourceFactory,
                                                  pagedListConfig).build();

        progressLoadStatus =
                Transformations.switchMap(videoListDataSourceFactory.getMutableLiveData(),
                                          VideoListDataSourceClass::getProgressLiveStatus);
    }

    public LiveData<String> getProgressLoadStatus() {
        return progressLoadStatus;
    }

    public LiveData<PagedList<VideoListItem>> getListLiveData() {
        return listLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
