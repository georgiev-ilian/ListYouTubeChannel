package my.listyoutubechannel.data.service;

import io.reactivex.Observable;
import my.listyoutubechannel.data.service.comment.CommentThreadResponse;
import my.listyoutubechannel.data.service.search.ChannelVideosResponse;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ilian.
 */
public class YouTubeService {

    // https://www.googleapis.com/youtube/v3/videos?part=snippet&id=kX_hn3Xf90g&key=AIzaSyAEV6gn8EKbAL9uQfX8XfrYG3v3vsIqEY8

    // https://www.googleapis.com/youtube/v3/videos?part=contentDetails&id=kX_hn3Xf90g&key=AIzaSyAEV6gn8EKbAL9uQfX8XfrYG3v3vsIqEY8

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
    }

    public static YouTube create() {
        RxJava2CallAdapterFactory rxAdapter = RxJava2CallAdapterFactory.create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_URL).addConverterFactory(
                GsonConverterFactory.create()).addCallAdapterFactory(rxAdapter).build();

        return retrofit.create(YouTube.class);
    }
}
