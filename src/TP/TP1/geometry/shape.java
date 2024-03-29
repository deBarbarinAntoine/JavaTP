package TP.TP1.geometry;

abstract public class shape implements polygon {

    @Override
   abstract public double area();

    @Override
   public void calcArea() {
       double area = this.area();
       System.out.println(this);
       System.out.println("The area of the shape is "+area + " m2");
   }

   public static polygon NewPolygon(@org.jetbrains.annotations.NotNull type newShape) {
        return switch (newShape) {
            case circle -> new circle();
            case fourthCircle -> new fourthCircle();
            case rectangle -> new rectangle();
            case square -> new square();
            case squareTriangle -> new squareTriangle();
            case trapezoid -> new trapezoid();
        };
   }
}
