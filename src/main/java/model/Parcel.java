package model;

import java.util.List;

/**
 * Created by Ksimeo on 17.07.2014.
 */
public class Parcel<T> {
    private int count;
    private List<T> page;

    public Parcel(List<T> page, int count) {
        this.page = page;
        this.count = count;
    }

    public List<T> getPage() {
        return page;
    }

    public int getCount() {
        return count;
    }
}
