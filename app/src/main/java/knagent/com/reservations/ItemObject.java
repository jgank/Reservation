package knagent.com.reservations;


public class ItemObject {

    private String name;
    private String phone;
    private int photoId;

    public ItemObject(String name, String phone, int photoId) {
        this.name = name;
        this.phone = phone;
        this.photoId = photoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }
}
