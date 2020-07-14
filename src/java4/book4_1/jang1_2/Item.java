package java4.book4_1.jang1_2;

import java.util.Objects;

public class Item {
    private String description;
    private double price;

    public Item(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public boolean equals(Object otherObject) {
        // 두 객체가 동일한지 알아보는 빠른 검사
        if (this == otherObject) return true;

        // 매개변수가 null 이면 false를 반환해야한다.
        if (otherObject == null) return false;

        // otherObject가 Item의 인스턴스인지 검사한다
        if (getClass() != otherObject.getClass()) return false;

        // 인스턴스 변수들의 값이 동일한지 검사
        Item other = (Item) otherObject;
        return Objects.equals(description, other.description) && price == other.price;
    }

    public int hashCode() {
        // Objects.hash는 null에 안전하다.
        // 만약 배열 인스턴스 변수가 있으면 먼저 정적 메서드 Arrays.hashCode로 해당 배열의 해시코드를 계산한다. 그런다음 계산결과를 Objects.hash에 전달한다.
        return Objects.hash(description, price);

    }
}
