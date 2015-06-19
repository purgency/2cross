import java.util.*;

public class EndgameEngine extends AbstractEngine
{

    public EndgameEngine(Map<String, Integer> valuemap)
    {
        _valuemap = valuemap;
    }

    public String chooseMove(String position)
    {
        String last = position.substring(position.length() - 3,
                position.length());
        //boolean sacrifice = isSacrifice(last);
        //boolean loony = isLoony(last);
        Set<String> unplayed = unplayed(position);
        ArrayList<String> played = played(position);

        if ((_valuemap.get("turn") % 2) == 0) //first player turn
        {
            SearchP1(last, unplayed);
        }
        else
        {
            SearchP2(last, unplayed);
        }

        //AlphaBeta(position);

        return null;
    }

    public void SearchP1(String last, Set<String> unplayed)
    {
        if (!unplayed.isEmpty())
        {
            if (isSacrifice(last))
            {
                String taken = takeFreeBoxes(last, false);
                for (int i = 0; i < taken.length(); i += 3)
                {
                    unplayed.remove(taken.substring(i, i + 3));
                }
            }
            Set<String> newUnplayed = new HashSet<String>();

            for (String move : unplayed)
            {
                newUnplayed.addAll(unplayed);
                newUnplayed.remove(move);

                if (isCorner(move))
                {
                    if (move == "a02")
                    {
                        if (_valuemap.get("b01") == 0) newUnplayed.add("b01");
                    }
                    else if (move == "a10")
                    {
                        if (_valuemap.get("b11") == 0) newUnplayed.add("b11");
                    }
                    else if (move == "k02")
                    {
                        if (_valuemap.get("j01") == 0) newUnplayed.add("j01");
                    }
                    else if (move == "k10")
                    {
                        if (_valuemap.get("j11") == 0) newUnplayed.add("j11");
                    }
                }

                SearchP2(move, newUnplayed);
            }
        }
        else
        {
            System.out.print("done");
        }
    }

    public void SearchP2(String last, Set<String> unplayed)
    {
        if (!unplayed.isEmpty())
        {
            if (isSacrifice(last))
            {
                String taken = takeFreeBoxes(last, false);
                for (int i = 0; i < taken.length(); i += 3)
                {
                    unplayed.remove(taken.substring(i, i + 3));
                }
            }
            Set<String> newUnplayed = new HashSet<String>();

            for (String move : unplayed)
            {
                newUnplayed.addAll(unplayed);
                newUnplayed.remove(move);

                if (isCorner(move))
                {
                    if (move == "a02")
                    {
                        if (_valuemap.get("b01") == 0) newUnplayed.add("b01");
                    }
                    else if (move == "a10")
                    {
                        if (_valuemap.get("b11") == 0) newUnplayed.add("b11");
                    }
                    else if (move == "k02")
                    {
                        if (_valuemap.get("j01") == 0) newUnplayed.add("j01");
                    }
                    else if (move == "k10")
                    {
                        if (_valuemap.get("j11") == 0) newUnplayed.add("j11");
                    }
                }

                SearchP1(move, newUnplayed);
            }
        }
        else
        {
            System.out.print("done");
        }
    }

    public int getScore(String position)
    {
        return 0;
    }
}
