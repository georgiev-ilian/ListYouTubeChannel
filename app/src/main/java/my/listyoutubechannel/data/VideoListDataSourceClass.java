package my.listyoutubechannel.data;

import android.annotation.SuppressLint;
import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import my.listyoutubechannel.data.service.ChannelVideosResponse;
import my.listyoutubechannel.data.service.Item;

/**
 * Created by ilian.
 */
public class VideoListDataSourceClass extends PageKeyedDataSource<String, VideoListItem> {

    private YouTubeRepository repository;

    private MutableLiveData<String> progressLiveStatus;

    private CompositeDisposable compositeDisposable;

    VideoListDataSourceClass(YouTubeRepository repository,
                             CompositeDisposable compositeDisposable) {
        this.repository = repository;
        this.compositeDisposable = compositeDisposable;
        progressLiveStatus = new MutableLiveData<>();
    }

    public MutableLiveData<String> getProgressLiveStatus() {
        return progressLiveStatus;
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadInitial(@NonNull LoadInitialParams<String> params,
                            @NonNull LoadInitialCallback<String, VideoListItem> callback) {

        repository.getChannelVideos(null).doOnSubscribe(disposable -> {
            compositeDisposable.add(disposable);
            progressLiveStatus.postValue(Constants.LOADING);
        }).subscribe((ChannelVideosResponse result) -> {
            progressLiveStatus.postValue(Constants.LOADED);

            List<VideoListItem> list = new ArrayList<>();

            for (Item item : result.getItems()) {
                String videoId = item.getId().getVideoId();
                final String title = item.getSnippet().getTitle();

                final String thumbnailUrl = item.getSnippet().getThumbnails().getMedium().getUrl();

                list.add(new VideoListItem(videoId, title, thumbnailUrl));

                VideoDetail videoDetail = new VideoDetail(videoId,
                                                          title,
                                                          thumbnailUrl,
                                                          item.getSnippet().getPublishedAt(),
                                                          item.getSnippet().getDescription());
                //videoDetailMap.put(videoId, videoDetail);
            }

            callback.onResult(list, null, result.getNextPageToken());
        }, throwable -> progressLiveStatus.postValue(Constants.LOADED));

    }

    @Override
    public void loadBefore(@NonNull LoadParams<String> params,
                           @NonNull LoadCallback<String, VideoListItem> callback) {

    }

    @SuppressLint("CheckResult")
    @Override
    public void loadAfter(@NonNull LoadParams<String> params,
                          @NonNull LoadCallback<String, VideoListItem> callback) {

        repository.getChannelVideos(params.key).doOnSubscribe(disposable -> {
            compositeDisposable.add(disposable);
            progressLiveStatus.postValue(Constants.LOADING);
        }).subscribe((ChannelVideosResponse result) -> {
            progressLiveStatus.postValue(Constants.LOADED);

            List<VideoListItem> list = new ArrayList<>();

            for (Item item : result.getItems()) {
                String videoId = item.getId().getVideoId();
                final String title = item.getSnippet().getTitle();

                final String thumbnailUrl = item.getSnippet().getThumbnails().getMedium().getUrl();

                list.add(new VideoListItem(videoId, title, thumbnailUrl));

                VideoDetail videoDetail = new VideoDetail(videoId,
                                                          title,
                                                          thumbnailUrl,
                                                          item.getSnippet().getPublishedAt(),
                                                          item.getSnippet().getDescription());
                //videoDetailMap.put(videoId, videoDetail);
            }

            callback.onResult(list, result.getNextPageToken());

        }, throwable -> progressLiveStatus.postValue(Constants.LOADED));
    }
}