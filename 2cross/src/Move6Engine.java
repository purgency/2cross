import java.util.*;

public class Move6Engine extends AbstractEngine
{
    
    public Move6Engine(Map<String, Integer> valuemap)
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
