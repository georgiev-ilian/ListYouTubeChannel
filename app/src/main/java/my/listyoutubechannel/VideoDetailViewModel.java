package my.listyoutubechannel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import io.reactivex.disposables.CompositeDisposable;
import my.listyoutubechannel.data.CommentItem;
import my.listyoutubechannel.data.CommentThreadDataSourceClass;
import my.listyoutubechannel.data.CommentThreadDataSourceFactory;
import my.listyoutubechannel.data.VideoDetail;
import my.listyoutubechannel.data.VideoRepository;
import my.listyoutubechannel.data.YouTubeRepository;
import my.listyoutubechannel.util.InjectorUtils;

/**
 * Created by ilian.
 */
public class VideoDetailViewModel extends ViewModel {

    private final YouTubeRepository youTubeRepository;

    private final VideoRepository videoRepository;

    private LiveData<VideoDetail> videoDetail;

    private LiveData<PagedList<CommentItem>> listLiveData;

    private CommentThreadDataSourceFactory commentThreadDataSourceFactory;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private LiveData<String> progressLoadStatus = new MutableLiveData<>();

    public VideoDetailViewModel(YouTubeRepository youTubeRepository,
                                VideoRepository videoRepository, String videoId) {
        this.videoRepository = videoRepository;
        this.youTubeRepository = youTubeRepository;
        this.videoDetail = videoRepository.getVideoDetail(youTubeRepository, videoId);

        commentThreadDataSourceFactory = new CommentThreadDataSourceFactory(youTubeRepository,
                                                                            compositeDisposable,
                                                                            videoId);
        initializePaging();
    }

    private void initializePaging() {
        PagedList.Config pagedListConfig = InjectorUtils.providePagedListConfig();

        listLiveData = new LivePagedListBuilder<>(commentThreadDataSourceFactory,
                                                  pagedListConfig).build();

        progressLoadStatus =
                Transformations.switchMap(commentThreadDataSourceFactory.getMutableLiveData(),
                                          CommentThreadDataSourceClass::getProgressLiveStatus);
    }

    public LiveData<String> getProgressLoadStatus() {
        return progressLoadStatus;
    }

    public LiveData<PagedList<CommentItem>> getListLiveData() {
        return listLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }

    public LiveData<VideoDetail> getVideoDetail() {
        return videoDetail;
    }
}
