package com.example.project.Hospital;

public class HospitalObject {

    public String NameH;
    public String AddressH;
    public String ContactH;

    public HospitalObject() {

    }
    public void getAll(String n, String a,String c) {
        this.NameH=n;
        this.AddressH=a;
        this.ContactH=c;
    }
    //custom toString()
    @Override
    public String toString() {
        return NameH+"\n\n"+AddressH+"\n\n"+ContactH;
    }
}