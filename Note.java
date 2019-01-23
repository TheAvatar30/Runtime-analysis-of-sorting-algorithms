
public class Note implements ComparableContent<Note>
{
    private int number;
    private String name;

    public Note(String pName, int pNumber){
        name = pName;
        number = pNumber;
    }

    public String returnName(){
        return name;
    }

    public int returnNumber(){
        return number;
    }

    public boolean isGreater(Note pContent){
        if(this.returnName().compareTo(pContent.returnName()) > 0){
            return true;
        }
        return false;
    }

    public boolean isEqual(Note pContent){
        if(this.returnName().compareTo(pContent.returnName()) == 0){
            return true;
        }
        return false;
    }

    public boolean isLess(Note pContent){
        if(this.returnName().compareTo(pContent.returnName()) < 0){
            return true;
        }
        return false;
    }
    
}
