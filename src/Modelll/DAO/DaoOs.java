package Modelll.DAO;

import Modelll.Os;

import java.util.ArrayList;
import java.util.List;

public class DaoOs {
    public List<Os> OsList = new ArrayList<Os>();

    public boolean saveOS(Os os) {
        try {
            OsList.add(os);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean startOsDao(Os os){
        os.setStatus(1);
        os.setStarttime(System.currentTimeMillis());
        return true;
    }

    public static boolean finalizeOsDao(Os os, double value){
        os.setStatus(2);
        os.setFinishtime(System.currentTimeMillis());

        os.setFinalvalue(value);
        return true;
    }

    public static boolean paymantOsDao(Os os, String pagm, int sats, int stts){
        os.setPayment(pagm);
        os.setSatisfaction(sats);
        os.setStatus(stts);
        return true;
    }

    public static boolean cancelOsDao(Os os) {
        os.setStatus(4);
        return true;
    }



}
