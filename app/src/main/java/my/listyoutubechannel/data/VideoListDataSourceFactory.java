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

    private VideoRepository videoRepository;

    private CompositeDisposable compositeDisposable;

    public VideoListDataSourceFactory(YouTubeRepository repository,
                                      CompositeDisposable compositeDisposable,
                                      VideoRepository videoRepository) {
        this.repository = repository;
        this.compositeDisposable = compositeDisposable;
        this.videoRepository = videoRepository;
        liveData = new MutableLiveData<>();
    }

    public MutableLiveData<VideoListDataSourceClass> getMutableLiveData() {
        return liveData;
    }

    @Override
    public DataSource<String, VideoListItem> create() {
        VideoListDataSourceClass dataSourceClass = new VideoListDataSourceClass(repository,
                                                                                compositeDisposable,
                                                                                videoRepository);
        liveData.postValue(dataSourceClass);
        return dataSourceClass;
    }
}
