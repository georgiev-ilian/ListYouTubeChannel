package my.listyoutubechannel.data;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by ilian.
 */
public class VideoListDataSourceFactory extends DataSource.Factory<String, VideoListItem> {

    private MutableLiveData<VideoListDataSourceClass> liveData;

    private YouTubeRepository repository;

    private CompositeDisposable compositeDisposable;

    public VideoListDataSourceFactory(YouTubeRepository repository,
                                      CompositeDisposable compositeDisposable) {
        this.repository = repository;
        this.compositeDisposable = compositeDisposable;
        liveData = new MutableLiveData<>();
    }

    public MutableLiveData<VideoListDataSourceClass> getMutableLiveData() {
        return liveData;
    }

    @Override
    public DataSource<String, VideoListItem> create() {
        VideoListDataSourceClass dataSourceClass = new VideoListDataSourceClass(repository,
                                                                                compositeDisposable);
        liveData.postValue(dataSourceClass);
        return dataSourceClass;
    }
}
