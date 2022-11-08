package dat.backend.model.entities;

public class Bottom {

    private int bottomId;
    private String bottomName;
    private int bottomPrice;

    public Bottom(int bottomId, String bottomName, int bottomPrice) {
        this.bottomName = bottomName;
        this.bottomPrice = bottomPrice;
        this.bottomId = bottomId;
    }

    @Override
    public String toString() {
        return "Bottom{" +
                "bottomId=" + bottomId +
                ", bottomName='" + bottomName + '\'' +
                ", bottomPrice=" + bottomPrice +
                '}';
    }

    public int getBottomId() {
        return bottomId;
    }

    public String getBottomName() {
        return bottomName;
    }

    public int getBottomPrice() {
        return bottomPrice;
    }
}
