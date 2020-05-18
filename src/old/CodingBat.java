package old;

import java.lang.*;

public class CodingBat {

    public String makeOutWord(String out, String word) {
        return out.substring(0,2) + word + out.substring(2,4);
    }

    public int countHi(String str) {

        int sum = 0;


        for(int i = 0; i < str.length() - 1; i++)
        {
            if (str.charAt(i) == 104)
            {
                if(str.charAt(i+1) == 105)
                {
                    sum +=1;
                }

            }
        }


        return sum;
    }

    public boolean xyBalance(String str) {      // x - 120 y - 121

        boolean check = true;
        for(int i = 0; i < str.length() ; i++)
        {
            if(str.length() < 2 && str.charAt(0) != 121 )
            {
                return false;
            }

            if(str.charAt(i) == 120)
            { check = false;

                for(int j = i + 1; j < str.length(); j++)
                {
                    if(str.charAt(j) == 121)
                    {
                        check = true;
                    }
                }

            }

            if (!check)
            {
                //System.out.println(false);
                break;

            }
            check = true;
        }

    return check;
    }

    public String notReplace(String str) { // i - 105 s - 115

        StringBuilder myName = new StringBuilder(str);

        for (int i = 0; i < str.length() - 1; i++)
         {

            if(str.charAt(i) == 105 && str.charAt(i + 1) == 115) // trafienie "is"
            {
                boolean start = Character.isLetter(i - 1);
                boolean end = Character.isLetter(i + 2);

                if(!start && !end)
                {
                    myName.insert(i + 2, " not");
                    return myName.toString();
                }
            }


         }


        return myName.toString();
    }




    public static void main(String[] args) {

        CodingBat c = new CodingBat();

        //System.out.println(c.makeOutWord("<<>>", "The"));
        System.out.println(c.notReplace("is asd sd sd dddd dis dsds"));



    }
}


