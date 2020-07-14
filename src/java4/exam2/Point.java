package java4.exam2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null) {
            return false;
        }

        // ohterObject가 같은 인스턴스인지
        if (getClass() != other.getClass()) {
            return false;
        }

        // 인스턴스 변수들의 값이 동일한지 확인
        Point ohterPoint = (Point) other;
        return ohterPoint.x == this.x &&  this.y == ohterPoint.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return getClass().getName() + "x=" + x +   ", y=" + y +     '}';
    }
}
