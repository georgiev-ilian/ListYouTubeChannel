package my.listyoutubechannel.data.service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PageInfo {

    @SerializedName("totalResults")
    @Expose
    private int totalResults;

    @SerializedName("resultsPerPage")
    @Expose
    private int resultsPerPage;

    /**
     * No args constructor for use in serialization
     */
    public PageInfo() {
    }

    /**
     * @param totalResults
     * @param resultsPerPage
     */
    public PageInfo(int totalResults, int resultsPerPage) {
        super();
        this.totalResults = totalResults;
        this.resultsPerPage = resultsPerPage;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getResultsPerPage() {
        return resultsPerPage;
    }

    public void setResultsPerPage(int resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(totalResults).append(resultsPerPage).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PageInfo) == false) {
            return false;
        }
        PageInfo rhs = ((PageInfo) other);
        return new EqualsBuilder().append(totalResults, rhs.totalResults)
                                  .append(resultsPerPage,
                                          rhs.resultsPerPage)
                                  .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("totalResults", totalResults).append(
                "resultsPerPage",
                resultsPerPage).toString();
    }

}
