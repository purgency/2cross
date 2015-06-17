import java.util.*;

public class Move4Engine extends AbstractEngine
{
    Map<String, Integer> _valuemap = new HashMap<String, Integer>();

    public Move4Engine(Map<String, Integer> valuemap)
    {
        _valuemap = valuemap;
    }

    @Override
    public String chooseMove(String position)
    {
        setNums(position);
        Set<String> unplayed = unplayed(position);
        ArrayList<String> played = played(position);

        List<String> consider = new ArrayList<String>();
        Set<String> removal = new HashSet<String>();

        if (_numCenterspoke >= 2)
        {
            consider.addAll(_centerspoke);
            consider.removeAll(played);
            for (String move : consider)
            {
                for (String already : played)
                {
                    if (isParallelNeighbor(move, already)
                            || onStraightWith(move, already))
                        removal.add(move);
                }
            }
            consider.removeAll(removal);
        }
        else
        {
            for (String move : unplayed)
            {
                for (String already : played)
                {
                    if (onThirdrow(already) && onThirdrow(move))
                    {
                        if ((onMeridian(move) || onEquator(move))
                                && onStraightWith(move, already))
                        {
                            consider.add(move);
                        }
                        else if (!(onMeridian(move) || onEquator(move)))
                        {
                            if (onStraightWith(move, already))
                            {
                                consider.add(move);
                            }
                            else
                            {
                                Set<String> BoW1 = getBoxesOfWall(move);
                                Set<String> BoW2 = getBoxesOfWall(already);

                                boolean sharebox = false;

                                for (String box1 : BoW1)
                                {
                                    for (String box2 : BoW2)
                                    {
                                        if (box1.equals(box2)) sharebox = true;
                                    }
                                }

                                if (sharebox) consider.add(move);
                            }
                        }
                    }
                }
            }
        }

        Collections.shuffle(consider); //TODO: possibly win/loss userstatistic for decision
        return consider.get(0);
    }
}
