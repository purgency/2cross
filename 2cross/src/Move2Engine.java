import java.util.Set;


public class Move2Engine extends AbstractEngine
{
    public String chooseMove(String position)
    {
        Set<String> unplayed = unplayed(position);
        return "f9";
    }
}
