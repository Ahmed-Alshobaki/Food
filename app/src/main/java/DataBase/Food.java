package DataBase;

import android.graphics.Bitmap;

import com.example.myapplication.R;

public class Food {

    private String name;
    private String Id;
    private String description;
    private String price;
    private String rate;
    private  String Qty ;
    private  String type ;
    private  String like ="false";
    private  String sell ="false";
    private Bitmap image ;

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public Food(String name, String description, String price, String rate, String qty, int imageView, int imageFood, Bitmap image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.rate = rate;
        Qty = qty;


        this.image =  image;
    }

    public String getQty() {
        return Qty;
    }

    public void setQty(String qty) {
        Qty = qty;
    }








    public Food(){

    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Food(String name, String id, String description, String price, String rate , String Qty, String type,Bitmap image) {
        this.name = name;
        Id = id;
        this.description = description;
        this.price = price;
        this.rate = rate;
        this.Qty = Qty;
        this.type=type;
        this.image =  image;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
