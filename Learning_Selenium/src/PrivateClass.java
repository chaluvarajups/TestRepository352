import java.sql.Time;

class PrivateClass {

	 public static String OptyName;
	 public final String Account= "Automotive";
	 protected static String CreateOpty(String Oname){
		 OptyName=Oname + "ConCat";
		 return OptyName;
	 }
	 
	 public static void main(String args[]){
		 
		 for(int i=0;i<10;i++){
			 String OptyCreated = CreateOpty("AutoOpty"+i);
			 System.out.println(OptyCreated);
		 }
	 }
}
