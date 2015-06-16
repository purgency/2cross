import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Move6Engine extends AbstractEngine
{
    Map<String, Integer> _boxmap = new HashMap<String, Integer>();
    
    public Move6Engine(Map<String, Integer> boxmap)
    {
        _boxmap = boxmap;
    }
    
    public String chooseMove(String position)
    {
        Set<String> unplayed = unplayed(position);
        return null;
    }
}
