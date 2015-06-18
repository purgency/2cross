import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Move3Engine extends AbstractEngine
{

    public Move3Engine(Map<String, Integer> valuemap)
    {
        _valuemap = valuemap;
    }

    @Override
    public String chooseMove(String position)
    {
        Set<String> unplayed = unplayed(position);
        ArrayList<String> played = played(position);
        String second = played.get(1);

        List<String> consider = new ArrayList<String>();

        consider.addAll(_edge);
        Set<String> removal = new HashSet<String>();
        for (String move : consider)
        {
            if (!unplayed.contains(move)) removal.add(move);

            boolean oneBoxDistant = false;

            Set<String> oBD1 = distanceShort(second);
            Set<String> BoW2 = getBoxesOfWall(move);
            for (String box : oBD1)
            {
                if (!oneBoxDistant)
                {
                    for (String boxS : BoW2)
                    {
                        if (boxS.equals(box)) oneBoxDistant = true;
                    }
                }
            }
            if ((!oneBoxDistant || isParallelNeighbor(move, second))
                    && removal.size() < 11) removal.add(move);
        }
        if (!inCenter(second))
        {
            for (String move : consider)
            {
                if ((_meridian.contains(move) || _equator.contains(move))
                        && removal.size() < 11) removal.add(move);
            }
        }
        consider.removeAll(removal);

        Collections.shuffle(consider); //TODO: possibly win/loss userstatistic for decision
        return consider.get(0);
    }
}
