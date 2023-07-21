import java.util.*;

public class TensPlaceSorting
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] A1 =new int[n];
        int[] A2 =new int[n];
        for(int i=0;i<n;i++)
        {
            A1[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            A2[i]=sc.nextInt();
        }
        int[] sortedA1 = sortArray(A1);
        int[] sortedA2 = sortArray(A2);
        System.out.println(Arrays.toString(sortedA1));
        System.out.println(Arrays.toString(sortedA2));
    }

    public static int[] sortArray(int[] arr)
    {
        Integer[] boxedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedArr, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer a,Integer b) {
                int tensA=(a%100)/10;
                int tensB=(b%100)/10;
                if (tensA==tensB)
                {
                    return b-a;
                }
                else
                {
                    return tensA-tensB;
                }
            }
        });
        int[] sortedArr = Arrays.stream(boxedArr).mapToInt(Integer::intValue).toArray();
        return sortedArr;
    }
}
