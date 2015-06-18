import java.util.*;

public abstract class AbstractEngine
{
    public static final String[] _allLines = {"b11", "d11", "f11", "h11",
            "j11", "b09", "d09", "f09", "h09", "j09", "b07", "d07", "f07",
            "h07", "j07", "b05", "d05", "f05", "h05", "j05", "b03", "d03",
            "f03", "h03", "j03", "b01", "d01", "f01", "h01", "j01", "a10",
            "c10", "e10", "g10", "i10", "k10", "a08", "c08", "e08", "g08",
            "i08", "k08", "a06", "c06", "e06", "g06", "i06", "k06", "a04",
            "c04", "e04", "g04", "i04", "k04", "a02", "c02", "e02", "g02",
            "i02", "k02"};
    public static final String[] _lineKeys = {"b10", "d10", "f10", "h10",
            "j10", "b08b10", "d08d10", "f08f10", "h08h10", "j08j10",
            "b06b08", "d06d08", "f06f08", "h06h08", "j06j08", "b04b06",
            "d04d06", "f04f06", "h04h06", "j04j06", "b02b04", "d02d04",
            "f02f04", "h02h04", "j02j04", "b02", "d02", "f02", "h02", "j02",
            "b10", "b10d10", "d10f10", "f10h10", "h10j10", "k10",
            "b08", "b08d08", "d08f08", "f08h08", "h08j08", "j08", "b06",
            "b06d06", "d06f06", "f06h06", "h06j06", "j06", "b04", "b04d04",
            "d04f04", "f04h04", "h04j04", "j04", "b02", "b02d02", "d02f02",
            "f02h02", "h02j02", "j02"};
    public static final String[] _allBoxes = {"b10", "b08", "b06", "b04",
            "b02", "d10", "d08", "d06", "d04", "d02", "f10", "f08", "f06",
            "f04", "f02", "h10", "h08", "h06", "h04", "h02", "j10", "j08",
            "j06", "j04", "j02"};
    public static final String[] _boxKeys = {"b11a10c10b09", "b09a08c08b07",
            "b07a06c06b05", "b05a04c04b03", "b03a02c02b01", "d11c10e10d09",
            "d09c08e08d07", "d07c06e06d05", "d05c04e04d03", "d03c02e02d01",
            "f11e10g10f09", "f09e08g08f07", "f07e06g06f05", "f05e04g04f03",
            "f03e02g02f01", "h11g10i10h09", "h09g08i08h07", "h07g06i06h05",
            "h05g04i04h03", "h03g02i02h01", "j11i10k10j09", "j09i08k08j07",
            "j07i06k06j05", "j05i04k04j03", "j03i02k02j01"};
    public static final Set<String> _parallelNeighbors = new HashSet<String>(
            Arrays.asList("a10c10", "a08c08", "a06c06", "a04c04", "a02c02",
                    "c10e10", "c08e08", "c06e06", "c04e04", "c02e02", "e10g10",
                    "e08g08", "e06g06", "e04g04", "e02g02", "g10i10", "g08i08",
                    "g06i06", "g04i04", "g02i02", "i10k10", "i08k08", "i06k06",
                    "i04k04", "i02k02", "b11b09", "d11d09", "f11f09", "h11h09",
                    "j11j09", "b09b07", "d09d07", "f09f07", "h09h07", "j09j07",
                    "b07b05", "d07d05", "f07f05", "h07h05", "j07j05", "b05b03",
                    "d05d03", "f05f03", "h05h03", "j05j03", "b03b01", "d03d01",
                    "f03f01", "h03h01", "j03j01"));
    public static final Set<String> _adjacentNeighbors = new HashSet<String>(
            Arrays.asList("b11a10", "d11c10", "f11e10", "h11g10", "j11i10",
                    "b11c10", "d11e10", "f11g10", "h11i10", "j11k10", "b09a10",
                    "d09c10", "f09e10", "h09g10", "j09i10", "b09c10", "d09e10",
                    "f09g10", "h09i10", "j09k10", "b09a08", "d09c08", "f09e08",
                    "h09g08", "j09i08", "b09c08", "d09e08", "f09g08", "h09i08",
                    "j09k08", "b07a08", "d07c08", "f07e08", "h07g08", "j07i08",
                    "b07c08", "d07e08", "f07g08", "h07i08", "j07k08", "b07a06",
                    "d07c06", "f07e06", "h07g06", "j07i06", "b07c06", "d07e06",
                    "f07g06", "h07i06", "j07k06", "b05a06", "d05c06", "f05e06",
                    "h05g06", "j05i06", "b05c06", "d05e06", "f05g06", "h05i06",
                    "j05k06", "b05a04", "d05c04", "f05e04", "h05g04", "j05i04",
                    "b05c04", "d05e04", "f05g04", "h05i04", "j05k04", "b03a04",
                    "d03c04", "f03e04", "h03g04", "j03i04", "b03c04", "d03e04",
                    "f03g04", "h03i04", "j03k04", "b03c04", "d03e04", "f03g04",
                    "h03i04", "j03k04", "b03c02", "d03e02", "f03g02", "h03i02",
                    "j03k02", "b01a02", "d01c02", "f01e02", "h01g02", "j01i02",
                    "b01c02", "d01e02", "f01g02", "h01i02", "j01k02"));
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
    public static final Map<String, String> _keymap = new HashMap<String, String>();
    static Map<String, Integer> _valuemap = new HashMap<String, Integer>();

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

    public AbstractEngine()
    {
        for (int i = 0; i < _allLines.length; i++)
        {
            _keymap.put(_allLines[i], _lineKeys[i]);
        }
        for (int i = 0; i < _allBoxes.length; i++)
        {
            _keymap.put(_allBoxes[i], _boxKeys[i]);
        }
    }

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

        for (String line : _allLines)
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

    public boolean isLoony(String move)
    {
        boolean result = false;

        if (!isSacrifice(move))
        {
            return false;
        }
        HashSet<String> boxesofwall = getBoxesOfWall(move);

        return result;
    }

    public boolean isSacrifice(String move)
    {
        HashSet<String> boxesofwall = getBoxesOfWall(move);
        for (String box : boxesofwall)
        {
            if (_valuemap.get(box) == 3) return true;
        }

        return false;
    }

    //numQuads()

    public HashSet<String> getBoxesOfWall(String move)
    {
        HashSet<String> boxesofwall = new HashSet<String>();

        String boxes = _keymap.get(move);
        String box1 = boxes.substring(0, 3);
        boxesofwall.add(box1);

        if (boxes.length() == 6)
        {
            String box2 = boxes.substring(3, 6);
            boxesofwall.add(box2);
        }

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

    public boolean isParallelNeighbor(String move1, String move2)
    {
        if (_parallelNeighbors.contains(move1 + move2)
                || _parallelNeighbors.contains(move2 + move1))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean isAdjacentNeighbor(String move1, String move2)
    {
        if (_adjacentNeighbors.contains(move1 + move2)
                || _adjacentNeighbors.contains(move2 + move1))
        {
            return true;
        }
        else
        {
            return false;
        }
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

    /**
     * Algorithm to determine the move to play, individually different for each turn
     * @param position the position
     * @return the move to play
     */
    public abstract String chooseMove(String position);
}