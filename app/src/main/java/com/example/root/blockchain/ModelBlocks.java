package com.example.root.blockchain;

public class ModelBlocks {
    private String data;
    private String hash;
    private String prevhash;
    private String timestamp;


    public ModelBlocks(String data, String hash, String prevhash, String timestamp) {
        this.data = data;
        this.hash = hash;
        this.prevhash = prevhash;
        this.timestamp = timestamp;
    }



    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPrevhash() {
        return prevhash;
    }

    public void setPrevhash(String prevhash) {
        this.prevhash = prevhash;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


}
