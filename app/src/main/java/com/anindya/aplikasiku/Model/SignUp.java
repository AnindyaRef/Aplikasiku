package com.anindya.aplikasiku.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class SignUp implements Parcelable {

    private String username;
    private String fullname;
    private String email;
    private String gender;

    public SignUp(){

    }

    public SignUp(String username, String fullname, String email, String gender) {
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    protected SignUp(Parcel in) {
        this.username = in.readString();
        this.fullname = in.readString();
        this.email = in.readString();
        this.gender = in.readString();
    }

    public static final Creator<SignUp> CREATOR = new Creator<SignUp>() {
        @Override
        public SignUp createFromParcel(Parcel source) {
            return new SignUp(source);
        }

        @Override
        public SignUp[] newArray(int size) {
            return new SignUp[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.username);
        dest.writeString(this.fullname);
        dest.writeString(this.email);
        dest.writeString(this.gender);
    }
}
