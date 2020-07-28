package Service;

public class Phone {
    private int id;
    private String name;
    private String price;
    private String urlOnPagePhone;
    private String urlOnImage;

    public Phone (String name, String price, String urlOnPagePhone, String urlOnImage) {

        this.name = name;
        this.price = price;
        this.urlOnPagePhone = urlOnPagePhone;
        this.urlOnImage = urlOnImage;
    }
public Phone()
{

}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUrlOnPagePhone() {
        return urlOnPagePhone;
    }

    public void setUrlOnPagePhone(String urlOnPagePhone) {
        this.urlOnPagePhone = urlOnPagePhone;
    }

    public String getUrlOnImage() {
        return urlOnImage;
    }

    public void setUrlOnImage(String urlOnImage) {
        this.urlOnImage = urlOnImage;
    }
}
