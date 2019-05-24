package homework04;

public class Triangle {
    private TrianglePoint a, b, c;
    private double ab, ac, bc, perimeter, half, height, area;

    public Triangle(TrianglePoint a, TrianglePoint b, TrianglePoint c) {
        this.a = a;
        this.b = b;
        this.c = c;

        // |AB| = √(xB−xA)2+(yB−yA)2
        // |AC| = √(xC−xA)2+(yC−yA)2
        // |BC| = √(xC−xB)2+(yC−yB)2

        ab = Math.abs(Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2)));
        ac = Math.abs(Math.sqrt(Math.pow(c.getX() - a.getX(), 2) + Math.pow(c.getY() - a.getY(), 2)));
        bc = Math.abs(Math.sqrt(Math.pow(c.getX() - b.getX(), 2) + Math.pow(c.getY() - b.getY(), 2)));

        // p = (a+b+c)/2

        perimeter = ab + ac + bc;
        half = perimeter / 2;

        // H = 2/a * √p(p−a)(p−b)(p-c)

        height = 2/ab * Math.sqrt(half * (half - ab) * (half - ac) * (half - bc));

        // S = 1/2 * a * h

        area = 0.5 * ab * height;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    // равносторонний
    public boolean isEquilateral() {
        return ab == ac && ab == bc;
    }

    // равнобедренный
    public boolean isIsosceles() {
        return (ab == ac && ab != bc) || (ab == bc && ac != bc) || (ac == bc && ac != ab);
    }

    // прямоугольный
    public boolean isRectangular() {
        // с²=a²+b²

        double hypo;

        if (ab > ac && ab > bc) {
            hypo = ab;
            return Math.round(Math.pow(hypo, 2)) == Math.round(Math.pow(ac, 2)) + Math.round(Math.pow(bc, 2));
        } else if (ac > ab && ac > bc) {
            hypo = ac;
            return Math.round(Math.pow(hypo, 2)) == Math.round(Math.pow(ab, 2)) + Math.round(Math.pow(bc, 2));
        } else {
            hypo = bc;
            return Math.round(Math.pow(hypo, 2)) == Math.round(Math.pow(ab, 2)) + Math.round(Math.pow(ac, 2));
        }
    }
}
