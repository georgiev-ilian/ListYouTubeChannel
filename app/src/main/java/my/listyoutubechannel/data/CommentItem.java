package my.listyoutubechannel.data;

/**
 * Created by ilian.
 */
public final class CommentItem {

    private String authorDisplayName;

    private String textDisplay;

    private String publishedAt;

    public CommentItem(String authorDisplayName, String textDisplay, String publishedAt) {
        this.authorDisplayName = authorDisplayName;
        this.textDisplay = textDisplay;
        this.publishedAt = publishedAt;
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

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
