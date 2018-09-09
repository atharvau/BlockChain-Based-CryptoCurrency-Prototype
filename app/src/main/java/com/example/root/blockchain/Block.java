package com.example.root.blockchain;

import com.orm.SugarRecord;

public class Block extends SugarRecord<Block> {
    int position;
    String data;
    String TimeStamp;
    int nonce;
    String hash;
    String prevHash;
    Boolean isvalid=true;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        TimeStamp = timeStamp;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPrevHash() {
        return prevHash;
    }

    public void setPrevHash(String prevHash) {
        this.prevHash = prevHash;
    }

    public Boolean getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Boolean isvalid) {
        this.isvalid = isvalid;
    }

    public Block(int position, String data, String timeStamp, int nonce, String hash, String prevHash, Boolean isvalid) {
        this.position = position;
        this.data = data;
        TimeStamp = timeStamp;
        this.nonce = nonce;
        this.hash = hash;
        this.prevHash = prevHash;
        this.isvalid = isvalid;
    }
}
