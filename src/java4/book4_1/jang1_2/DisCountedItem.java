package java4.book4_1.jang1_2;

public class DisCountedItem extends Item {
    public double discount;

    public DisCountedItem(String description, double price) {
        super(description, price);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject)) return false;
        DisCountedItem other = (DisCountedItem) otherObject;
        return discount == other.discount;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static void main(String[] args) {
        DisCountedItem disCountedItem = new DisCountedItem("test", 1000);


        System.out.println(disCountedItem.equals(new Item("test", 1000)));
    }
}
