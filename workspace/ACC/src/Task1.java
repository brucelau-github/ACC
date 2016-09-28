

/**
 * In this Java class, I will write a method that creates n random strings and inserts them in a hash table. 
 * The method should compute the average time for each insertion
 * @author brucelau
 *
 */
public class Task1 {
	
	protected int TABLE_SIZE = 1000; 
	Long startTime;
	Long endTime;
	BasicHashTable hashtable;
	RandomStrings rs;
	String[] strings;
	
	public Task1() {
		rs = new RandomStrings(TABLE_SIZE,20);
		hashtable = new BasicHashTable(TABLE_SIZE);
		strings = rs.generateStrings();
	}
	
	public Task1(int tableSize) {
		this.TABLE_SIZE = tableSize;
		rs = new RandomStrings(TABLE_SIZE,20);
		hashtable = new BasicHashTable(TABLE_SIZE);
		strings = rs.generateStrings();
	}
	
		
	public long calcualteAverageInsertTime(){
		
		
		
		//jog down start time
		startTime = System.currentTimeMillis();
		
		for(String s:strings) {
			
			hashtable.insert(s);
			//System.out.println(s+" was inserted!");
		}
		
		//jog down end time
		endTime = System.currentTimeMillis();
		
		return (endTime - startTime);
		
	}
	
	/**
	 * finds n random strings in the hash table. The method would delete the string if found. 
	 * It should also compute the average time of each search.
	 */
	public long calcualteAverageSearchTime(){
		
		
		startTime = System.currentTimeMillis();
		
		for(int i=0; i<TABLE_SIZE; i++) {

			if (hashtable.search(strings[i]) != -1) {
				hashtable.delete(i);
				//System.out.println(strings[i]+" was found!");
				
			}
			

		}
		
		endTime = System.currentTimeMillis();
		
		return (endTime - startTime);
		
	}
	
	
	public static void main(String[] args){
		
		int tableSize = 10000;
		Task1 t = new Task1(tableSize);
		
		System.out.println( "the inserting of " + tableSize + " strings costs " +  t.calcualteAverageInsertTime() + "ms\n");
		t.calcualteAverageSearchTime();
		System.out.println( "The Searching of " + tableSize + " strings costs " + t.calcualteAverageSearchTime() + "ms\n "
				);
		//System.out.println(Integer.MAX_VALUE + " " + Math.pow(2, 20));
	}

}
