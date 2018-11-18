package my.listyoutubechannel.data.service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Thumbnails {

    @SerializedName("default")
    @Expose
    private Default _default;

    @SerializedName("medium")
    @Expose
    private Medium medium;

    @SerializedName("high")
    @Expose
    private High high;

    /**
     * No args constructor for use in serialization
     */
    public Thumbnails() {
    }

    /**
     * @param _default
     * @param high
     * @param medium
     */
    public Thumbnails(Default _default, Medium medium, High high) {
        super();
        this._default = _default;
        this.medium = medium;
        this.high = high;
    }

    public Default getDefault() {
        return _default;
    }

    public void setDefault(Default _default) {
        this._default = _default;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public High getHigh() {
        return high;
    }

    public void setHigh(High high) {
        this.high = high;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(_default).append(high).append(medium).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Thumbnails) == false) {
            return false;
        }
        Thumbnails rhs = ((Thumbnails) other);
        return new EqualsBuilder().append(_default, rhs._default).append(high, rhs.high).append(
                medium,
                rhs.medium).isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("_default", _default)
                                        .append("medium", medium)
                                        .append("high", high)
                                        .toString();
    }

}
