package com.anindya.aplikasiku.Model;

import java.util.List;

public class Account {
    private List<Stuff> stuffs;

    public Account(List<Stuff> stuffs) {
        this.stuffs = stuffs;
    }

    public List<Stuff> getStuffs() {
        return stuffs;
    }

    public void addStuff(Stuff stuff){
        stuff.getNameStuff();
        this.stuffs.add(stuff);
    }
    public void removeStuff(int index){
        Stuff stuff = stuffs.get(index);
        stuff.getNameStuff();
        this.stuffs.remove(stuff);
    }
    public void updateStuff(int index, Stuff stuff){
        this.stuffs.set(index, stuff);
    }
}
