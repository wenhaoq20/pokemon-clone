
/**
 * Write a description of class wqe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class wqe
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class wqe
     */
    public static void main(String []args){
        int[] num = {-1,2,-4,6,7,-5,8};
        int dif = Math.abs(num[1]-num[0]); 
        for(int i = 1; i < num.length - 1; i++){
            if(Math.abs(num[i+1] - num[i]) > dif){
                dif = Math.abs(num[i+1] - num[i]);
            }
    }
    System.out.println(dif);
}
}
