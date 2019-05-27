package by.bobrov.gram.util;

import java.util.ArrayList;
import java.util.Date;

public class FilterConfig {
    private Date fromDate;
    private Date toDate;
    private ArrayList<String> authors;
    private ArrayList<String> hashTags;

    public FilterConfig() {
        this.fromDate = null;
        this.toDate = null;
        this.authors = new ArrayList<>();
        this.hashTags = new ArrayList<>();
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public ArrayList<String> getHashTags() {
        return hashTags;
    }

    public void setHashTags(ArrayList<String> hashTags) {
        this.hashTags = hashTags;
    }
}