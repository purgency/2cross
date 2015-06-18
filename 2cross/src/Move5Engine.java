import java.util.*;


public class Move5Engine extends AbstractEngine
{

    public Move5Engine(Map<String, Integer> valuemap)
    {
        _valuemap = valuemap;
    }

    @Override
    public String chooseMove(String position)
    {
        //checkforsacrifices and loonymoves
        
        Set<String> unplayed = unplayed(position);
        ArrayList<String> played = played(position);
        
        return null;
    }
}
