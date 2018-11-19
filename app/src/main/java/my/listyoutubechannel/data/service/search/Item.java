package my.listyoutubechannel.data.service.search;

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
    private Id id;

    @SerializedName("snippet")
    @Expose
    private Snippet snippet;

    /**
     * No args constructor for use in serialization
     */
    public Item() {
    }

    /**
     * @param id
     * @param etag
     * @param snippet
     * @param kind
     */
    public Item(String kind, String etag, Id id, Snippet snippet) {
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

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
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
        if ((other instanceof Item) == false) {
            return false;
        }
        Item rhs = ((Item) other);
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
