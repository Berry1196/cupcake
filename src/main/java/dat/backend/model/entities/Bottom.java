package dat.backend.model.entities;

public class Bottom {

    private int bottomId;
    private String bottomName;
    private int bottomPrice;

    public Bottom(String bottomName, int bottomPrice) {
        this.bottomName = bottomName;
        this.bottomPrice = bottomPrice;
    }
}
