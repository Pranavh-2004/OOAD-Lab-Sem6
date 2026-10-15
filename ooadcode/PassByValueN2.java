class PassByValueN2 {

  public static void main(String[] args) {
    Integer[] array = new Integer[2];
    array[0] = 2;
    array[1] = 3;
    add(array);
    System.out.println("Result from main: " + (array[0] + array[1]));
  }

  private static void add(Integer[] array) {
    array = new Integer[2];
    array[0] = 10;
    array[1] = 3;
    System.out.println("Result from method: " + (array[0] + array[1]));
  }
}
