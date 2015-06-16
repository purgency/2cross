import java.util.*;


public class Move4Engine extends AbstractEngine
{
    Map<String, Integer> _valuemap = new HashMap<String, Integer>();
    
    public Move4Engine(Map<String, Integer> valuemap)
    {
        _valuemap = valuemap;
    }
    
    @Override
    public String chooseMove(String position)
    {
        setNums(position);
        Set<String> unplayed = unplayed(position);
        ArrayList<String> played = played(position);
        
        List<String> consider = new ArrayList<String>();
        Set<String> removal = new HashSet<String>();
        
        if(_numCenterspoke >= 2)
        {
            consider.addAll(_centerspoke);
            consider.removeAll(played);
            for (String move : consider)
            {
                for (String already : played)
                {
                    if(isParallelNeighbor(move, already) || onStraightWith(move, already)) removal.add(move);
                }
            }
            consider.removeAll(removal);
        }
        
        Collections.shuffle(consider); //TODO: possibly win/loss userstatistic for decision
        return consider.get(0);
    }
}
