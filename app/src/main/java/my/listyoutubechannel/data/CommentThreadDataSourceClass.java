package my.listyoutubechannel.data;

import android.annotation.SuppressLint;
import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import my.listyoutubechannel.data.service.comment.CommentThreadResponse;
import my.listyoutubechannel.data.service.comment.Item;
import my.listyoutubechannel.data.service.comment.TopLevelComment;

/**
 * Created by ilian.
 */
public class CommentThreadDataSourceClass extends PageKeyedDataSource<String, CommentItem> {

    private final String videoId;

    private YouTubeRepository repository;

    private MutableLiveData<String> progressLiveStatus;

    private CompositeDisposable compositeDisposable;

    CommentThreadDataSourceClass(YouTubeRepository repository,
                                 CompositeDisposable compositeDisposable,
                                 String videoId) {
        this.repository = repository;
        this.compositeDisposable = compositeDisposable;
        this.videoId = videoId;

        progressLiveStatus = new MutableLiveData<>();
    }

    public MutableLiveData<String> getProgressLiveStatus() {
        return progressLiveStatus;
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadInitial(@NonNull LoadInitialParams<String> params,
                            @NonNull LoadInitialCallback<String, CommentItem> callback) {

        repository.getCommentThread(videoId, null).doOnSubscribe(disposable -> {
            compositeDisposable.add(disposable);
            progressLiveStatus.postValue(Constants.LOADING);
        }).subscribe((CommentThreadResponse result) -> {
            progressLiveStatus.postValue(Constants.LOADED);

            List<CommentItem> list = getCommentItems(result);

            callback.onResult(list, null, result.getNextPageToken());
        }, throwable -> progressLiveStatus.postValue(Constants.LOADED));

    }

    @Override
    public void loadBefore(@NonNull LoadParams<String> params,
                           @NonNull LoadCallback<String, CommentItem> callback) {

    }

    @SuppressLint("CheckResult")
    @Override
    public void loadAfter(@NonNull LoadParams<String> params,
                          @NonNull LoadCallback<String, CommentItem> callback) {

        repository.getCommentThread(videoId, params.key).doOnSubscribe(disposable -> {
            compositeDisposable.add(disposable);
            progressLiveStatus.postValue(Constants.LOADING);
        }).subscribe((CommentThreadResponse result) -> {
            progressLiveStatus.postValue(Constants.LOADED);

            List<CommentItem> list = getCommentItems(result);

            callback.onResult(list, result.getNextPageToken());

        }, throwable -> progressLiveStatus.postValue(Constants.LOADED));
    }

    @NonNull
    private List<CommentItem> getCommentItems(CommentThreadResponse result) {
        List<CommentItem> list = new ArrayList<>();

        for (Item item : result.getItems()) {
            final TopLevelComment topLevelComment = item.getSnippet().getTopLevelComment();

            String authorDisplayName = topLevelComment.getSnippet().getAuthorDisplayName();
            String textDisplay = topLevelComment.getSnippet().getTextDisplay();
            String publishedAt = topLevelComment.getSnippet().getPublishedAt();

            list.add(new CommentItem(authorDisplayName, textDisplay, publishedAt));
        }
        return list;
    }
}
