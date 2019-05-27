package by.bobrov.gram.util;

import java.util.*;

public class FilterConfig {
    private Date fromDate, toDate;
    private List<String> authors;
    private List<String> hashTags;

    public FilterConfig() {
        fromDate = null;
        toDate = null;
        this.authors = null;
        this.hashTags = null;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(final List<String> authors) {
        this.authors = authors;
    }

    public List<String> getHashTags() {
        return hashTags;
    }

    public void setHashTags(final List<String> hashTags) {
        this.hashTags = hashTags;
    }

    public Date getFromDate() {
        return fromDate;
    }
    public void setFromDate(Date newFromDate) {
        this.fromDate = newFromDate;
    }
    public Date getToDate() {
        return toDate;
    }
    public void setToDate(Date newToDate) {
        this.toDate = newToDate;
    }
}
