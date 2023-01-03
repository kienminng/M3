package com.codegym.casem2.modal;

import java.util.Date;

public class HoaDon {
    private  int IDHoaDon;
    private int IDKH;
    private Date time;

    public HoaDon() {
    }

    public HoaDon(int IDHoaDon, int IDKH, Date time) {
        this.IDHoaDon = IDHoaDon;
        this.IDKH = IDKH;
        this.time = time;
    }

    public int getIDHoaDon() {
        return IDHoaDon;
    }

    public void setIDHoaDon(int IDHoaDon) {
        this.IDHoaDon = IDHoaDon;
    }

    public int getIDKH() {
        return IDKH;
    }

    public void setIDKH(int IDKH) {
        this.IDKH = IDKH;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
