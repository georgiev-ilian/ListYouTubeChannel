package my.listyoutubechannel.util;

import my.listyoutubechannel.VideoListViewModelFactory;
import my.listyoutubechannel.data.VideoRepository;
import my.listyoutubechannel.data.YouTubeRepository;

/**
 * Created by ilian.
 */
public final class InjectorUtils {

    public static VideoListViewModelFactory provideVideoListViewModelFactory() {
        YouTubeRepository repository = YouTubeRepository.getInstance();
        VideoRepository videoRepository = VideoRepository.getInstance();

        return new VideoListViewModelFactory(repository, videoRepository);
    }
}
