public class MyHash{
	
	int capacity;
	int[] hashTable ;
	public MyHash(int capacity){
	    this.capacity = capacity;
	    hashTable = new int[capacity];
	    for(int i=0; i<hashTable.length; i++){
	        hasTable[i] = -1;
	    }
	}

	public void insert(int val){
        int slot = val%capacity;
        // if slot is empty , insert
        if(hashTable[slot] == -1 || hashTable[slot] == -2){
            hasTable[slot] = val;
        }
        else{
        // linear probling
            int newSlot = (slot+1)%capacity;
            while( newSlot != -1 && newSlot != -2){
                if(newSlot == slot)
                    return ;
                newSlot = (newSlot+1)%capacity;
            }
            if(hasTable[newSlot] == -1 || hasTable[newSlot] == -2)
            	hasTable[newSlot] = val;
        }

	}

	public boolean search(int val){
        int slot = val%capacity;
        if(hashTable[slot] == val)
            return true;
        else{
            // linear probling
            int newSlot = (slot+1)%capacity;
            while( hashTable[newSlot] != -1){
                if(newSlot == slot)
                    return false; // element doesnt exist in the array
                if(hasTable[newSlot] == val)
                    return true;
                newSlot = (newSlot+1)%capacity;
            }
            return false;
        }

	}

	public void erase(int val){
		int slot = val%capacity;
        if(hashTable[slot] == val)
            hasTable[newSlot] = -2;
        else{
            // linear probling
            int newSlot = (slot+1)%capacity;
            while( newSlot != -1){
                if(newSlot == slot)
                    return; // element doesnt exist in the array
                if(hasTable[newSlot] == val)
                    hasTable[newSlot] = -2;
                newSlot = (newSlot+1)%capacity;
            }
            return;
        }
	}

	public void printHashTable(){
	    System.out.print("[");
        for(int val : hashTable)
            System.out.print(" "+ val+ " ");
	    System.out.println("]");
	}
}