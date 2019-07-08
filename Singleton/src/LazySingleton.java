
//懒汉方式。指全局的单例实例在第一次被使用时构建。
//利用双重检查加锁（double-checked locking
class LazySingleton {

    //volatile保证，当lazySingleton变量被初始化成Singleton实例时，多个线程可以正确处理uniqueInstance变量
    private volatile static LazySingleton lazySingleton;

    private LazySingleton() {

    }

    static LazySingleton getInstance() {
        //检查实例，如果不存在，就进入同步代码块
        if (lazySingleton == null) {
            //只有第一次才彻底执行这里的代码
            synchronized(Singleton.class) {
                //进入同步代码块后，再检查一次，如果仍是null，才创建实例
                if (lazySingleton == null) {
                    lazySingleton = new LazySingleton();
                }
            }
        }

        return lazySingleton;
    }

    void PrintOut(){
        System.out.println("This is LazySingleton");
    }
}
