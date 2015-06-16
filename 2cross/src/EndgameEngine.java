import java.util.*;

public class EndgameEngine extends AbstractEngine
{
    Map<String, Integer> _valuemap = new HashMap<String, Integer>();
    
    public EndgameEngine(Map<String, Integer> valuemap)
    {
        _valuemap = valuemap;
    }
    
    public String chooseMove(String position)
    {
        //checkforsacrifices and loonymoves
        
        Set<String> unplayed = unplayed(position);
        ArrayList<String> played = played(position);
        
        //AlphaBeta(position);
        
        return null;
    }
}
