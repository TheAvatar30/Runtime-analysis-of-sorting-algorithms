import java.util.Random;
//import java.util.Collections;

public class GroceryList{
    private List<Note> grocList;
    private Random rnd;
    private long comparisons = 0;

    public GroceryList() {
    	grocList = new List<Note>();
        rnd = new Random();
    }

    long[] timeChart(int numberElements, int repeat) {
    	long[] result = new long[3];
    	long time = 0;
    	
    	for(int i=0;i<repeat;i++) {			//Quicksort
    		time = time + timeQuick(numberElements);
    	}
    	result[0] = time/repeat;
    	time = 0;
    	
    	
    	for(int i=0;i<repeat;i++) {			//Insertionsort
    		time = time + timeInsertion(numberElements);
    	}
    	result[1] = time/repeat;
    	time = 0;
    	
    	
    	for(int i=0;i<repeat;i++) {			//Bubblesort
    		time = time + timeBubble(numberElements);
    	}
    	result[2] = time/repeat;
    	

        return result;
        
    }
    
    long timeInsertion(int numberElements){
    	randomList(numberElements);
    	long x = System.currentTimeMillis();
        List<Note> list = insertionSort(grocList);
    	long y = System.currentTimeMillis();
    	grocList = clearList(grocList);
    	
    	return (y-x);
    }
    
    long timeBubble(int numberElements){
    	randomList(numberElements);
    	long x = System.currentTimeMillis();
        List<Note> list = bubbleSort(grocList);
    	long y = System.currentTimeMillis();
    	grocList = clearList(grocList);
    	
    	return (y-x);
    }
    
    long timeQuick(int numberElements){
    	randomList(numberElements);
    	long x = System.currentTimeMillis();
        List<Note> list = quickSort(grocList);
    	long y = System.currentTimeMillis();
    	grocList = clearList(grocList);
    	
    	return (y-x);
    }
    
    long[] comparisonsChart(int numberElements, int repeat){
    	long[] result = new long[3];
        long comps = 0;
        
        for(int i=0;i<repeat;i++) {
        	comps = comps + comparisonsQuick(numberElements);
        }
        result[0] = comps/repeat;
        comps = 0;
        
        
        for(int i=0;i<repeat;i++) {
        	comps = comps + comparisonsInsertion(numberElements);
        }
        result[1] = comps/repeat;
        comps = 0;
        
        
        for(int i=0;i<repeat;i++) {
        	//comps = comps + comparisonsBubble(numberElements);
        }
        result[2] = comps/repeat;
    	
        return result;
    }
    
    long comparisonsInsertion(int numberElements){
        randomList(numberElements);
        comparisons = 0;
        List<Note> list = insertionSort(grocList);
        long comparisonsInsertion = comparisons;
        comparisons = 0;
        grocList = clearList(grocList);

        return comparisonsInsertion;
    }
    
    long comparisonsBubble(int numberElements){
        randomList(numberElements);
        comparisons = 0;
        List<Note> list = bubbleSort(grocList);
        long comparisonsBubble = comparisons;
        comparisons = 0;
        grocList = clearList(grocList);

        return comparisonsBubble;
    }
    
    long comparisonsQuick(int numberElements){
    	randomList(numberElements);
    	comparisons = 0;
        List<Note> list = quickSort(grocList);
        long comparisonsQuick = comparisons;
        comparisons = 0;
        grocList = clearList(grocList);

        return comparisonsQuick;
    }
    
    private void setOnList(String pName, int pNumber){
        Note pNote = new Note(pName, pNumber);
        grocList.append(pNote);
    }

    public void randomList(int numberElements){
        for(int i = 0; i < numberElements; i++){
            String n = "";
            for(int j = 0; j < 3; j++){
                int z = 65 + rnd.nextInt(58);
                char b = (char)z;
                n += b;
            }
            int a = 1 + rnd.nextInt(10);
            setOnList(n,a);
        }
        
    }

    private List<Note> quickSort(List<Note> pNote){
        List<Note> noteX = new List<Note>();
        List<Note> noteY = new List<Note>();
        
        int x = 0;
        int y = 0;
        pNote.toFirst();
        Note piv = pNote.getContent();
        pNote.remove();

        while(pNote.hasAccess()){
            if(pNote.getContent().isGreater(piv)){
                noteY.append(pNote.getContent());
                pNote.remove();
                y++;
            }else{
                noteX.append(pNote.getContent());
                pNote.remove();
                x++;
            }
            comparisons++;
        }
        
        if(y>0){
            noteY = this.quickSort(noteY);
        }
        if(x>0){
            noteX = this.quickSort(noteX);
        }

        pNote.concat(noteX);
        pNote.append(piv);
        pNote.concat(noteY);
        return pNote;

    }

    private List<Note> bubbleSort(List<Note> pNote){
        int length = 0;
        pNote.toFirst();
        while(pNote.hasAccess()){
            pNote.next();
            length++;
        }

        for(int i=0;i<length;i++){
            for(int j=0;j<length-1-i;j++){
                if(getPos(pNote, j).isGreater(getPos(pNote, j+1))){
                    pNote = change(pNote, j, j+1);
                }
                comparisons++;
            }
        }
        return pNote;
    }

    private Note getPos(List<Note> pNote, int x){
        pNote.toFirst();
        for(int i=0;i<x;i++){
            if(pNote.hasAccess()){
                pNote.next();
            }
        }
        return pNote.getContent();
    }

    private List<Note> insertionSort(List<Note> pNote){
        List<Note> liste = new List<Note>();
        pNote.toFirst();

        liste.append(pNote.getContent());
        liste.toFirst();
        pNote.remove();
        while(pNote.hasAccess()){

            if(liste.getContent().isGreater(pNote.getContent())){
                liste.insert(pNote.getContent());
                pNote.remove();
                liste.toFirst();
            }else{
                liste.next();
            }
            comparisons++;

            if(!liste.hasAccess()){
                liste.append(pNote.getContent());
                pNote.remove();
                liste.toFirst();

            }
        }
        return liste;
    }

    private List<Note> change(List<Note> pNote, int x, int y){
        pNote.toFirst();
        for(int i=0;i<x;i++){
            pNote.next();
        }
        Note noteX = new Note(pNote.getContent().returnName(), pNote.getContent().returnNumber());

        pNote.toFirst();
        for(int i=0;i<y;i++){
            pNote.next();
        }
        Note noteY = new Note(pNote.getContent().returnName(), pNote.getContent().returnNumber());
        pNote.setContent(noteX);

        pNote.toFirst();
        for(int i=0;i<x;i++){
            pNote.next();
        }
        pNote.setContent(noteY);

        return pNote;
    }
    
    List<Note> clearList(List<Note> pNote){
    	pNote.toFirst();
    	while(pNote.hasAccess()) {
    		pNote.remove();
    	}
		return pNote;
	}
}