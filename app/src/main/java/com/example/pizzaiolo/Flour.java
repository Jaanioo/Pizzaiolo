package com.example.pizzaiolo;

public class Flour {

    private String forceFactorW;
    private String plasticityCoefficient;
    private String proteinPer100;
    private String type;

    private int mImgRedId;
    private String mFlourName;


    public Flour() {
    }

    public Flour(int mImgRedId, String mFlourName) {
        /*this.forceFactorW = forceFactorW;
        this.plasticityCoefficient = plasticityCoefficient;
        this.proteinPer100 = proteinPer100;
        this.type = type;

         */
        this.mImgRedId = mImgRedId;
        this.mFlourName = mFlourName;
    }

    public String getForceFactorW() {
        return forceFactorW;
    }

    public void setForceFactorW(String forceFactorW) {
        this.forceFactorW = forceFactorW;
    }

    public String getPlasticityCoefficient() {
        return plasticityCoefficient;
    }

    public void setPlasticityCoefficient(String plasticityCoefficient) {
        this.plasticityCoefficient = plasticityCoefficient;
    }

    public String getProteinPer100() {
        return proteinPer100;
    }

    public void setProteinPer100(String proteinPer100) {
        this.proteinPer100 = proteinPer100;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getmImgRedId() {
        return mImgRedId;
    }

    public void setmImgRedId(int mImgRedId) {
        this.mImgRedId = mImgRedId;
    }

    public String getmFlourName() {
        return mFlourName;
    }

    public void setmFlourName(String mFlourName) {
        this.mFlourName = mFlourName;
    }
}

