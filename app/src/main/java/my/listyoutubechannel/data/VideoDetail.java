package my.listyoutubechannel.data;

/**
 * Created by ilian.
 */
public final class VideoDetail {

    private String id;

    private String title;

    private String thumbnailUrl;

    private String dataPublished;

    private String description;

    public VideoDetail(String id,
                       String title,
                       String thumbnailUrl,
                       String dataPublished,
                       String description) {
        this.id = id;
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
        this.dataPublished = dataPublished;
        this.description = description;
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

    public String getDataPublished() {
        return dataPublished;
    }

    public void setDataPublished(String dataPublished) {
        this.dataPublished = dataPublished;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
