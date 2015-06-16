import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


public class Move2Engine extends AbstractEngine
{
    public String chooseMove(String position)
    {
        setNums(position);
        Set<String> unplayed = unplayed(position);
        
        List<String> consider = new ArrayList<String>();
        
        
        Collections.shuffle(consider); //TODO: possibly win/loss userstatistic for decision
        return consider.get(0);
    }
}
