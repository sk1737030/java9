package java4.exam6;

import java.util.Objects;

public class DisCountedItem extends Item {
    public double discount;

    public DisCountedItem(String description, double price, double discount) {
        super(description, price);
        this.discount = discount;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject instanceof DisCountedItem) {
            return discount == ((DisCountedItem) otherObject).discount;
        }

        return super.equals(otherObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount);
    }

}
