package my.listyoutubechannel.service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Snippet {

    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;

    @SerializedName("channelId")
    @Expose
    private String channelId;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("thumbnails")
    @Expose
    private Thumbnails thumbnails;

    @SerializedName("channelTitle")
    @Expose
    private String channelTitle;

    @SerializedName("liveBroadcastContent")
    @Expose
    private String liveBroadcastContent;

    /**
     * No args constructor for use in serialization
     */
    public Snippet() {
    }

    /**
     * @param publishedAt
     * @param title
     * @param channelId
     * @param description
     * @param channelTitle
     * @param thumbnails
     * @param liveBroadcastContent
     */
    public Snippet(String publishedAt,
                   String channelId,
                   String title,
                   String description,
                   Thumbnails thumbnails,
                   String channelTitle,
                   String liveBroadcastContent) {
        super();
        this.publishedAt = publishedAt;
        this.channelId = channelId;
        this.title = title;
        this.description = description;
        this.thumbnails = thumbnails;
        this.channelTitle = channelTitle;
        this.liveBroadcastContent = liveBroadcastContent;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(Thumbnails thumbnails) {
        this.thumbnails = thumbnails;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getLiveBroadcastContent() {
        return liveBroadcastContent;
    }

    public void setLiveBroadcastContent(String liveBroadcastContent) {
        this.liveBroadcastContent = liveBroadcastContent;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(publishedAt)
                                    .append(title)
                                    .append(channelId)
                                    .append(description)
                                    .append(channelTitle)
                                    .append(thumbnails)
                                    .append(liveBroadcastContent)
                                    .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Snippet) == false) {
            return false;
        }
        Snippet rhs = ((Snippet) other);
        return new EqualsBuilder().append(publishedAt, rhs.publishedAt)
                                  .append(title, rhs.title)
                                  .append(channelId, rhs.channelId)
                                  .append(description, rhs.description)
                                  .append(channelTitle, rhs.channelTitle)
                                  .append(thumbnails, rhs.thumbnails)
                                  .append(liveBroadcastContent, rhs.liveBroadcastContent)
                                  .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("publishedAt", publishedAt)
                                        .append("channelId",
                                                channelId)
                                        .append("title", title)
                                        .append("description", description)
                                        .append("thumbnails", thumbnails)
                                        .append("channelTitle", channelTitle)
                                        .append("liveBroadcastContent", liveBroadcastContent)
                                        .toString();
    }

}
