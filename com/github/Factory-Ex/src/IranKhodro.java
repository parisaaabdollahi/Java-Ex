public interface IranKhodro {
   int SAMAND =0;
   int PEUGEOT206 = 1;
   int PEUGEOT207= 2;


   static IranKhodro get(int code)
   {
       switch (code)
       {
           case SAMAND:
               Samand samand=new Samand();
               return samand;

           case PEUGEOT206:
               Peugeot206 peugeot206=new Peugeot206();
               return peugeot206;

           default:
               Peugeot207 peugeot207=new Peugeot207();
               return peugeot207;
       }
   }


void turnOnEngine();
void turnOffEngine();

}


