import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Move5Engine extends AbstractEngine
{
    Map<String, Integer> _valuemap = new HashMap<String, Integer>();

    public Move5Engine(Map<String, Integer> valuemap)
    {
        _valuemap = valuemap;
    }

    public String chooseMove(String position)
    {
        Set<String> unplayed = unplayed(position);
        return null;
    }
}
