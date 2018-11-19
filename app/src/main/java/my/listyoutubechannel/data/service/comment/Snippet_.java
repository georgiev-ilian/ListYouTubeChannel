package my.listyoutubechannel.data.service.comment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Snippet_ {

    @SerializedName("authorDisplayName")
    @Expose
    private String authorDisplayName;

    @SerializedName("authorProfileImageUrl")
    @Expose
    private String authorProfileImageUrl;

    @SerializedName("authorChannelUrl")
    @Expose
    private String authorChannelUrl;

    @SerializedName("authorChannelId")
    @Expose
    private AuthorChannelId authorChannelId;

    @SerializedName("videoId")
    @Expose
    private String videoId;

    @SerializedName("textDisplay")
    @Expose
    private String textDisplay;

    @SerializedName("textOriginal")
    @Expose
    private String textOriginal;

    @SerializedName("canRate")
    @Expose
    private boolean canRate;

    @SerializedName("viewerRating")
    @Expose
    private String viewerRating;

    @SerializedName("likeCount")
    @Expose
    private int likeCount;

    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;

    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    @SerializedName("moderationStatus")
    @Expose
    private String moderationStatus;

    /**
     * No args constructor for use in serialization
     */
    public Snippet_() {
    }

    /**
     * @param moderationStatus
     * @param viewerRating
     * @param canRate
     * @param authorChannelId
     * @param likeCount
     * @param textDisplay
     * @param authorChannelUrl
     * @param publishedAt
     * @param updatedAt
     * @param textOriginal
     * @param authorProfileImageUrl
     * @param videoId
     * @param authorDisplayName
     */
    public Snippet_(String authorDisplayName,
                    String authorProfileImageUrl,
                    String authorChannelUrl,
                    AuthorChannelId authorChannelId,
                    String videoId,
                    String textDisplay,
                    String textOriginal,
                    boolean canRate,
                    String viewerRating,
                    int likeCount,
                    String publishedAt,
                    String updatedAt,
                    String moderationStatus) {
        super();
        this.authorDisplayName = authorDisplayName;
        this.authorProfileImageUrl = authorProfileImageUrl;
        this.authorChannelUrl = authorChannelUrl;
        this.authorChannelId = authorChannelId;
        this.videoId = videoId;
        this.textDisplay = textDisplay;
        this.textOriginal = textOriginal;
        this.canRate = canRate;
        this.viewerRating = viewerRating;
        this.likeCount = likeCount;
        this.publishedAt = publishedAt;
        this.updatedAt = updatedAt;
        this.moderationStatus = moderationStatus;
    }

    public String getAuthorDisplayName() {
        return authorDisplayName;
    }

    public void setAuthorDisplayName(String authorDisplayName) {
        this.authorDisplayName = authorDisplayName;
    }

    public String getAuthorProfileImageUrl() {
        return authorProfileImageUrl;
    }

    public void setAuthorProfileImageUrl(String authorProfileImageUrl) {
        this.authorProfileImageUrl = authorProfileImageUrl;
    }

    public String getAuthorChannelUrl() {
        return authorChannelUrl;
    }

    public void setAuthorChannelUrl(String authorChannelUrl) {
        this.authorChannelUrl = authorChannelUrl;
    }

    public AuthorChannelId getAuthorChannelId() {
        return authorChannelId;
    }

    public void setAuthorChannelId(AuthorChannelId authorChannelId) {
        this.authorChannelId = authorChannelId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getTextDisplay() {
        return textDisplay;
    }

    public void setTextDisplay(String textDisplay) {
        this.textDisplay = textDisplay;
    }

    public String getTextOriginal() {
        return textOriginal;
    }

    public void setTextOriginal(String textOriginal) {
        this.textOriginal = textOriginal;
    }

    public boolean isCanRate() {
        return canRate;
    }

    public void setCanRate(boolean canRate) {
        this.canRate = canRate;
    }

    public String getViewerRating() {
        return viewerRating;
    }

    public void setViewerRating(String viewerRating) {
        this.viewerRating = viewerRating;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getModerationStatus() {
        return moderationStatus;
    }

    public void setModerationStatus(String moderationStatus) {
        this.moderationStatus = moderationStatus;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(moderationStatus)
                                    .append(viewerRating)
                                    .append(canRate)
                                    .append(authorChannelId)
                                    .append(likeCount)
                                    .append(textDisplay)
                                    .append(authorChannelUrl)
                                    .append(updatedAt)
                                    .append(publishedAt)
                                    .append(textOriginal)
                                    .append(videoId)
                                    .append(authorProfileImageUrl)
                                    .append(authorDisplayName)
                                    .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Snippet_) == false) {
            return false;
        }
        Snippet_ rhs = ((Snippet_) other);
        return new EqualsBuilder().append(moderationStatus, rhs.moderationStatus)
                                  .append(viewerRating,
                                          rhs.viewerRating)
                                  .append(canRate, rhs.canRate)
                                  .append(authorChannelId,
                                          rhs.authorChannelId)
                                  .append(likeCount,
                                          rhs.likeCount)
                                  .append(textDisplay, rhs.textDisplay)
                                  .append(authorChannelUrl,
                                          rhs.authorChannelUrl)
                                  .append(updatedAt, rhs.updatedAt)
                                  .append(publishedAt, rhs.publishedAt)
                                  .append(textOriginal, rhs.textOriginal)
                                  .append(videoId, rhs.videoId)
                                  .append(authorProfileImageUrl, rhs.authorProfileImageUrl)
                                  .append(authorDisplayName, rhs.authorDisplayName)
                                  .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("authorDisplayName", authorDisplayName)
                                        .append("authorProfileImageUrl",
                                                authorProfileImageUrl)
                                        .append("authorChannelUrl", authorChannelUrl)
                                        .append("authorChannelId",
                                                authorChannelId)
                                        .append("videoId", videoId)
                                        .append("textDisplay", textDisplay)
                                        .append("textOriginal", textOriginal)
                                        .append("canRate", canRate)
                                        .append("viewerRating", viewerRating)
                                        .append("likeCount", likeCount)
                                        .append("publishedAt", publishedAt)
                                        .append("updatedAt", updatedAt)
                                        .append("moderationStatus", moderationStatus)
                                        .toString();
    }

}
