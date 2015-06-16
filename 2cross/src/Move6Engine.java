import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Move6Engine extends AbstractEngine
{
    Map<String, Integer> _valuemap = new HashMap<String, Integer>();
    
    public Move6Engine(Map<String, Integer> valuemap)
    {
        _valuemap = valuemap;
    }
    
    @Override
    public String chooseMove(String position)
    {
        Set<String> unplayed = unplayed(position);
        Set<String> played = played(position);
        
        return null;
    }
}
