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
import my.listyoutubechannel.data.VideoRepository;
import my.listyoutubechannel.data.YouTubeRepository;
import my.listyoutubechannel.util.InjectorUtils;

/**
 * Created by ilian.
 */
public class VideoListViewModel extends ViewModel {

    private LiveData<PagedList<VideoListItem>> listLiveData;

    private VideoListDataSourceFactory videoListDataSourceFactory;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private LiveData<String> progressLoadStatus = new MutableLiveData<>();

    public VideoListViewModel(@NonNull YouTubeRepository youTubeRepository,
                              @NonNull VideoRepository videoRepository) {
        videoListDataSourceFactory = new VideoListDataSourceFactory(youTubeRepository,
                                                                    compositeDisposable,
                                                                    videoRepository);
        initializePaging();
    }

    private void initializePaging() {
        PagedList.Config pagedListConfig = InjectorUtils.providePagedListConfig();

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
