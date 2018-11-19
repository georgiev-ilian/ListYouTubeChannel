package my.listyoutubechannel.data.service.comment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class TopLevelComment {

    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("etag")
    @Expose
    private String etag;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("snippet")
    @Expose
    private Snippet_ snippet;

    /**
     * No args constructor for use in serialization
     */
    public TopLevelComment() {
    }

    /**
     * @param id
     * @param etag
     * @param snippet
     * @param kind
     */
    public TopLevelComment(String kind, String etag, String id, Snippet_ snippet) {
        super();
        this.kind = kind;
        this.etag = etag;
        this.id = id;
        this.snippet = snippet;
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

    public Snippet_ getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet_ snippet) {
        this.snippet = snippet;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id)
                                    .append(etag)
                                    .append(snippet)
                                    .append(kind)
                                    .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TopLevelComment) == false) {
            return false;
        }
        TopLevelComment rhs = ((TopLevelComment) other);
        return new EqualsBuilder().append(id, rhs.id)
                                  .append(etag, rhs.etag)
                                  .append(snippet,
                                          rhs.snippet)
                                  .append(kind, rhs.kind)
                                  .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("kind", kind)
                                        .append("etag", etag)
                                        .append("id", id)
                                        .append("snippet", snippet)
                                        .toString();
    }

}
