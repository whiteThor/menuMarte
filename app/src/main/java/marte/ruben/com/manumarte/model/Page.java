package marte.ruben.com.manumarte.model;

/**
 * Created by Ruben Vilchez on 08/07/2017.
 * anotaciones|
 */

public class Page {
    private  int imageId;
    private  int textId;
    private Choice choise1;
    private Choice choise2;
    private int menu;
    private boolean isFinalPage = false;


    public Page(int imageId, int textId) {
        this.imageId = imageId;
        this.textId = textId;
        this.isFinalPage=true;
    }

    public Page(int imageId, int textId, Choice choise1, Choice choise2, int menu) {
        this.imageId = imageId;
        this.textId = textId;
        this.choise1 = choise1;
        this.choise2 = choise2;
        this.menu = menu;
    }

    public Page(int imageId, int textId, int menu) {
        this.imageId = imageId;
        this.textId = textId;
        this.menu = menu;
        this.isFinalPage=true;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public Choice getChoise1() {
        return choise1;
    }

    public void setChoise1(Choice choise1) {
        this.choise1 = choise1;
    }

    public Choice getChoise2() {
        return choise2;
    }

    public void setChoise2(Choice choise2) {
        this.choise2 = choise2;
    }

    public void setFinalPage(boolean finalPage) {
        isFinalPage = finalPage;
    }
    public boolean isFinalPage() {
        return isFinalPage;
    }
    public int getMenu() {
        return menu;
    }

    public void setMenu(int menu) {
        this.menu = menu;
    }


}
