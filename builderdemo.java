//https://www.youtube.com/watch?v=k4EkJgY9P4c&list=PLsyeobzWxl7r2ZX1fl-7CKnayxHJA_1ol&index=5

class phone
{
private String os;
private String processor;
private int screen_size;
private int battery;
private int camera;
phone(String os,String processor,int screen_size, int battery, int camera)
{
this.os=os;
this.processor=processor;
this.screen_size=screen_size;
this.battery=battery;
this.camera=camera;
}

public String toString()
{
return "phone with "+ "os ="+os +" processor = "+processor +" ss = "+ screen_size +" battery= "+ battery + " camera= "+camera;
}
}
class phonebuilder
{
private String os;
private String processor;
private int screen_size;
private int battery;
private int camera;
phonebuilder()
{
}
phonebuilder(String os,String processor)
{//essential params
this.os=os;
this.processor=processor;
}
phonebuilder setos(String os)
{
this.os=os;
return this;
}
phonebuilder setprocessor(String pro)
{
this.processor=pro;
return this;
}
phonebuilder setscreensize(int ss)
{
this.screen_size=ss;
return this;
}
phonebuilder setbattery(int battery)
{
this.battery=battery;
return this;
}
phonebuilder setcamera(int camera)
{
this.camera=camera;
return this;
}
public phone getphone()
{
return new phone(os,processor,screen_size,battery,camera);
}
}
class builderdemo
{
public static void main(String args[])
{
phone p1=new phonebuilder("ios","qualcom").setbattery(10).getphone();
phone p2=new phonebuilder().setos("xx").getphone();
phone p3=new phonebuilder().setos("xy").setcamera(20).setbattery(100).setscreensize(22).getphone();
System.out.println(p1); 
System.out.println(p2); 
System.out.println(p3); 


}

}



















