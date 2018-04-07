package domain;

import java.io.Serializable;
import java.util.Date;

public class Stone implements Serializable {
    public String stone_categories;
    public float sheer_weight;
    public String weighing_date;
    public int pound_sheet;
    public String vendor;
    public String edit_date;
    public float Inventories;//库存
    public Float sheer_weight_sum;//碎石总量

    public String getStone_categories() {
        return stone_categories;
    }

    public void setStone_categories(String stone_categories) {
        this.stone_categories = stone_categories;
    }

    public float getSheer_weight() {
        return sheer_weight;
    }

    public void setSheer_weight(float sheer_weight) {
        this.sheer_weight = sheer_weight;
    }

    public String getWeighing_date() {
        return weighing_date;
    }

    public void setWeighing_date(String weighing_date) {
        this.weighing_date = weighing_date;
    }

    public int getPound_sheet() {
        return pound_sheet;
    }

    public void setPound_sheet(int pound_sheet) {
        this.pound_sheet = pound_sheet;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getEdit_date() {
        return edit_date;
    }

    public void setEdit_date(String edit_date) {
        this.edit_date = edit_date;
    }

    public float getSheer_weight_sum() {
        return sheer_weight_sum;
    }

    public void setSheer_weight_sum(float sheer_weight_sum) {
        this.sheer_weight_sum = sheer_weight_sum;
    }

    @Override
    public String toString() {
        return "Stone{" +
                "stone_categories='" + stone_categories + '\'' +
                ", sheer_weight=" + sheer_weight +
                ", weighing_date=" + weighing_date +
                ", vendor='" + vendor + '\'' +
                '}';
    }
}
