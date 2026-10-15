class sample
{
int var=100;
sample()
{}
sample(sample s)
{
this.var=var;
}
}
class demo
{
int x;
sample s;
demo()
{
}
demo(int x,sample p)
{
this.x=x;
this.s=new sample(p);
}
demo(demo d)
{
this.x=d.x;
this.s=d.s;
}
public String toString()
{
return "x="+x+"  s.var= "+s.var;
}
}
class copydemo11
{
public static void main(String args[])
{
sample obj=new sample();
demo d1=new demo(10,obj);
System.out.println("d1's hashcode="+ d1.hashCode());
demo d2=new demo(d1);
System.out.println("d2's hashcode="+ d2.hashCode());
System.out.println("d1 is="+ d1);
System.out.println("d2 is="+ d2);
d1.x++;
d1.s.var++;
System.out.println("d1="+ d1);
System.out.println("d2="+ d2);
System.out.println(d1.s.hashCode());
System.out.println(d2.s.hashCode());
//sample obj is shared among d1 and d2
}
}