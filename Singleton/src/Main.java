public class Main {
    public static void main(String[] args) {
        //用单例模式的话，我们就可以实现在需要使用时才创建对象，这样就避免了不必要的资源浪费。
        LazySingleton.getInstance().PrintOut();
    }
}
