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
        String last = position.substring(position.length()-3, position.length());
        //boolean sacrifice = isSacrifice(last, _valuemap);
        //checkforsacrifices and loonymoves

        Set<String> unplayed = unplayed(position);
        ArrayList<String> played = played(position);

        if ((_valuemap.get("turn") % 2) == 0) //first player turn
        {
            SearchP1(position, unplayed);
        }
        else
        {
            SearchP2(position, unplayed);
        }

        //AlphaBeta(position);

        return null;
    }

    public void SearchP1(String position1 ,Set<String> unplayed1)
    {
        if (!unplayed1.isEmpty())
        {
            for (String move : unplayed1)
            {
                Set<String> newUnplayed = new HashSet<String>();
                newUnplayed.addAll(unplayed1);
                newUnplayed.remove(move);
                String newPosition1 = position1.concat(move);
                
                if(isCorner(move))
                {
                    if(move=="a02")
                    {
                        newUnplayed.add("b01");
                    }
                    else if(move=="a10")
                    {
                        newUnplayed.add("b11");
                    }
                    else if(move=="k02")
                    {
                        newUnplayed.add("j01");
                    }
                    else if(move=="k10")
                    {
                        newUnplayed.add("j11");
                    }
                }

                SearchP2(newPosition1, newUnplayed);
            }
        }
        else
        {
            System.out.print("done");
        }
    }

    public void SearchP2(String position2, Set<String> unplayed2)
    {
        if (!unplayed2.isEmpty())
        {
            for (String move : unplayed2)
            {
                Set<String> newUnplayed = new HashSet<String>();
                newUnplayed.addAll(unplayed2);
                newUnplayed.remove(move);
                String newPosition2 = position2.concat(move);
                
                if(isCorner(move))
                {
                    if(move=="a02")
                    {
                        newUnplayed.add("b01");
                    }
                    else if(move=="a10")
                    {
                        newUnplayed.add("b11");
                    }
                    else if(move=="k02")
                    {
                        newUnplayed.add("j01");
                    }
                    else if(move=="k10")
                    {
                        newUnplayed.add("j11");
                    }
                }
                
                SearchP1(newPosition2, newUnplayed);
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
