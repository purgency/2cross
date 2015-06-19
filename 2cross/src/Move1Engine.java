import java.util.*;

public class Move1Engine extends AbstractEngine
{
    @Override
    public String chooseMove(String position)
    {
        List<String> consider = new ArrayList<String>();

        for (String line : _allLines)
        {
            if (inCenter(line) || isEdge(line)) consider.add(line);
        }
        Collections.shuffle(consider); //TODO: possibly win/loss userstatistic for decision
        _valuemap.put(consider.get(0), 1);
        return consider.get(0);
    }
}
