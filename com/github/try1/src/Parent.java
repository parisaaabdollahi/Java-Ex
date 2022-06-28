@Doc(developer = "Parisa",creationDate = 1401,value = 1)

public class Parent implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static final void  start(){
        System.out.println("started...");
    };
}
