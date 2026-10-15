public class MainMulti 
{
  int modelYear;
  String modelName;

  public MainMulti(int year, String name) 
  {
    modelYear = year;
    modelName = name;
  }

  public static void main(String[] args) 
  {
    MainMulti myCar = new MainMulti(1969, "Mustang");
    System.out.println(myCar.modelYear + " " + myCar.modelName);
  }
}