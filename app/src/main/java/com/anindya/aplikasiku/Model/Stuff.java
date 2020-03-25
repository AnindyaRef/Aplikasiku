package com.anindya.aplikasiku.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Stuff implements Parcelable {

    private String nameStuff;

    public Stuff(){

    }

    public Stuff(String nameStuff) {
        this.nameStuff = nameStuff;
    }

    public String getNameStuff() {

        return nameStuff;
    }

    public void setNameStuff(String nameStuff) {

        this.nameStuff = nameStuff;
    }

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nameStuff);
    }

    protected Stuff(Parcel in) {
        this.nameStuff = in.readString();
    }

    public static final Creator<Stuff> CREATOR = new Creator<Stuff>() {
        @Override
        public Stuff createFromParcel(Parcel source) {
            return new Stuff(source);
        }

        @Override
        public Stuff[] newArray(int size) {
            return new Stuff[size];
        }
    };

}
