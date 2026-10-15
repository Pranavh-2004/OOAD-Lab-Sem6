import java.util.ArrayList;
import java.util.List;

interface IStockCommand {
	void execute();
}
class BuyStock implements IStockCommand{

   private Stock abcStock;

   public BuyStock(Stock abcStock){
      this.abcStock = abcStock;
   }
		public void execute() 
	{
		abcStock.buy();
	}

}
class SellStock implements IStockCommand {
	private Stock abcStock;
	public SellStock(Stock abcStock){
		this.abcStock = abcStock;
	}
	public void execute() {
		abcStock.sell();
	}
}
class Broker {
   private List<IStockCommand> orderList = new ArrayList<>(); 

   public void takeOrder(IStockCommand order){
      orderList.add(order);		
   }

   public void placeOrders(){
   
      for (IStockCommand order : orderList) {
         order.execute();
      }
      orderList.clear();
   }
}


class Stock 
{
//Receiver	
	   private String name = "STCK";
	   private int quantity = 10;

	   public void buy(){
	      System.out.println("Stock [ Name: " +name+ ", Quantity: " + quantity +" ] bought");
	   }
	   public void sell(){
	      System.out.println("Stock [ Name: " + name + ",  + Quantity: " + quantity +" ] sold");
	   }
}
class Commanddemo {

	public static void main(String[] args) {

		Stock abcStock = new Stock();   //receiver
		BuyStock buyStockOrder = new BuyStock(abcStock);  //command
		SellStock sellStockOrder = new SellStock(abcStock);  //command
		Broker broker = new Broker();	//invoker

		broker.takeOrder(buyStockOrder);
		broker.takeOrder(sellStockOrder);

		broker.placeOrders();
	}

}