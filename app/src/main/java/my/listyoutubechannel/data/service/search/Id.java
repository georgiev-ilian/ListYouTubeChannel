package my.listyoutubechannel.data.service.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Id {

    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("videoId")
    @Expose
    private String videoId;

    /**
     * No args constructor for use in serialization
     */
    public Id() {
    }

    /**
     * @param videoId
     * @param kind
     */
    public Id(String kind, String videoId) {
        super();
        this.kind = kind;
        this.videoId = videoId;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(videoId).append(kind).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Id) == false) {
            return false;
        }
        Id rhs = ((Id) other);
        return new EqualsBuilder().append(videoId, rhs.videoId).append(kind, rhs.kind).isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("kind", kind).append("videoId", videoId).toString();
    }

}
