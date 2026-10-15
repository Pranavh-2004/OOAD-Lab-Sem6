//example for protection proxy--access rights

interface demo {

	void display(String cmd);
}

class concretedemo implements demo {

	
	public void display(String msg)
	{
                //some heavy implementation
		System.out.println(msg);
	}

}

 class Proxy implements demo {

	public boolean isAdmin;
	private concretedemo obj;
	
	public Proxy(String user, String pwd)
	{
		if("Ram".equals(user) && "pes123".equals(pwd)) 
			isAdmin=true;
			obj = new concretedemo();
		
	}
	
	
	public void display(String msg) 
 {
		if(isAdmin){
				msg=msg+"  admin";
				
				obj.display(msg);
		}else{
			
				obj.display(msg);
			}
			}

}

class demoproxy {

	public static void main(String[] args){
		Proxy pobj = new Proxy("Ram", "pe123");
		pobj.display("hello");		
	}

}
