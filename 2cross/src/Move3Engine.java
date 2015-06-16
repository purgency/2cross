import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Move3Engine extends AbstractEngine
{
    Map<String, Integer> _valuemap = new HashMap<String, Integer>();
    
    public Move3Engine(Map<String, Integer> valuemap)
    {
        _valuemap = valuemap;
    }
    
    @Override
    public String chooseMove(String position)
    {
        Set<String> unplayed = unplayed(position);
        ArrayList<String> played = played(position);
        
        List<String> consider = new ArrayList<String>();
        
        consider.addAll(_edge);
        Set<String> removal = new HashSet<String>();
        for(String move : consider)
        {
            if(!unplayed.contains(move)) removal.add(move);
            if(_meridian.contains(move) || _equator.contains(move)) removal.add(move);
        }
        consider.removeAll(removal);
        
        Collections.shuffle(consider); //TODO: possibly win/loss userstatistic for decision
        return consider.get(0);
    }
}
