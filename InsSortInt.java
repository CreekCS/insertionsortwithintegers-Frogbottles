import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class InsSortInt {
    public static void main(String[] args) throws Exception{
        File myObj = new File("randInts.txt");

        //ArrayList<File> unsortedList = new ArrayList<File>();
        ArrayList<Integer> unsortedList = new ArrayList<Integer>();

        try {
            Scanner sc = new Scanner(myObj);
            while (sc.hasNextLine()) {
                unsortedList.add(Integer.parseInt(sc.nextLine()));
            }
            sc.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int[] unsortedArray = new int[unsortedList.size()];
        for (int i = 0; i < unsortedList.size(); i++) {
            unsortedArray[i] = unsortedList.get(i);
        }

        for (int i = 0; i<unsortedArray.length; i++){
            int currentReference = unsortedArray[i];
            int counter = i-1;
            while (counter >=0&&unsortedArray[counter+1] < unsortedArray[counter]){
                int tempV = unsortedArray[counter+1];
                unsortedArray[counter+1] = unsortedArray[counter];
                unsortedArray[counter] = tempV;
                counter--;
            }
            unsortedArray[counter+ 1] = currentReference; 
        }
        System.out.println(unsortedArray[0]);
        System.out.println(unsortedArray[unsortedArray.length-1]);
    }
}
