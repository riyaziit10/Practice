package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by riyaz on 28/6/15.
 */
class SumCountPair {
    int sum;
    int count;
    ArrayList<Integer> array;

    public SumCountPair() {
        this(0,0);
    }

    public SumCountPair(int sum, int count){
        this(sum,count,new ArrayList<Integer>());
    }

    public SumCountPair(int sum, int count, ArrayList<Integer> array) {
        this.sum = sum;
        this.count = count;
        this.array = (ArrayList<Integer>) array.clone();
    }

    public void add(int num) {
        sum += num;
        ++count;
        array.add(num);
    }

    public double average() {
        return (double)sum / count;
    }

    public String toString() {
        return array.toString();
    }

    @Override
    public SumCountPair clone() {
        return  new SumCountPair(sum, count, array);
    }
}
public class SubSetAverage {

    private void hashMaping(ArrayList<SumCountPair> arrayList) {

        Map<Double, List<SumCountPair>> map = new HashMap<Double, List<SumCountPair>>();
        for(SumCountPair pair: arrayList){
            List<SumCountPair> temp = map.get(pair.average());
            if(temp == null) {
                temp = new ArrayList<SumCountPair>();
                temp.add(pair);
            } else {
                temp.add(pair);
            }
            map.put(pair.average(),temp);
        }

        for(Double average: map.keySet()){
            List<SumCountPair> list = map.get(average);
            if(list.size() == 1)
                continue;
            for(SumCountPair sumCountPair: list){
                System.out.print(sumCountPair);
            }
            System.out.println();
        }

    }
    public void subsetAverage(int [] arr) {
        int arrLength = arr.length;
        ArrayList<SumCountPair> arrayList = new ArrayList<SumCountPair>();
        for(int i = 0; i < arrLength; ++i){
            int num = arr[i];
            ArrayList<SumCountPair> tempTable = new ArrayList<SumCountPair>();
            for(SumCountPair pair: arrayList){
                SumCountPair temp = pair.clone();
                temp.add(num);
                tempTable.add(temp);
            }
            arrayList.addAll(tempTable);
            SumCountPair itself = new SumCountPair();
            itself.add(num);
            arrayList.add(itself);
        }
        System.out.println(arrayList);
        hashMaping(arrayList);
    }
    public static void main(String[] args) {
        int[] arr = { 4, 1, 7, 8, 3, 5 };
        new SubSetAverage().subsetAverage(arr);

    }
}
