import java.io.File;
import java.util.Random;


public class sdd {
	
    private static Random  random = new Random();
    
    

	public static void main(String[] args) {
		
		String a = "BGW070800";
		
		File file = new File("dd");
		
	    File pf = file.getParentFile();
	    boolean issuc = pf.mkdirs();
		
		System.out.println(file.getParent());
	
	}

}
