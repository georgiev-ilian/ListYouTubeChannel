package my.listyoutubechannel.data.service.video;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Item {

    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("etag")
    @Expose
    private String etag;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("contentDetails")
    @Expose
    private ContentDetails contentDetails;

    /**
     * No args constructor for use in serialization
     */
    public Item() {
    }

    /**
     * @param id
     * @param etag
     * @param contentDetails
     * @param kind
     */
    public Item(String kind, String etag, String id, ContentDetails contentDetails) {
        super();
        this.kind = kind;
        this.etag = etag;
        this.id = id;
        this.contentDetails = contentDetails;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ContentDetails getContentDetails() {
        return contentDetails;
    }

    public void setContentDetails(ContentDetails contentDetails) {
        this.contentDetails = contentDetails;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id)
                                    .append(etag)
                                    .append(contentDetails)
                                    .append(kind)
                                    .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Item) == false) {
            return false;
        }
        Item rhs = ((Item) other);
        return new EqualsBuilder().append(id, rhs.id)
                                  .append(etag, rhs.etag)
                                  .append(contentDetails,
                                          rhs.contentDetails)
                                  .append(kind, rhs.kind)
                                  .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("kind", kind)
                                        .append("etag", etag)
                                        .append("id", id)
                                        .append("contentDetails", contentDetails)
                                        .toString();
    }

}
