
public class BasicHashTable {
	
	private int TABLE_SIZE = 1000;
	private String[] storage;
	
	public BasicHashTable(){
		
		storage = new String[TABLE_SIZE];
	}
	
	public BasicHashTable(int tableSize){
		
		TABLE_SIZE = tableSize;
		storage = new String[TABLE_SIZE];
	}
	
	public boolean insert(String s){
		
		int index = gethashValue(s);
		if(index == -1) return false;
		storage[index] = s;
		return true;
		
	}
	
	private int gethashValue(String s){
		
		int pointer;
		pointer = s.hashCode() % TABLE_SIZE;
		if( pointer < 0 ) pointer += TABLE_SIZE;
		if( storage[pointer] == null ) return pointer;
		
		return rehash(pointer);
	}
	private int rehash(int pointer){
		for(int i = 1 ; i < TABLE_SIZE; i++)
		{
			pointer = (pointer+i) %TABLE_SIZE;
			if( pointer < 0 ) pointer += TABLE_SIZE;
			if (storage[pointer] == null) return  pointer;
		}
		return -1;
	}
	
	public int search(String s){
		
		for(int i=0; i<TABLE_SIZE; i++){
			if(storage[i]!=null && storage[i].equals(s)) return i; 
		}
			
		return -1;
	}
	
	public void delete(int index){
		
		storage[index] = null;
	}
	

}
