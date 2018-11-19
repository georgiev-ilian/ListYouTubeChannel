package my.listyoutubechannel.data.service.video;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ContentDetails {

    @SerializedName("duration")
    @Expose
    private String duration;

    @SerializedName("dimension")
    @Expose
    private String dimension;

    @SerializedName("definition")
    @Expose
    private String definition;

    @SerializedName("caption")
    @Expose
    private String caption;

    @SerializedName("licensedContent")
    @Expose
    private boolean licensedContent;

    @SerializedName("projection")
    @Expose
    private String projection;

    /**
     * No args constructor for use in serialization
     */
    public ContentDetails() {
    }

    /**
     * @param dimension
     * @param duration
     * @param licensedContent
     * @param definition
     * @param projection
     * @param caption
     */
    public ContentDetails(String duration,
                          String dimension,
                          String definition,
                          String caption,
                          boolean licensedContent,
                          String projection) {
        super();
        this.duration = duration;
        this.dimension = dimension;
        this.definition = definition;
        this.caption = caption;
        this.licensedContent = licensedContent;
        this.projection = projection;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public boolean isLicensedContent() {
        return licensedContent;
    }

    public void setLicensedContent(boolean licensedContent) {
        this.licensedContent = licensedContent;
    }

    public String getProjection() {
        return projection;
    }

    public void setProjection(String projection) {
        this.projection = projection;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(dimension)
                                    .append(duration)
                                    .append(licensedContent)
                                    .append(definition)
                                    .append(projection)
                                    .append(caption)
                                    .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ContentDetails) == false) {
            return false;
        }
        ContentDetails rhs = ((ContentDetails) other);
        return new EqualsBuilder().append(dimension, rhs.dimension)
                                  .append(duration, rhs.duration)
                                  .append(licensedContent, rhs.licensedContent)
                                  .append(definition, rhs.definition)
                                  .append(projection, rhs.projection)
                                  .append(caption, rhs.caption)
                                  .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("duration", duration)
                                        .append("dimension", dimension)
                                        .append("definition", definition)
                                        .append("caption", caption)
                                        .append("licensedContent", licensedContent)
                                        .append("projection", projection)
                                        .toString();
    }

}
