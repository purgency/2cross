import java.util.*;

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
        ArrayList<String> played = played(position);
        
        return null;
    }
}
