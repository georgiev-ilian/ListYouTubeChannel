package my.listyoutubechannel.data.service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class ChannelVideosResponse {

    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("etag")
    @Expose
    private String etag;

    @SerializedName("nextPageToken")
    @Expose
    private String nextPageToken;

    @SerializedName("prevPageToken")
    @Expose
    private String prevPageToken;

    @SerializedName("regionCode")
    @Expose
    private String regionCode;

    @SerializedName("pageInfo")
    @Expose
    private PageInfo pageInfo;

    @SerializedName("items")
    @Expose
    private List<Item> items = new ArrayList<Item>();

    /**
     * No args constructor for use in serialization
     */
    public ChannelVideosResponse() {
    }

    /**
     * @param regionCode
     * @param etag
     * @param items
     * @param pageInfo
     * @param nextPageToken
     * @param kind
     */
    public ChannelVideosResponse(String kind,
                                 String etag,
                                 String nextPageToken,
                                 String regionCode,
                                 PageInfo pageInfo,
                                 List<Item> items) {
        this(kind, etag, nextPageToken, null, regionCode, pageInfo, items);
    }

    /**
     * @param regionCode
     * @param etag
     * @param items
     * @param pageInfo
     * @param nextPageToken
     * @param kind
     */
    public ChannelVideosResponse(String kind,
                                 String etag,
                                 String nextPageToken,
                                 String prevPageToken,
                                 String regionCode,
                                 PageInfo pageInfo,
                                 List<Item> items) {
        super();
        this.kind = kind;
        this.etag = etag;
        this.nextPageToken = nextPageToken;
        this.prevPageToken = prevPageToken;
        this.regionCode = regionCode;
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

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public String getPrevPageToken() {
        return prevPageToken;
    }

    public void setPrevPageToken(String prevPageToken) {
        this.prevPageToken = prevPageToken;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
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
        return new HashCodeBuilder().append(regionCode)
                                    .append(etag)
                                    .append(items)
                                    .append(pageInfo)
                                    .append(nextPageToken)
                                    .append(kind)
                                    .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ChannelVideosResponse) == false) {
            return false;
        }
        ChannelVideosResponse rhs = ((ChannelVideosResponse) other);
        return new EqualsBuilder().append(regionCode, rhs.regionCode)
                                  .append(etag, rhs.etag)
                                  .append(items,
                                          rhs.items)
                                  .append(pageInfo, rhs.pageInfo)
                                  .append(nextPageToken, rhs.nextPageToken)
                                  .append(kind, rhs.kind)
                                  .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("kind", kind).append("etag", etag).append(
                "nextPageToken",
                nextPageToken).append("regionCode", regionCode).append("pageInfo", pageInfo).append(
                "items",
                items).toString();
    }

}
