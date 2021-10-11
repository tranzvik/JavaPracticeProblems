public class Singleton {

    private static Singleton singletonInstance= null;

    private Singleton(){}

    public  static Singleton getSingletonInstance(){
        if(singletonInstance==null) {
            synchronized (Singleton.class){
                if(singletonInstance==null) {
                    singletonInstance = new Singleton();
                }
            }
        }
        return singletonInstance;
    }



    //Eager Loading
   /* private static Singleton singletonInstance= new Singleton();

    private Singleton(){};

    public  static Singleton getSingletonInstance(){
        return singletonInstance;
    }*/
}
