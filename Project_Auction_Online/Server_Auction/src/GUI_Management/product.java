
package GUI_Management;


public class product {
    String id;
    String imageURL;
    String nameProduct;
    String infoProduct;
    String price;
    String fullname;
    String username;
    String DateT;
    String clock;
    String money;
    public product(String id, String imageURL, String nameProduct, String infoProduct, String price, String fullname, String username, String DateT,String clock, String money) {
        this.id = id;
        this.imageURL = imageURL;
        this.nameProduct = nameProduct;
        this.infoProduct = infoProduct;
        this.price = price;
        this.fullname = fullname;
        this.username = username;
        this.DateT = DateT;
        this.clock = clock;
        this.money = money;
    }

    public String getMoney() {
        return money;
    }

    public String getClock() {
        return clock;
    }

    public String getId() {
        return id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public String getInfoProduct() {
        return infoProduct;
    }

    public String getPrice() {
        return price;
    }

    public String getFullname() {
        return fullname;
    }

    public String getUsername() {
        return username;
    }

    public String getDateT() {
        return DateT;
    }
    
}
