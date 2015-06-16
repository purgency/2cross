import java.util.*;


public class Move5Engine extends AbstractEngine
{
    Map<String, Integer> _valuemap = new HashMap<String, Integer>();

    public Move5Engine(Map<String, Integer> valuemap)
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
