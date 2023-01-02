package com.ricemarch.patternspring.pay.pojo;

public class PayBody {

    private String account;
    private int type;
    private String product;
    private int amount;


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "PayBody{" +
                "account='" + account + '\'' +
                ", type=" + type +
                ", product='" + product + '\'' +
                ", amount=" + amount +
                '}';
    }
}
