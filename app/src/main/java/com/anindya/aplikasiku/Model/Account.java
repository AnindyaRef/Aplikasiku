package com.anindya.aplikasiku.Model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private List<Stuff> stuffs;
    private List<SignUp> signUps;

    public Account(){
        this.stuffs = new ArrayList<>();
        this.signUps = new ArrayList<>();
    }

    public Account(List<Stuff> stuffs) {
        this.stuffs = new ArrayList<>();
    }

    public List<Stuff> getStuffs() {
        return stuffs;
    }

    public void addStuff(Stuff stuff){
        this.stuffs.add(stuff);
    }
    public void removeStuff(int index){
        Stuff stuff = stuffs.get(index);
        this.stuffs.remove(stuff);
    }
    public void updateStuff(int index, Stuff stuff){
        this.stuffs.set(index, stuff);
    }

    public List<SignUp> getSignUps(){
        return signUps;
    }

    public void addSignUp(SignUp signUp){
        this.signUps.add(signUp);
    }
}
