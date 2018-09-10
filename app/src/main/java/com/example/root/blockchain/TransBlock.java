package com.example.root.blockchain;

public class TransBlock {
    String id;
    String Sender;
    String Reciver;
    String Value;
    String Hash;
    String PrevHash;
    String Timestamp;
    String Nonce;
String Miner;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSender() {
        return Sender;
    }

    public void setSender(String sender) {
        Sender = sender;
    }

    public String getReciver() {
        return Reciver;
    }

    public void setReciver(String reciver) {
        Reciver = reciver;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getHash() {
        return Hash;
    }

    public void setHash(String hash) {
        Hash = hash;
    }

    public String getPrevHash() {
        return PrevHash;
    }

    public void setPrevHash(String prevHash) {
        PrevHash = prevHash;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public String getNonce() {
        return Nonce;
    }

    public void setNonce(String nonce) {
        Nonce = nonce;
    }

    public String getMiner() {
        return Miner;
    }

    public void setMiner(String miner) {
        Miner = miner;
    }

    public TransBlock(String id, String sender, String reciver, String value, String hash, String prevHash, String timestamp, String nonce, String miner) {
        this.id = id;
        Sender = sender;
        Reciver = reciver;
        Value = value;
        Hash = hash;
        PrevHash = prevHash;
        Timestamp = timestamp;
        Nonce = nonce;
        Miner = miner;
    }
}
