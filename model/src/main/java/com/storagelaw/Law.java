package com.storagelaw;

import javax.persistence.*;


@Entity
public class Law {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO  )
    Long lawId;
    private String lawType;
    private String lawName;
    private int lawNumber;

    public Law(){

    }

    public Law(String lawType, String lawName, int lawNumber){
        this.lawType = lawType;
        this.lawName = lawName;
        this.lawNumber = lawNumber;
    }

    public Long getLawId() {return lawId;}

    public void setLawId(Long lawId) {this.lawId = lawId;}

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
