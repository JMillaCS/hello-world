import java.util.*;

public class DogDatabase{
    private IDictionary<String, Dog> nameIndex;
    private IDictionary<Integer, Dog> licenseIndex;
    
    public DogDatabase(){
        nameIndex = new Dictionary<String, Dog>();
        licenseIndex = new Dictionary<Integer, Dog>();
       
    }
    
    public void addDog(Dog _dog){
        nameIndex.insert(_dog.getName(), _dog);
        licenseIndex.insert(_dog.getLicense(), _dog);
        }
        
    public void findByName(String _name){
        Dog search = nameIndex.find(_name);
        if(search != null){
         System.out.println("Dog Found:\n" + search.toString());
        }
        else{
         System.out.println("Dog could not be found.");    
        }
    }

    public void findByLicense(int _license){
        Dog search = licenseIndex.find(_license);
        if(search != null){
         System.out.println("Dog Found:\n" + search.toString());
        }
        else{
         System.out.println("Dog could not be found.");     
        }
    }
    
    public void delete(String _name){
       Dog remove = nameIndex.remove(_name);
       if(remove == null){
        System.out.println("Dog could not be removed.");
       }
       else{
        licenseIndex.remove(remove.getLicense());
        System.out.println(_name + " the dog has been removed.");
       }
    }
    
    public void printByName(){
       nameIndex.print();
    }
    
    public void printByLicense(){
       licenseIndex.print();
   }
}