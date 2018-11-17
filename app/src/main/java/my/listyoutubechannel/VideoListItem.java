package my.listyoutubechannel;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by ilian.
 */
public class VideoListItem {

    private String title;

    private String url;

    VideoListItem(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    @SuppressWarnings("unused")
    public void setUrl(String url) {
        this.url = url;
    }

    @BindingAdapter("imageFromUrl")
    public static void imageFromUrl(ImageView view, String imageUrl) {
        if (imageUrl != null && !imageUrl.isEmpty()) {
            Glide.with(view.getContext()).load(imageUrl).into(view);
        }
    }
}
