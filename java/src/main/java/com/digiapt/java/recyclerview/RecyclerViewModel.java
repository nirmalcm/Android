package com.digiapt.java.recyclerview;

public class RecyclerViewModel {

    private String id;

    RecyclerViewModel(String id){
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
