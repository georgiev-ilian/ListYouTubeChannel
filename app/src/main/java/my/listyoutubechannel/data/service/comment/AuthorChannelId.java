package my.listyoutubechannel.data.service.comment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class AuthorChannelId {

    @SerializedName("value")
    @Expose
    private String value;

    /**
     * No args constructor for use in serialization
     */
    public AuthorChannelId() {
    }

    /**
     * @param value
     */
    public AuthorChannelId(String value) {
        super();
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(value).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AuthorChannelId) == false) {
            return false;
        }
        AuthorChannelId rhs = ((AuthorChannelId) other);
        return new EqualsBuilder().append(value, rhs.value).isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("value", value).toString();
    }

}
