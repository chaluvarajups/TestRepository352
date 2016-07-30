import java.util.Calendar;
import java.util.UUID;

public class Uuid {
	public static void main (String []args){
		
      String unique="Opty_";
		try {
		
			UUID uuid = UUID.randomUUID();
			System.out.println("uuid is :"+uuid);
			String myRandom = uuid.toString();
			System.out.println("myRandom is :"+myRandom);
			String rndm = myRandom.substring(0,myRandom.length() - 30);
			System.out.println("rndm is :"+rndm);
			if (rndm.length() > 5) {
				rndm = rndm.substring(3);
				System.out.println("rndm is :"+rndm);
			}
			Calendar lCDateTime = Calendar.getInstance();
			System.out.println("lCDateTime is :"+lCDateTime);
			String tm = lCDateTime.getTimeInMillis() + "";
			System.out.println("tm is :"+tm);
			if (tm.length() > 10) {
				tm = tm.substring(5);
				System.out.println("tm is :"+tm);
			}
			unique= unique + rndm + tm;
			System.out.println("unique is :"+unique);
		} catch (Exception e) {
			Calendar lCDateTime = Calendar.getInstance();
			unique= unique + unique.length() + lCDateTime.getTime().toString();
			System.out.println("unique is :"+unique);
		    }
}
}


