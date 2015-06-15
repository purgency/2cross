import java.util.*;

public class Move1Engine extends AbstractEngine
{
    public String chooseMove(String position)
    {
        List<String> consider = new ArrayList<String>();
        
        for (String line : _all)
        {
            if(_center.contains(line) || _edge.contains(line))
            {
                consider.add(line);
            }
        }
        Collections.shuffle(consider); //TODO: possibly win/loss userstatistic for decision
        return consider.get(0);
    }
}
