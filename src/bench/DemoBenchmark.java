package bench;


import java.util.*;

public class DemoBenchmark implements IBenchmark{

    // select sort algorithm

    private int size = 0;
    private Scanner scan = new Scanner(System.in);

    private ArrayList<Integer> arr;
    @Override
    public void run() {

        int  i, j, temp;

        Random random = new Random();
        for(int k=0; k<size; k++) {
            arr.add(random.nextInt());
        }


        Iterator<Integer> it = arr.iterator();
        //select sort algoritm using iterator
        while(it.hasNext()) {
            temp = it.next();
            for(i=0; i<size-1; i++) {
                if(arr.get(i) > arr.get(i+1)) {
                    j = arr.get(i);
                    arr.set(i, arr.get(i+1));
                    arr.set(i+1, j);
                }
            }
        }

        System.out.print("Now the Array after Sorting is :\n");
        for(i=0; i<size; i++)
        {
            System.out.print(arr.get(i)+ "  ");
        }
    }







    @Override
    public void initialize(Object... params) {

        System.out.print("Enter Array Size : ");
        size = scan.nextInt();
        arr = new ArrayList<Integer>();

    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }
}
