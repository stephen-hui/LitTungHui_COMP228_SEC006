package com.lab5.littunghui_comp228lab5;

public class PlayerRecord {
    private int player_id;
    private String first_name;
    private String last_name;
    private String address;
    private String postal_code;
    private String province;
    private String phone_number;

    public PlayerRecord(int player_id, String first_name, String last_name, String address, String postal_code, String province, String phone_number) {
        this.player_id = player_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.postal_code = postal_code;
        this.province = province;
        this.phone_number = phone_number;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public String getFullName(){
        return first_name + " " + last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAddress() {
        return address;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public String getProvince() {
        return province;
    }

    public String getPhone_number() {
        return phone_number;
    }
}
