package com.codegym.casem2.modal;

public class DanhGia extends Car {
    private int IDKH;
    private int IDxe;
    private String content;
    private int status;


    public DanhGia() {
    }


    public DanhGia(int IDKH, int IDxe, String content, int status) {
        this.IDKH = IDKH;
        this.IDxe = IDxe;
        this.content = content;
        this.status = status;
    }

    public DanhGia( int carID, String carName,double price, String color, String img, String branch,int status, int IDKH, String content){
            super(carID, carName, price, color, img, branch, status);
            this.IDKH = IDKH;
            this.content = content;
        }



    public DanhGia( int carID, String carName,double price, String color, String img, String branch,int status,
        int IDKH, int IDxe, String content,int status1){
            super(carID, carName, price, color, img, branch, status);
            this.IDKH = IDKH;
            this.IDxe = IDxe;
            this.content = content;
            this.status = status1;
        }

        public int getIDKH () {
            return IDKH;
        }

        public void setIDKH ( int IDKH){
            this.IDKH = IDKH;
        }

        public int getIDxe () {
            return IDxe;
        }

        public void setIDxe ( int IDxe){
            this.IDxe = IDxe;
        }

        public String getContent () {
            return content;
        }

        public void setContent (String content){
            this.content = content;
        }

        public int getStatus () {
            return status;
        }

        public void setStatus ( int status){
            this.status = status;
        }
    }

