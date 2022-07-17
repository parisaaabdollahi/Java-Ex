package j2os.org.service;


import j2os.org.error.SinError;
import j2os.org.error.SinLessNumber;
import j2os.org.error.SinMoreNumber;

public class SINValidation {
    SINValidation() {
    }

    private static SINValidation SIN_VALIDATION = new SINValidation();

    public static SINValidation getInstance() {
        return SIN_VALIDATION;
    }

    public long checkId(Long code) throws SinLessNumber, SinMoreNumber, SinError {
        String id = String.valueOf(code);

        char[] chars = id.toCharArray();
        int y = 0;
        for (char achar : chars) {
            y++;

        }
        System.out.println("Count number1 is " + y);
        if (y < 9) {
            throw new SinLessNumber();
        } else if (y > 9) {
            throw new SinMoreNumber();
        } else return validcode(code);

    }

    public Long validcode(Long id) throws SinError {

        String idCode = String.valueOf(id);
        String code = idCode.substring(0, 8);
        String check = idCode.substring(8);
        int total = 0;

        int[] number = new int[8];
        number[0] = Integer.parseInt(code.substring(0, 1));
        number[1] = Integer.parseInt(code.substring(1, 2)) * 2;
        number[2] = Integer.parseInt(code.substring(2, 3));
        number[3] = Integer.parseInt(code.substring(3, 4)) * 2;
        number[4] = Integer.parseInt(code.substring(4, 5));
        number[5] = Integer.parseInt(code.substring(5, 6)) * 2;
        number[6] = Integer.parseInt(code.substring(6, 7));
        number[7] = Integer.parseInt(code.substring(7, 8)) * 2;

        int[] dahgan = new int[4];
        int[] yekan = new int[4];

        for (int i = 0; i < 4; i++) {
            if (number[2 * i + 1] > 9) {
                dahgan[i] = number[2 * i + 1] / 10;
                yekan[i] = number[2 * i + 1] % 10;
                number[2 * i + 1] = dahgan[i] + yekan[i];

            }

        }
        for (int numbers : number) {
            total = total + numbers;

        }
        int totalCheck = total;
        int x = 0;
        while (totalCheck > 0) {
            x++;
            totalCheck = totalCheck - 10;
        }
        int finalCheckNumber = (x * 10) - total;
        if (finalCheckNumber != Integer.parseInt(check)) {
            throw new SinError();
        } else return id;
    }


}
