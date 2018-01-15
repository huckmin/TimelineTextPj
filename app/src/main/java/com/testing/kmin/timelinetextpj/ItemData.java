package com.testing.kmin.timelinetextpj;

import org.json.JSONObject;

/**
 * Created by kmin on 2018-01-02.
 */

public class ItemData {

    public static final int TYPE_COL_ONE = 1;
    public static final int TYPE_COL_TWO = 2;
    public static final int TYPE_COL_THREE = 3;

    public int colId;
    public String messageData, title, regDate, todoType, imgUrl1, imgUrl2, imgUrl3;

    public ItemData(int colId, String title, String regDate ,String messageData, String todoType){
        this.colId = colId;
        this.title = title;
        this.regDate = regDate;
        this.messageData = messageData;
        this.todoType = todoType;
    }
    public ItemData(int colId, String title, String regDate ,String messageData, String todoType, String img, String img2, String img3){
        this.colId = colId;
        this.title = title;
        this.regDate = regDate;
        this.messageData = messageData;
        this.todoType = todoType;
        this.imgUrl1 = img;
        this.imgUrl2 = img2;
        this.imgUrl3 = img3;

    }

    public ItemData(JSONObject obj){
        try{
            this.colId = obj.getInt("type");
            this.title = obj.getString("title");
            this.regDate = obj.getString("regDate");
            this.messageData = obj.getString("messageData");
            this.todoType = obj.getString("todoType");
            if(obj.getString("imgUrl1") != null){
                this.imgUrl1 = obj.getString("imgUrl1");
            }
            if(obj.getString("imgUrl2") != null){
                this.imgUrl2 = obj.getString("imgUrl2");
            }
            if(obj.getString("imgUrl3") != null){
                this.imgUrl3 = obj.getString("imgUrl3");
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public String getImgUrl1() {
        return imgUrl1;
    }

    public void setImgUrl1(String imgUrl1) {
        this.imgUrl1 = imgUrl1;
    }

    public String getImgUrl2() {
        return imgUrl2;
    }

    public void setImgUrl2(String imgUrl2) {
        this.imgUrl2 = imgUrl2;
    }

    public String getImgUrl3() {
        return imgUrl3;
    }

    public void setImgUrl3(String imgUrl3) {
        this.imgUrl3 = imgUrl3;
    }

    public String getTodoType() {
        return todoType;
    }

    public void setTodoType(String todoType) {
        this.todoType = todoType;
    }

    public String getMessageData() {
        return messageData;
    }

    public String getTitle() {
        return title;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setMessageData(String messageData) {
        this.messageData = messageData;
    }

    public int getColId() {
        return colId;

    }

    public void setColId(int colId) {
        this.colId = colId;
    }
}