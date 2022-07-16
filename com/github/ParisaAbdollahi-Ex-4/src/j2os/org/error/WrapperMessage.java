package j2os.org.error;

public class WrapperMessage {
    public static Object getErrorMessage(Exception e) {
        e.printStackTrace();
        if (e instanceof SinError) {
            System.out.println("101: SIN is not valid!");
        } else if (e instanceof SinLessNumber) {
            System.out.println("102:SIN number is less!");
        } else if (e instanceof SinMoreNumber) {
            System.out.println("103:SIN number is more!");
        }
        return null;
    }
}
