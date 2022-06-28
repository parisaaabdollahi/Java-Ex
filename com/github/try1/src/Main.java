import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception{
        Parent parent=new Parent();
        Parent parent1 = (Parent)parent.clone();

        Doc doc= parent.getClass().getAnnotation(Doc.class);
        System.out.println(doc);

        Set<String> arraList = new HashSet<String>();
        arraList.add("Parisa");
        arraList.add(("Pooya"));
        arraList.add("Parvin");


      arraList.forEach(s -> System.out.println(s));

    }
}
