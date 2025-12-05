package TryCatch_with_Resourses;

public class Resourses implements AutoCloseable{
    private final String name ;

    Resourses(String name){
        this.name = name;
        System.out.println("Creating the Resourse " + name);
    }

    public void use(){
        System.out.println("Using the resourse" + name);
    }

    @Override
    public void close() throws Exception{
        System.out.println("Closing resourses " + name);
    }

    protected void finialize() throws Throwable{
        System.out.println("Finalize block executed");
    }

    public static void main(String args[]){
        final String myresourses = "MyImpResourses";
        try(Resourses  r = new Resourses(myresourses);){
            int arr[] = new int[3];
            arr[3] = 4;
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            System.out.println("Always executed wheather excception is thrown or not!");
        }
        System.gc();
    }
}
