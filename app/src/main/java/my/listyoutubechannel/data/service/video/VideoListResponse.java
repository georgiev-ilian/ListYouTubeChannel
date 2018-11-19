package my.listyoutubechannel.data.service.video;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class VideoListResponse {

    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("etag")
    @Expose
    private String etag;

    @SerializedName("pageInfo")
    @Expose
    private PageInfo pageInfo;

    @SerializedName("items")
    @Expose
    private List<Item> items = new ArrayList<Item>();

    /**
     * No args constructor for use in serialization
     */
    public VideoListResponse() {
    }

    /**
     * @param etag
     * @param items
     * @param pageInfo
     * @param kind
     */
    public VideoListResponse(String kind, String etag, PageInfo pageInfo, List<Item> items) {
        super();
        this.kind = kind;
        this.etag = etag;
        this.pageInfo = pageInfo;
        this.items = items;
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

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(etag)
                                    .append(items)
                                    .append(pageInfo)
                                    .append(kind)
                                    .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof VideoListResponse) == false) {
            return false;
        }
        VideoListResponse rhs = ((VideoListResponse) other);
        return new EqualsBuilder().append(etag, rhs.etag)
                                  .append(items, rhs.items)
                                  .append(pageInfo,
                                          rhs.pageInfo)
                                  .append(kind, rhs.kind)
                                  .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("kind", kind)
                                        .append("etag", etag)
                                        .append("pageInfo", pageInfo)
                                        .append("items", items)
                                        .toString();
    }

}
