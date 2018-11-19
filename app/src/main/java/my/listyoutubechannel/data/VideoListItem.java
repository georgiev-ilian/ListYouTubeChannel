package my.listyoutubechannel.data;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by ilian.
 */
public final class VideoListItem {

    private String id;

    private String title;

    private String thumbnailUrl;

    public VideoListItem(String id, String title, String thumbnailUrl) {
        this.id = id;
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    @SuppressWarnings("unused")
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @BindingAdapter("imageFromUrl")
    public static void imageFromUrl(ImageView view, String imageUrl) {
        if (imageUrl != null && !imageUrl.isEmpty()) {
            Glide.with(view.getContext()).load(imageUrl).into(view);
        }
    }

    public static DiffUtil.ItemCallback<VideoListItem> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<VideoListItem>() {
                @Override
                public boolean areItemsTheSame(@NonNull VideoListItem oldItem,
                                               @NonNull VideoListItem newItem) {
                    return oldItem.id.equals(newItem.id);
                }

                @Override
                public boolean areContentsTheSame(@NonNull VideoListItem oldItem,
                                                  @NonNull VideoListItem newItem) {
                    return oldItem.equals(newItem);
                }
            };

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof VideoListItem)) {
            return false;
        }

        VideoListItem article = (VideoListItem) obj;
        return article.id.equals(this.id);
    }

    @Override
    public int hashCode() {
        int hashValue = 11;

        hashValue = 31 * hashValue + this.id.hashCode();

        return hashValue;
    }
}
