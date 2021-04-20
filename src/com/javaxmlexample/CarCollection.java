package com.javaxmlexample;

public class CarCollection {

    private String supercarManufacturer     = "Ferrari";
    private String supercarName             = "Ferrari 101";
    private String supercarType             = "sports";
    private String supercarSportscarName    = "Ferrari 203";

    private String userDefinedCarClass      = "";
    private String userDefinedCarName       = "";
    private String userDefinedCarType       = "";
    private String userDefinedCarTypeName   = "";

    public String getSupercarManufacturer() {
        return supercarManufacturer;
    }

    public CarCollection setSupercarManufacturer(String supercarManufacturer) {
        this.supercarManufacturer = supercarManufacturer;
        return this;
    }

    public String getSupercarName() {
        return supercarName;
    }

    public CarCollection setSupercarName(String supercarName) {
        this.supercarName = supercarName;
        return this;
    }

    public String getSupercarType() {
        return supercarType;
    }

    public void setSupercarType(String supercarType) {
        this.supercarType = supercarType;
    }

    public String getSupercarSportscarName() {
        return supercarSportscarName;
    }

    public void setSupercarSportscarName(String supercarSportscarName) {
        this.supercarSportscarName = supercarSportscarName;
    }

    public String getUserDefinedCarClass() {
        return userDefinedCarClass;
    }

    public void setUserDefinedCarClass(String userDefinedCarClass) {
        this.userDefinedCarClass = userDefinedCarClass;
    }

    public String getUserDefinedCarName() {
        return userDefinedCarName;
    }

    public void setUserDefinedCarName(String userDefinedCarName) {
        this.userDefinedCarName = userDefinedCarName;
    }

    public String getUserDefinedCarType() {
        return userDefinedCarType;
    }

    public void setUserDefinedCarType(String userDefinedCarType) {
        this.userDefinedCarType = userDefinedCarType;
    }

    public String getUserDefinedCarTypeName() {
        return userDefinedCarTypeName;
    }

    public void setUserDefinedCarTypeName(String userDefinedCarTypeName) {
        this.userDefinedCarTypeName = userDefinedCarTypeName;
    }
}
