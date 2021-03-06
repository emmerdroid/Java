//Emmanuel Salcedo
//CPSC223 J Test 1


public class Test1Operation
{
  public static double Area(double length, double height)
  {
    double area;
    area = (length * height)/2.0;
    return area;
  }

  public static double Hypotenuse(double sideA, double sideB)
  {
    double hyp;
    hyp = Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
    return hyp;
  }

  public static boolean isFloat(String s)
    {
      int length = s.length();
      boolean success = true;
      if(length == 0)
      {
        success = false;
      }
      else
      {
        int start = 0;
        char c = s.charAt(0);
        if (c == '+' || c == '-')
        {
          start = 1;
        }
        if (start == length)
        {
          success = false;
        }
        for (int k = start; k < length && success; k++)
        {
          c = s.charAt(k);
          if(Character.isLetter(c))
          {
            success = false;
          }

        }
    }
    return success;
  }



}
