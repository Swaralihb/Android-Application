package com.example.project.MedicalStore;

public class MedicalStoreObject {
    public String NameM;
    public String AddressM;
    public String ContactM;
    public String coordinate1;
    public String coordinate2;

    public MedicalStoreObject() {

    }
    public void getAll(String n, String a,String c) {
        this.NameM=n;
        this.AddressM=a;
        this.ContactM=c;

    }


    public void getCoordinates(String c1,String c2) {
        this.coordinate1=c1;
        this.coordinate2=c2;


    }

    //custom toString()
    @Override
    public String toString() {
        return NameM+"\n\n"+AddressM+"\n\n"+ContactM;

    }
}
