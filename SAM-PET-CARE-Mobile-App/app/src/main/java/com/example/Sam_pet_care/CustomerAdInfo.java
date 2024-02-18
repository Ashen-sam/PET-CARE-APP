package com.example.Sam_pet_care;

public class CustomerAdInfo
{
    private String Name,Address,Phone,NIC,Property,BeRooms,BaRooms,Times;

    public CustomerAdInfo(String name, String address, String phone, String NIC, String property, String beRooms, String baRooms, String times) {
        Name = name;
        Address = address;
        Phone = phone;
        this.NIC = NIC;
        Property = property;
        BeRooms = beRooms;
        BaRooms = baRooms;
        Times = times;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getProperty() {
        return Property;
    }

    public void setProperty(String property) {
        Property = property;
    }

    public String getBeRooms() {
        return BeRooms;
    }

    public void setBeRooms(String beRooms) {
        BeRooms = beRooms;
    }

    public String getBaRooms() {
        return BaRooms;
    }

    public void setBaRooms(String baRooms) {
        BaRooms = baRooms;
    }

    public String getTimes() {
        return Times;
    }

    public void setTimes(String times) {
        Times = times;
    }
}
