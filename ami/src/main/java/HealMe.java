

public class HealMe {
	  private static final int SIZE = (int) (Runtime.getRuntime().maxMemory() * 0.6);

	  public static void main(String[] args) throws Exception {
		  System.out.println("size="+SIZE/(1024*1024));
	    for (int i = 0; i < 1000; i++) {
	      allocateMemory(i);
	    }
	  }

	  private static void allocateMemory(int i) {
		  
	    try {
	      {
	        byte[] bytes = new byte[SIZE];
	        System.out.println(bytes.length);
	        System.out.println("I allocated memory successfully " + i);
	      }

	      
	      byte[] moreBytes = new byte[SIZE];
	      System.out.println(moreBytes.length);
	      

	      System.out.println("I allocated memory successfully " + i);

	    } catch (OutOfMemoryError e) {
	    	e.printStackTrace();
	      System.out.println("I failed to allocate memory " + i);
	    }
	  }
	}
