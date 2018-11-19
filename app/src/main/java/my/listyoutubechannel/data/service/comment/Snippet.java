package my.listyoutubechannel.data.service.comment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Snippet {

    @SerializedName("videoId")
    @Expose
    private String videoId;

    @SerializedName("topLevelComment")
    @Expose
    private TopLevelComment topLevelComment;

    @SerializedName("canReply")
    @Expose
    private boolean canReply;

    @SerializedName("totalReplyCount")
    @Expose
    private int totalReplyCount;

    @SerializedName("isPublic")
    @Expose
    private boolean isPublic;

    /**
     * No args constructor for use in serialization
     */
    public Snippet() {
    }

    /**
     * @param canReply
     * @param topLevelComment
     * @param totalReplyCount
     * @param videoId
     * @param isPublic
     */
    public Snippet(String videoId,
                   TopLevelComment topLevelComment,
                   boolean canReply,
                   int totalReplyCount,
                   boolean isPublic) {
        super();
        this.videoId = videoId;
        this.topLevelComment = topLevelComment;
        this.canReply = canReply;
        this.totalReplyCount = totalReplyCount;
        this.isPublic = isPublic;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public TopLevelComment getTopLevelComment() {
        return topLevelComment;
    }

    public void setTopLevelComment(TopLevelComment topLevelComment) {
        this.topLevelComment = topLevelComment;
    }

    public boolean isCanReply() {
        return canReply;
    }

    public void setCanReply(boolean canReply) {
        this.canReply = canReply;
    }

    public int getTotalReplyCount() {
        return totalReplyCount;
    }

    public void setTotalReplyCount(int totalReplyCount) {
        this.totalReplyCount = totalReplyCount;
    }

    public boolean isIsPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(canReply)
                                    .append(topLevelComment)
                                    .append(totalReplyCount)
                                    .append(videoId)
                                    .append(isPublic)
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
        return new EqualsBuilder().append(canReply, rhs.canReply)
                                  .append(topLevelComment,
                                          rhs.topLevelComment)
                                  .append(totalReplyCount, rhs.totalReplyCount)
                                  .append(videoId, rhs.videoId)
                                  .append(isPublic, rhs.isPublic)
                                  .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("videoId", videoId)
                                        .append("topLevelComment",
                                                topLevelComment)
                                        .append("canReply",
                                                canReply)
                                        .append("totalReplyCount", totalReplyCount)
                                        .append("isPublic", isPublic)
                                        .toString();
    }

}
