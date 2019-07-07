//举两个比较常见的例子(我暂时可以准确想到的，当然还有很多很多):
//
//(1)Spring中通过getBean(“xxx”)获取Bean；
//
//(2) Java消息服务JMS中(下面以消息队列ActiveMQ为例子)

public class Main {
    public static void main(String[] args) {
        //简单
        Circle circle = (Circle) SimpleFactory.getClass(Circle.class);
        circle.draw();

        Rectangle rectangle = (Rectangle) SimpleFactory.getClass(Rectangle.class);
        rectangle.draw();

        Square square = (Square) SimpleFactory.getClass(Square.class);
        square.draw();

        //工厂模式
        Factory circleFactory = new CircleFactory();
        Shape circleFactoryInstance = circleFactory.getShape();
        circleFactoryInstance.draw();

        //抽象工厂  抽象工厂模式是工厂方法的仅一步深化，是属于一种组合的工厂模式
        AbstractFactory abstractFactory;
        Gun gun;
        Bullet bullet;

        abstractFactory = new AK_Factory();
        gun = abstractFactory.produceGun();
        gun.shooting();
        bullet = abstractFactory.produceBullet();
        bullet.load();
    }
}
