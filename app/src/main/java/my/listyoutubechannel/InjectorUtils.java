package my.listyoutubechannel;

/**
 * Created by ilian.
 */
public final class InjectorUtils {

    public static VideoListViewModelFactory provideVideoListViewModelFactory() {
        YouTubeRepository repository = new YouTubeRepository();
        return new VideoListViewModelFactory(repository);
    }
}
