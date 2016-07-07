package com.pablo.task.record;


public class Record {
    String numerical;
    String tagFirst;
    String tagSecond;
    String tagThird;

    public Record(String numerical, String tagFirst, String tagSecond, String tagThird) {
        this.numerical = numerical;
        this.tagFirst = tagFirst;
        this.tagSecond = tagSecond;
        this.tagThird = tagThird;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("");
        res.append("Record{");
        res.append("numerical='");
        res.append(numerical);
        res.append('\'');
        res.append(", tagFirst='");
        res.append(tagFirst);
        res.append('\'');
        res.append(", tagSecond='");
        res.append(tagSecond);
        res.append('\'');
        res.append(", tagThird='");
        res.append(tagThird);
        res.append('\'' + '}');
        return res.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        if (numerical != null ? !numerical.equals(record.numerical) : record.numerical != null) return false;
        if (tagFirst != null ? !tagFirst.equals(record.tagFirst) : record.tagFirst != null) return false;
        if (tagSecond != null ? !tagSecond.equals(record.tagSecond) : record.tagSecond != null) return false;
        return tagThird != null ? tagThird.equals(record.tagThird) : record.tagThird == null;

    }

    @Override
    public int hashCode() {
        int result = numerical != null ? numerical.hashCode() : 0;
        result = 31 * result + (tagFirst != null ? tagFirst.hashCode() : 0);
        result = 31 * result + (tagSecond != null ? tagSecond.hashCode() : 0);
        result = 31 * result + (tagThird != null ? tagThird.hashCode() : 0);
        return result;
    }

    public String getNumerical() {

        return numerical;
    }

    public void setNumerical(String numerical) {
        this.numerical = numerical;
    }

    public String getTagFirst() {
        return tagFirst;
    }

    public void setTagFirst(String tagFirst) {
        this.tagFirst = tagFirst;
    }

    public String getTagSecond() {
        return tagSecond;
    }

    public void setTagSecond(String tagSecond) {
        this.tagSecond = tagSecond;
    }

    public String getTagThird() {
        return tagThird;
    }

    public void setTagThird(String tagThird) {
        this.tagThird = tagThird;
    }
}
