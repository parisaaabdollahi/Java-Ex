public interface Kale {
    int MAST = 0;
    int DOOGH = 1;
    int BASTANI= 2;
    int KHAME = 3;

    static Kale get(int mahsoul)
    {
        switch (mahsoul){
            case MAST:
              Mast mast=new Mast();
                return mast;
            case DOOGH:
                Doogh doogh = new Doogh();
               return doogh;
            case BASTANI:
                Bastani bastani=new Bastani();
                return bastani;
            default:
                Khame khame=new Khame();
                return khame;
        }

    }

    void make();
}
