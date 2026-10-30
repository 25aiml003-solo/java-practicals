import java.util.*;
public class Leaderboard {
    private static final int TOP_N=3;
    public static void main(String[] args){
        Map<String,Integer> scores=new HashMap<>();
        scores.put("Asha",90);scores.put("Ravi",85);scores.put("Mira",95);scores.put("Dev",90);
        List<Map.Entry<String,Integer>> ranking=new ArrayList<>(scores.entrySet());
        ranking.sort(Map.Entry.<String,Integer>comparingByValue(Comparator.reverseOrder()).thenComparing(Map.Entry.comparingByKey()));
        for(int index=0;index<Math.min(TOP_N,ranking.size());index++){
            Map.Entry<String,Integer> entry=ranking.get(index);
            System.out.println((index+1)+". "+entry.getKey()+" - "+entry.getValue());
        }
    }
}
