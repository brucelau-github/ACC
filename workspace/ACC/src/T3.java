import hashTable.*;

/**
 * from i=1 to 20;
 * n=math.pow(2,i)
 * set tableSize=n
 * rs.get n Randomstrings
 * sht= new sht(n);
 * timer.tick
 * 
 * 
 * @author brucelau
 *
 */

public class T3 extends Task1 {
	
	private BasicHashTable bht;
	private SeparateChainingHashTable<String> sht;
	private CuckooHashTable<String> cht;
	private QuadraticProbingHashTable<String> qht;
	private int[][] insertData = new int[20][4]; // 20 = i,[4]={ht,sht,cht,qht}
	private int[][] searchData = new int[20][4]; // 20 = i,[4]={ht,sht,cht,qht}
	private int[] nData = new int[20];
	
	public T3(int tableSize){
		super(tableSize);
	}
	
	public static void main(String[] args){
		
		T3 task3 = new T3(100);
		task3.run();
		task3.print();
	}
	public void run(){
		int n;
		for(int i=0; i<12 ; i++ ){
			n = (int) Math.pow(2, i+1);
			nData[i] = n;
			calcuate(n,i);
			
		}
	}
	private void setTableSize(int tableSize){
		
		this.TABLE_SIZE = tableSize;
		rs = new RandomStrings(TABLE_SIZE,20);
		strings = rs.generateStrings();
	}
	private void calcuate(int tableSize,int i){
		setTableSize(tableSize);
		
		//basic hashtable
		bht = new BasicHashTable(TABLE_SIZE);
		
		startTime = System.currentTimeMillis();
		for(String s:strings) {		
			bht.insert(s);
		}
		endTime = System.currentTimeMillis();
		insertData[i][0] =(int)(endTime - startTime);
		
		startTime = System.currentTimeMillis();
		for(int j=0; j<TABLE_SIZE; j++) {

			if (bht.search(strings[j]) != -1) {
				bht.delete(j);
			}
		}
		endTime = System.currentTimeMillis();
		searchData[i][0] =(int)(endTime - startTime);
						
		//cuckHashTAble
		
		cht = new CuckooHashTable<>( new StringHashFamily( 2 ), TABLE_SIZE);
		
		startTime = System.currentTimeMillis();
		for(String s:strings) {		
			cht.insert(s);
		}
		endTime = System.currentTimeMillis();
		insertData[i][1] =(int)(endTime - startTime);
		
		startTime = System.currentTimeMillis();
		for(String s:strings) {		
			cht.remove(s);
		}
		endTime = System.currentTimeMillis();
		searchData[i][1] =(int)(endTime - startTime);
		
		//QuadraticProbingHashTable
		
		qht = new QuadraticProbingHashTable<>(TABLE_SIZE);
		
		startTime = System.currentTimeMillis();
		for(String s:strings) {		
			qht.insert(s);
		}
		endTime = System.currentTimeMillis();
		insertData[i][2] =(int)(endTime - startTime);
		
		
		startTime = System.currentTimeMillis();
		for(String s:strings) {		
			qht.remove(s);
		}
		endTime = System.currentTimeMillis();
		searchData[i][2] =(int)(endTime - startTime);
		
		//SeparateChainingHashTable
		sht = new SeparateChainingHashTable<>(TABLE_SIZE);
		
		startTime = System.currentTimeMillis();
		for(String s:strings) {		
			sht.insert(s);
		}
		endTime = System.currentTimeMillis();
		insertData[i][3] =(int)(endTime - startTime);
		
		startTime = System.currentTimeMillis();
		for(String s:strings) {		
			sht.remove(s);
		}
		endTime = System.currentTimeMillis();
		searchData[i][3] =(int)(endTime - startTime);
		
		
		startTime = System.currentTimeMillis();
		for(String s:strings) {		
			sht.remove(s);
		}
		endTime = System.currentTimeMillis();
		searchData[i][2] =(int)(endTime - startTime);
		
		
	}
	
	public void print(){
		
		for(int i=0; i<20; i++){
			System.out.println(i + " " + insertData[i][0] + "\t" + insertData[i][1] + "\t" + insertData[i][2]+ "\t" + insertData[i][3]);
		}
		
	}
}