package my.listyoutubechannel.data.service;

import io.reactivex.Observable;
import my.listyoutubechannel.data.service.comment.CommentThreadResponse;
import my.listyoutubechannel.data.service.search.ChannelVideosResponse;
import my.listyoutubechannel.data.service.video.VideoListResponse;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ilian.
 */
public class YouTubeService {

    private static final String API_URL = "https://www.googleapis.com/youtube/v3/";

    public interface YouTube {

        @GET("search?part=snippet&order=date")
        Observable<ChannelVideosResponse> getChannelVideos(@Query("channelId") String channelId,
                                                           @Query("maxResults") String maxResults,
                                                           @Query("key") String key,
                                                           @Query("pageToken") String pageToken);

        @GET("commentThreads?part=snippet")
        Observable<CommentThreadResponse> getCommentThread(@Query("videoId") String videoId,
                                                           @Query("maxResults") String maxResults,
                                                           @Query("key") String key,
                                                           @Query("pageToken") String pageToken);

        @GET("videos?part=contentDetails")
        Observable<VideoListResponse> getVideoList(@Query("id") String videoId,
                                                   @Query("key") String key);
    }

    public static YouTube create() {
        RxJava2CallAdapterFactory rxAdapter = RxJava2CallAdapterFactory.create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_URL).addConverterFactory(
                GsonConverterFactory.create()).addCallAdapterFactory(rxAdapter).build();

        return retrofit.create(YouTube.class);
    }
}
