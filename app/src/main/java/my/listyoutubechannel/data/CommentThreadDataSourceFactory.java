package my.listyoutubechannel.data;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by ilian.
 */
public class CommentThreadDataSourceFactory extends DataSource.Factory<String, CommentItem> {

    private final String videoId;

    private MutableLiveData<CommentThreadDataSourceClass> liveData;

    private YouTubeRepository repository;

    private CompositeDisposable compositeDisposable;

    public CommentThreadDataSourceFactory(YouTubeRepository repository,
                                          CompositeDisposable compositeDisposable,
                                          String videoId) {
        this.repository = repository;
        this.compositeDisposable = compositeDisposable;
        this.videoId = videoId;

        liveData = new MutableLiveData<>();
    }

    public MutableLiveData<CommentThreadDataSourceClass> getMutableLiveData() {
        return liveData;
    }

    @Override
    public DataSource<String, CommentItem> create() {
        CommentThreadDataSourceClass dataSourceClass = new CommentThreadDataSourceClass(repository,
                                                                                        compositeDisposable,
                                                                                        videoId);
        liveData.postValue(dataSourceClass);
        return dataSourceClass;
    }
}
