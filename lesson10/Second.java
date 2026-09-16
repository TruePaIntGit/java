// Средняя
// Создать интерфейс Drawable с методом draw(). Создать два 
// никак не связанных друг с другом класса — Circle (поле 
// radius) и TextLabel (поле text), — оба реализуют Drawable, 
// каждый по-своему определяя draw() (для круга — вывести 
// параметры круга, для текста — вывести сам текст). В main: 
// массив Drawable[], заполнить объектами обоих классов,
//  вызвать draw() в цикле.
class Second{
    interface Drawable{
        void draw();
    }
    static class Circle implements Drawable{
        double radius;
        

        public Circle(double radius) {
            this.radius = radius;
        }
        @Override
        public void draw() {
            System.out.println("Radius: "+radius);
            System.out.println("Area: "+(radius*radius*Math.PI));
        }
        
    }
    static class TextLabel implements Drawable{
        String text;

        public TextLabel(String text) {
            this.text = text;
        }

        @Override
        public void draw() {
            System.out.println(text);
        }
        
        

    }
    public static void main(String[] args) {
        Drawable[] drawables = new Drawable[3];
        drawables[0]=new Circle(0.6);
        drawables[1]=new TextLabel("hello world");
        drawables[2]=new Circle(12.9);
        for(Drawable i: drawables){
            i.draw();
        }

    }
}