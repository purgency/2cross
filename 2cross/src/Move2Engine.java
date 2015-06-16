import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Move2Engine extends AbstractEngine
{
    Map<String, Integer> _boxmap = new HashMap<String, Integer>();
    
    public Move2Engine(Map<String, Integer> boxmap)
    {
        _boxmap = boxmap;
    }
    
    @Override
    public String chooseMove(String position)
    {
        setNums(position);
        Set<String> unplayed = unplayed(position);
        ArrayList<String> played = played(position);
        
        List<String> consider = new ArrayList<String>();
        
        if(_numCenter==1)
        {
            if(position.equals("f05")) consider.addAll(new HashSet<String>(Arrays.asList("f09", "c08", "i08")));
            else if(position.equals("f07")) consider.addAll(new HashSet<String>(Arrays.asList("f03", "c04", "i04")));
            else if(position.equals("e06")) consider.addAll(new HashSet<String>(Arrays.asList("i06", "h09", "h03")));
            else consider.addAll(new HashSet<String>(Arrays.asList("c06", "d09", "d03")));
        }
        else
        {
            consider.addAll(_thirdrow);
            
            Set<String> removal = new HashSet<String>();
            for(String move : consider)
            {
                if(played.contains(move)) removal.add(move);
                else if(_numTop==1 && atTop(move)) removal.add(move);
                else if(_numBottom==1 && atBottom(move)) removal.add(move);
                else if(_numLeft==1 && atLeft(move)) removal.add(move);
                else if(_numRight==1 && atRight(move)) removal.add(move);
            }
            if(_numCenterspoke==1)
            {
                for(String move : _centerspoke)
                {
                    if(unplayed.contains(move))
                    {
                        consider.add(move);
                    }
                }
            }
            consider.removeAll(removal);
        }
        
        Collections.shuffle(consider); //TODO: possibly win/loss userstatistic for decision
        return consider.get(0);
    }
}
