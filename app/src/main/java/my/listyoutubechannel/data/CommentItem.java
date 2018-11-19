package my.listyoutubechannel.data;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

/**
 * Created by ilian.
 */
public final class CommentItem {

    public static DiffUtil.ItemCallback<CommentItem> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<CommentItem>() {
                @Override
                public boolean areItemsTheSame(@NonNull CommentItem oldItem,
                                               @NonNull CommentItem newItem) {
                    return oldItem.id.equals(newItem.id);
                }

                @Override
                public boolean areContentsTheSame(@NonNull CommentItem oldItem,
                                                  @NonNull CommentItem newItem) {
                    return oldItem.equals(newItem);
                }
            };

    private String authorDisplayName;

    private String textDisplay;

    private String id;

    public CommentItem(String id, String authorDisplayName, String textDisplay) {
        this.id = id;
        this.authorDisplayName = authorDisplayName;
        this.textDisplay = textDisplay;
    }

    public String getId() {
        return id;
    }

    public String getAuthorDisplayName() {
        return authorDisplayName;
    }

    public void setAuthorDisplayName(String authorDisplayName) {
        this.authorDisplayName = authorDisplayName;
    }

    public String getTextDisplay() {
        return textDisplay;
    }

    public void setTextDisplay(String textDisplay) {
        this.textDisplay = textDisplay;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hashValue = 11;

        hashValue = 31 * hashValue + this.id.hashCode();

        return hashValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof CommentItem)) {
            return false;
        }

        CommentItem article = (CommentItem) obj;
        return article.id.equals(this.id);
    }
}
