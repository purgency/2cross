import java.util.*;

public class Move4Engine extends AbstractEngine
{

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

        String third = played.get(2);
        String second = played.get(1);

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
                    {
                        removal.add(move);
                        break;
                    }
                }
            }
            consider.removeAll(removal);
        }
        else
        {
            Set<String> oBD1 = distanceShort(third);
            Set<String> BoWsecond = getBoxesOfWall(second);

            boolean close = false;
            for (String box : oBD1)
            {
                if (!close)
                {
                    for (String boxS : BoWsecond)
                    {
                        if (boxS.equals(box))
                        {
                            close = true;
                            break;
                        }
                    }
                }
            }

            if (isEdge(third) && close)
            {
                for (String spoke : _outerspoke)
                {
                    if (isAdjacentNeighbor(spoke, third))
                    {
                        consider.add(spoke);
                        break;
                    }
                }
            }
            else
            {
                for (String move : unplayed)
                {
                    for (String already : played)
                    {
                        if (onThirdrow(already) && onThirdrow(move))
                        {
                            if (!(isParallelNeighbor(move, third) && isEdge(third)))
                            {
                                if ((onMeridian(move) || onEquator(move))
                                        && onStraightWith(move, already))
                                {
                                    consider.add(move);
                                    break;
                                }
                                else if (!(onMeridian(move) || onEquator(move)))
                                {
                                    if (onStraightWith(move, already))
                                    {
                                        consider.add(move);
                                        break;
                                    }
                                    else
                                    {
                                        if (isAdjacentNeighbor(move, already))
                                        {
                                            consider.add(move);
                                            break;
                                        }
                                    }
                                }
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
