public class Manager {

    private Manager(){}
    private static Manager manager=new Manager();

    public static Manager getInstance(){return manager;}


    public void a(){
        System.out.println("hi");
    }
    public void b(){
        System.out.println("goodbye");
    }

}
