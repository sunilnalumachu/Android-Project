package com.example.sunil.drivingtest;
public class Question {
    private int ID;
    private String QUESTION;
    private String CHOA;
    private String CHOB;
    private String CHOC;
    private String SOLUTION;
    public Question()
    {
        ID=0;
        QUESTION="";
        CHOA="";
        CHOB="";
        CHOC="";
        SOLUTION="";
    }
    public Question(String question, String OPTa, String OPTb, String OPTc,
                    String aNSWER) {

        QUESTION = question;
        CHOA = OPTa;
        CHOB = OPTb;
        CHOC = OPTc;
        SOLUTION = aNSWER;
    }
    public int getID()
    {
        return ID;
    }
    public String getQUESTION() {
        return QUESTION;
    }
    public String getOPTA() {
        return CHOA;
    }
    public String getOPTB() {
        return CHOB;
    }
    public String getOPTC() {
        return CHOC;
    }
    public String getANSWER() {
        return SOLUTION;
    }
    public void setID(int id)
    {
        ID=id;
    }
    public void setQUESTION(String question) {
        QUESTION = question;
    }
    public void setOPTA(String OPTa) {
        CHOA = OPTa;
    }
    public void setOPTB(String OPTb) {
        CHOB = OPTb;
    }
    public void setOPTC(String OPTc) {
        CHOC = OPTc;
    }
    public void setANSWER(String aNSWER) {
        SOLUTION = aNSWER;
    }

}