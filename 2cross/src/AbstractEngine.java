import java.util.*;

public abstract class AbstractEngine
{
    public static final Set<String> _all = new HashSet<String>(Arrays.asList(
            "b11", "d11", "f11", "h11", "j11", "b09", "d09", "f09", "h09",
            "j09", "b07", "d07", "f07", "h07", "j07", "b05", "d05", "f05",
            "h05", "j05", "b03", "d03", "f03", "h03", "j03", "b01", "d01",
            "f01", "h01", "j01", "a10", "c10", "e10", "g10", "i10", "k10",
            "a08", "c08", "e08", "g08", "i08", "k08", "a06", "c06", "e06",
            "g06", "i06", "k06", "a04", "c04", "e04", "g04", "i04", "k04",
            "a02", "c02", "e02", "g02", "i02", "k02"));
    public static final Set<String> _horizontal = new HashSet<String>(
            Arrays.asList("b11", "d11", "f11", "h11", "j11", "b09", "d09",
                    "f09", "h09", "j09", "b07", "d07", "f07", "h07", "j07",
                    "b05", "d05", "f05", "h05", "j05", "b03", "d03", "f03",
                    "h03", "j03", "b01", "d01", "f01", "h01", "j01"));
    public static final Set<String> _vertical = new HashSet<String>(
            Arrays.asList("a10", "c10", "e10", "g10", "i10", "k10", "a08",
                    "c08", "e08", "g08", "i08", "k08", "a06", "c06", "e06",
                    "g06", "i06", "k06", "a04", "c04", "e04", "g04", "i04",
                    "k04", "a02", "c02", "e02", "g02", "i02", "k02"));
    public static final Set<String> _top = new HashSet<String>(Arrays.asList(
            "b11", "d11", "f11", "h11", "j11", "b09", "d09", "f09", "h09",
            "j09", "b07", "d07", "f07", "h07", "j07", "a10", "c10", "e10",
            "g10", "i10", "k10", "a08", "c08", "e08", "g08", "i08", "k08"));
    public static final Set<String> _bottom = new HashSet<String>(
            Arrays.asList("b01", "d01", "f01", "h01", "j01", "b03", "d03",
                    "f03", "h03", "j03", "b05", "d05", "f05", "h05", "j05",
                    "a02", "c02", "e02", "g02", "i02", "k02", "a04", "c04",
                    "e04", "g04", "i04", "k04"));
    public static final Set<String> _equator = new HashSet<String>(
            Arrays.asList("a06", "c06", "e06", "g06", "i06", "k06"));
    public static final Set<String> _left = new HashSet<String>(Arrays.asList(
            "e10", "e08", "e06", "e04", "e02", "c10", "c08", "c06", "c04",
            "c02", "a10", "a08", "a06", "a04", "a02", "d11", "d09", "d07",
            "d05", "d03", "d01", "b11", "b09", "b07", "b05", "b03", "b01"));
    public static final Set<String> _right = new HashSet<String>(Arrays.asList(
            "g10", "g08", "g06", "g04", "g02", "i10", "i08", "i06", "i04",
            "i02", "k10", "k08", "k06", "k04", "k02", "h11", "h09", "h07",
            "h05", "h03", "h01", "j11", "j09", "j07", "j05", "j03", "j01"));
    public static final Set<String> _meridian = new HashSet<String>(
            Arrays.asList("f01", "f03", "f05", "f07", "f09", "f11"));
    public static final Set<String> _center = new HashSet<String>(
            Arrays.asList("f05", "e06", "g06", "f07"));
    public static final Set<String> _centerspoke = new HashSet<String>(
            Arrays.asList("d05", "e04", "g04", "h05", "h07", "g08", "e08",
                    "d07"));
    public static final Set<String> _outerspoke = new HashSet<String>(
            Arrays.asList("b03", "c02", "i02", "j03", "j09", "i10", "c10",
                    "b09"));
    public static final Set<String> _spike = new HashSet<String>(Arrays.asList(
            "b05", "b07", "e02", "g02", "j05", "j07", "e10", "g10"));
    public static final Set<String> _thirdrow = new HashSet<String>(
            Arrays.asList("c04", "c06", "c08", "d09", "f09", "h09", "i08",
                    "i06", "i04", "h03", "f03", "d03"));
    public static final Set<String> _edge = new HashSet<String>(Arrays.asList(
            "a04", "a06", "a08", "d11", "f11", "h11", "k08", "k06", "k04",
            "h01", "f01", "d01"));
    public static final Set<String> _corner = new HashSet<String>(
            Arrays.asList("a10", "b11", "j11", "k10", "a02", "b01", "j01",
                    "k02"));

    public int _numEdge = 0;
    public int _numCenter = 0;
    public int _numHorizontal = 0;
    public int _numVertical = 0;
    public int _numTop = 0;
    public int _numBottom = 0;
    public int _numLeft = 0;
    public int _numRight = 0;
    public int _numThirdRow = 0;
    public int _numCenterspoke = 0;

    public boolean isHorizontal(String move)
    {
        return _horizontal.contains(move);
    }

    public boolean isVertical(String move)
    {
        return _vertical.contains(move);
    }

    public boolean atTop(String move)
    {
        return _top.contains(move);
    }

    public boolean atBottom(String move)
    {
        return _bottom.contains(move);
    }

    public boolean onEquator(String move)
    {
        return _equator.contains(move);
    }

    public boolean atLeft(String move)
    {
        return _left.contains(move);
    }

    public boolean atRight(String move)
    {
        return _right.contains(move);
    }

    public boolean onMeridian(String move)
    {
        return _meridian.contains(move);
    }

    public boolean inCenter(String move)
    {
        return _center.contains(move);
    }

    public boolean isCenterspoke(String move)
    {
        return _centerspoke.contains(move);
    }

    public boolean isOuterspoke(String move)
    {
        return _outerspoke.contains(move);
    }

    public boolean isSpike(String move)
    {
        return _spike.contains(move);
    }

    public boolean onThirdrow(String move)
    {
        return _thirdrow.contains(move);
    }

    public boolean isEdge(String move)
    {
        return _edge.contains(move);
    }

    public boolean isCorner(String move)
    {
        return _corner.contains(move);
    }

    /**
     * returns set of unplayed lines
     * @param position the position
     * @return the set
     */
    public HashSet<String> unplayed(String position)
    {
        HashSet<String> unplayed = new HashSet<String>();

        for (String line : _all)
        {
            if (!(position.contains(line))) unplayed.add(line);
        }
        if (unplayed.contains("a02") && unplayed.contains("b01"))
            unplayed.remove("b01");
        if (unplayed.contains("a10") && unplayed.contains("b11"))
            unplayed.remove("b11");
        if (unplayed.contains("k10") && unplayed.contains("j11"))
            unplayed.remove("j11");
        if (unplayed.contains("k02") && unplayed.contains("j01"))
            unplayed.remove("j01");

        return unplayed;
    }

    /**
     * returns an ArrayList containing the played lines
     * @param position the position
     * @return the set
     */
    public ArrayList<String> played(String position)
    {
        ArrayList<String> played = new ArrayList<String>();

        for (int i = 0; i < position.length(); i += 3)
        {
            played.add(position.substring(i, i + 3));
        }
        return played;
    }

    /**
     * sets values for the classvariables (how many moves of a certain type are played)
     * @param position the position
     */
    public void setNums(String position)
    {
        String substring;
        for (int i = 0; position.length() > i; i += 3)
        {
            substring = position.substring(i, i + 3);

            if (isEdge(substring)) _numEdge++;
            if (inCenter(substring)) _numCenter++;
            if (isHorizontal(substring)) _numHorizontal++;
            if (isVertical(substring)) _numVertical++;
            if (atTop(substring)) _numTop++;
            if (atBottom(substring)) _numBottom++;
            if (atLeft(substring)) _numLeft++;
            if (atRight(substring)) _numRight++;
            if (onThirdrow(substring)) _numThirdRow++;
            if (isCenterspoke(substring)) _numCenterspoke++;

        }
    }

    //Nim()

    //AlphaBeta()

    //isLoony()

    //isSacrifice()

    //numQuads()

    public HashSet<String> getBoxesOfWall(String move)
    {
        HashSet<String> boxesofwall = new HashSet<String>();
        String box1;
        String box2;

        int num = Integer.parseInt(move.substring(1, 3));
        String let = move.substring(0, 1);
        String numS = start.convert(Integer.toString(num));
        String numP1 = start.convert(Integer.toString(num + 1));
        String numM1 = start.convert(Integer.toString(num - 1));
        String letP1 = null;
        String letM1 = null;

        if (isHorizontal(move))
        {
            box1 = let + numP1;
            box2 = let + numM1;
        }
        else
        {
            String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                    "k"};
            for (int i = 0; i < abc.length; i++)
            {
                if (let.equals(abc[i]))
                {
                    if (!let.equals("k")) letP1 = abc[i + 1];
                    if (!let.equals("a")) letM1 = abc[i - 1];
                }
            }

            box1 = letP1 + numS;
            box2 = letM1 + numS;
        }
        boxesofwall.add(box1);
        boxesofwall.add(box2);

        return boxesofwall;
    }

    public HashSet<String> distanceShort(String move)
    {
        HashSet<String> distanceShort = new HashSet<String>();

        HashSet<String> boxesofwall = getBoxesOfWall(move);

        for (String box : boxesofwall)
        {
            if (box != null && !box.contains("null"))
            {
                int num = Integer.parseInt(box.substring(1, 3));
                String let = box.substring(0, 1);
                String numS = start.convert(Integer.toString(num));
                String numP2 = start.convert(Integer.toString(num + 2));
                String numM2 = start.convert(Integer.toString(num - 2));
                String letP2 = null;
                String letM2 = null;
                String numP4 = start.convert(Integer.toString(num + 4));
                String numM4 = start.convert(Integer.toString(num - 4));
                String letP4 = null;
                String letM4 = null;

                String boxN[] = new String[6];

                boxN[0] = let + numP2;
                boxN[1] = let + numM2;

                String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i",
                        "j", "k"};
                for (int i = 0; i < abc.length; i++)
                {
                    if (let.equals(abc[i]))
                    {
                        if (!let.equals("j")) letP2 = abc[i + 2];
                        if (!let.equals("b")) letM2 = abc[i - 2];
                    }
                }

                boxN[2] = letP2 + numS;
                boxN[3] = letM2 + numS;

                if (isHorizontal(move) && (onEquator(move) || onMeridian(move)))
                {
                    for (int i = 0; i < abc.length; i++)
                    {
                        if (let.equals(abc[i]))
                        {
                            if (!let.equals("j") && !let.equals("h"))
                                letP4 = abc[i + 4];
                            if (!let.equals("b") && !let.equals("d"))
                                letM4 = abc[i - 4];
                        }
                    }
                    boxN[4] = letP4 + numS;
                    boxN[5] = letM4 + numS;
                }
                else if (onEquator(move) || onMeridian(move))
                {
                    boxN[4] = let + numP4;
                    boxN[5] = let + numM4;
                }

                for (int i = 0; i < 6; i++)
                {
                    if (boxN[i] != null && !boxN[i].contains("null"))
                        distanceShort.add(boxN[i]);
                }
            }
        }

        return distanceShort;
    }

    public boolean isParallelNeighbor(String Neighbor, String of)
    {
        boolean result = false;
        int num = Integer.parseInt(of.substring(1, 3));
        String let = of.substring(0, 1);
        String numS = start.convert(Integer.toString(num));
        String numP2 = start.convert(Integer.toString(num + 2));
        String numM2 = start.convert(Integer.toString(num - 2));
        String letP2 = null;
        String letM2 = null;

        if (isHorizontal(of))
        {
            if (Neighbor.equals(let + numP2) || Neighbor.equals(let + numM2))
                result = true;
        }
        else
        {
            String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                    "k"};
            for (int i = 0; i < abc.length; i++)
            {
                if (let.equals(abc[i]))
                {
                    if (!let.equals("j") && !let.equals("k"))
                        letP2 = abc[i + 2];
                    if (!let.equals("b") && !let.equals("a"))
                        letM2 = abc[i - 2];
                }
            }
            if (Neighbor.equals(letP2 + numS) || Neighbor.equals(letM2 + numS))
                result = true;
        }
        return result;
    }

    public boolean onStraightWith(String move1, String move2)
    {
        boolean result = false;
        String num1 = move1.substring(1, 3);
        String num2 = move2.substring(1, 3);
        String let1 = move1.substring(0, 1);
        String let2 = move2.substring(0, 1);

        if (isHorizontal(move1) && isHorizontal(move2))
        {
            if (num1.equals(num2)) result = true;
        }
        else if (isVertical(move1) && isVertical(move2))
        {
            if (let1.equals(let2)) result = true;
        }
        return result;
    }

    //isAdjacentNeighbor(move)

    /**
     * Algorithm to determine the move to play, individually different for each turn
     * @param position the position
     * @return the move to play
     */
    public abstract String chooseMove(String position);
}