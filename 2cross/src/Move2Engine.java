import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Move2Engine extends AbstractEngine
{
    public String chooseMove(String position)
    {
        setNums(position);
        Set<String> unplayed = unplayed(position);
        
        List<String> consider = new ArrayList<String>();
        
        if(numCenter==1)
        {
            if(position.equals("f05")) consider.addAll(new HashSet<String>(Arrays.asList("f09", "c08", "i08")));
            else if(position.equals("f07")) consider.addAll(new HashSet<String>(Arrays.asList("f03", "c04", "i04")));
            else if(position.equals("e06")) consider.addAll(new HashSet<String>(Arrays.asList("i06", "h09", "h03")));
            else consider.addAll(new HashSet<String>(Arrays.asList("c06", "d09", "d03")));
        }
        
        Collections.shuffle(consider); //TODO: possibly win/loss userstatistic for decision
        return consider.get(0);
    }
}
