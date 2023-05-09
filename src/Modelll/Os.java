package Modelll;

import Modelll.Entity.Person;

import java.io.Serializable;


public class Os implements Serializable {
    protected  String payment;

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Person client;

    protected int satisfaction;

    protected double finalvalue;

    protected long createtime;

    public long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }

    protected long starttime;

    protected long finishtime;

    public long getStarttime() {
        return starttime;
    }

    public void setStarttime(long starttime) {
        this.starttime = starttime;
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(int satisfaction) {
        this.satisfaction = satisfaction;
    }

    public long getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(long finishtime) {
        this.finishtime = finishtime;
    }



    public Os(Person client, int id, String description, int status, double finalvalue, String payment, int satisfaction, long createtime, long starttime, long finishtime) {
        this.client = client;
        this.id = id;
        this.description = description;
        this.status = status;
        this.finalvalue = finalvalue;
        this.payment = payment;
        this.satisfaction = satisfaction;
        this.createtime = createtime;
        this.starttime = starttime;
        this.finishtime = finishtime;

    }


    public double getFinalvalue() {
        return finalvalue;
    }

    public void setFinalvalue(double finalvalue) {
        this.finalvalue = finalvalue;
    }
    protected  int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected String description;

    public Person getClient() {
        return client;
    }

    public void setClient(Person client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    protected int status;


}
