package com.lawstorage.law;

import javax.persistence.*;


@Entity
public class Law {

    @Id
    Long lawId;
    private String lawType;
    private String lawName;
    private int lawNumber;

    public String getLawType() {
        return lawType;
    }

    public void setLawType(String lawType) {
        this.lawType = lawType;
    }

    public String getLawName() {
        return lawName;
    }

    public void setLawName(String lawName) {
        this.lawName = lawName;
    }

    public int getLawNumber() {
        return lawNumber;
    }

    public void setLawNumber(int lawNumber) {
        this.lawNumber = lawNumber;
    }

    @Override
    public String toString() {
        return "Law{" +
                "lawId=" + lawId +
                ", lawType='" + lawType + '\'' +
                ", lawName='" + lawName + '\'' +
                ", lawNumber=" + lawNumber +
                '}';
    }
}
