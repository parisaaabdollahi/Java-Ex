package j2os.org.service;

public class TimeCheckCost {
    public static Long CalculateCost(int indoor, int outdoor){
        long cost=0;
        int count = 0;
        if(indoor>7 && indoor<=9 && outdoor>7 && outdoor<=9){
            count++;
            cost=cost+12000;
        }
        if (indoor>10 && indoor<=11 && outdoor>10 && outdoor<=11) {
            int count1= 0;
            if (count1>2){
                cost=cost+10000;
            }
            count1++;
        }

        return cost;
    }
}
