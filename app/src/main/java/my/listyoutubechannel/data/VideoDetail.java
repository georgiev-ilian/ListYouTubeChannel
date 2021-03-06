package my.listyoutubechannel.data;

/**
 * Created by ilian.
 */
public final class VideoDetail {

    private String id;

    private String title;

    private String thumbnailUrl;

    private String datePublished;

    private String description;

    private String duration;

    public VideoDetail(String id,
                       String title,
                       String thumbnailUrl,
                       String datePublished,
                       String description,
                       String duration) {
        this.id = id;
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
        this.datePublished = datePublished;
        this.description = description;
        this.duration = duration;
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

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
