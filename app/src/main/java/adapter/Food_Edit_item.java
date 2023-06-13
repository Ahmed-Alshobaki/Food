package adapter;

public class Food_Edit_item {
    private int ImageView;
    private String evaluate;
    private int ImageFood;
    private String title;
    private String description;
    private String rate;
    private String rate_mane;

    private  String Qty ;
    private String Id;

    public String getQty() {
        return Qty;
    }

    public void setQty(String qty) {
        Qty = qty;
    }

    public void setRate_mane(String rate_mane) {
        this.rate_mane = rate_mane;
    }





    public Food_Edit_item(int imageView, String evaluate, int imageFood, String title, String description, String rate, String rate_mane,  String Id_number, String Qty,String Id) {
        ImageView = imageView;
        this.evaluate = evaluate;
        ImageFood = imageFood;
        this.title = title;
        this.description = description;
        this.rate = rate;
        this.rate_mane = rate_mane;
        this.Id = Id_number;

        this.Qty =  Qty;
        this.Id =Id;
    }
        public Food_Edit_item(){

        }
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getRate_mane() {
        return rate_mane;
    }


    public int getImageView() {
        return ImageView;
    }

    public void setImageView(int imageView) {
        ImageView = imageView;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public int getImageFood() {
        return ImageFood;
    }

    public void setImageFood(int imageFood) {
        ImageFood = imageFood;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }



}
