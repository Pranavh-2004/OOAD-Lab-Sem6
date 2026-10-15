//example for virtual proxy
interface ibookparser
{
int getpages();
int getverbs();
int getwords();
}

class bookparser implements ibookparser
{
String book=".........";//string rep of a book

private int nopages;//nofchaps,nofverbs...and all properties

public bookparser(String book)
{
this.book=book;
//logic to parse the book and set nofpages,nofchaps,nofverbs, noofwords.....
}
//getters for all other properties
public int getpages()
{
this.nopages=1000;
return nopages;
}
}

class proxyparser implements ibookparser
{
private bookparser bobj=null;
private String book=null;
proxyparser(String a)
{
book=a;
}
public int getpages()
{
if(bobj==null)
{
bobj=new bookparser(book);
int x=bobj.getpages();
return x;
}
else
return 0;
}
}
class proxydemo
{
public static void main(String args[])
{
proxyparser p=new proxyparser("designpatterns");
//bookparser b=new bookparser("textbook content");//cttt parsing
System.out.println("no_of_pages= "+p.getpages());
}
}