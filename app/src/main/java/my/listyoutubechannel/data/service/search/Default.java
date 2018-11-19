package my.listyoutubechannel.data.service.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Default {

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("width")
    @Expose
    private int width;

    @SerializedName("height")
    @Expose
    private int height;

    /**
     * No args constructor for use in serialization
     */
    public Default() {
    }

    /**
     * @param height
     * @param width
     * @param url
     */
    public Default(String url, int width, int height) {
        super();
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(height).append(width).append(url).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Default) == false) {
            return false;
        }
        Default rhs = ((Default) other);
        return new EqualsBuilder().append(height, rhs.height)
                                  .append(width, rhs.width)
                                  .append(url,
                                          rhs.url)
                                  .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("url", url)
                                        .append("width", width)
                                        .append("height",
                                                height)
                                        .toString();
    }

}
