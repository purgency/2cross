import java.util.*;

/**
 * Doublecross is a knowledge-based AI for the Dots and Boxes game
 * @author Philipp Quach
 *
 */

public class start
{
    static Map<String, Integer> _valuemap = new HashMap<String, Integer>();

    public static void main(String[] args)
    {
        String LINE = "http://www.trmph.com/dnb/board#5,f7f5g8i8i6i4g4a10a8a6a4a2g6";
        String result = play(convert(LINE), getturn(convert(LINE)));
        System.out.println(result);

    }

    /**
     * Chooses the engine to use based on the turnnumber
     * @param game the position
     * @param turn the turnnumber
     * @return move to play
     */
    public static String play(String game, int turn)
    {
        String position = game;
        AbstractEngine engine;

        switch (turn)
        {
        case 1:
            engine = new Move1Engine();
            break;
        case 2:
            engine = new Move2Engine(_valuemap);
            break;
        case 3:
            engine = new Move3Engine(_valuemap);
            break;
        case 4:
            engine = new Move4Engine(_valuemap);
            break;
        case 5:
            engine = new Move5Engine(_valuemap);
            break;
        case 6:
            engine = new Move6Engine(_valuemap);
            break;
        case 7:
            engine = new Move7Engine(_valuemap);
            break;
        default:
            engine = new EndgameEngine(_valuemap);
            break;
        }

        String move = engine.chooseMove(position);
        return move;
    }

    /**
     * turns trmph-line into one the AI can understand
     * @param trmph the trmph-line
     * @return the position in AI-language
     */
    public static String convert(String trmph)
    {
        String line = trmph;
        line = line.replace("http://", "");
        line = line.replace("https://", "");
        line = line.replace("www.", "");
        line = line.replace("trmph.com/dnb/board#5,", "");
        line = line.replace("0", "00");
        line = line.replace("2", "02");
        line = line.replace("3", "03");
        line = line.replace("4", "04");
        line = line.replace("5", "05");
        line = line.replace("6", "06");
        line = line.replace("7", "07");
        line = line.replace("8", "08");
        line = line.replace("9", "09");
        line = line.replace("b1", "b01");
        line = line.replace("d1", "d01");
        line = line.replace("f1", "f01");
        line = line.replace("h1", "h01");
        line = line.replace("j1", "j01");
        line = line.replace("011", "11");
        line = line.replace("000", "0");
        line = line.replace("100", "10");
        line = line.replace("010", "10");

        return line;
    }

    /**
     * determines turnnumber and
     * initializes the valuemap
     * @param position the position
     * @return the determined turnnumber
     */
    public static int getturn(String position)
    {
        String[] _values = {"b10", "b08", "b06", "b04", "b02", "d10", "d08",
                "d06", "d04", "d02", "f10", "f08", "f06", "f04", "f02", "h10",
                "h08", "h06", "h04", "h02", "j10", "j08", "j06", "j04", "j02",
                "scorep1", "scorep2", "b11", "d11", "b11", "d11", "f11", "h11",
                "j11", "b09", "d09", "f09", "h09", "j09", "b07", "d07", "f07",
                "h07", "j07", "b05", "d05", "f05", "h05", "j05", "b03", "d03",
                "f03", "h03", "j03", "b01", "d01", "f01", "h01", "j01", "a10",
                "c10", "e10", "g10", "i10", "k10", "a08", "c08", "e08", "g08",
                "i08", "k08", "a06", "c06", "e06", "g06", "i06", "k06", "a04",
                "c04", "e04", "g04", "i04", "k04", "a02", "c02", "e02", "g02",
                "i02", "k02"};

        for (int i = 0; i < _values.length; i++)
        {
            _valuemap.put(_values[i], 0);
        }
        int turn = 1;
        String line = position;

        for (int i = 0; i < line.length(); i += 3)
        {
            int completedBox = 0;
            String move = line.substring(i, i + 3);
            char let = move.charAt(0);
            int num = Integer.parseInt(move.substring(1, 3));
            if (num % 2 == 0) //vertical line
            {
                if (let != 'a')
                {
                    String boxL = "";
                    switch (let)
                    {
                    case 'c':
                        boxL = "b" + Integer.toString(num);
                        break;
                    case 'e':
                        boxL = "d" + Integer.toString(num);
                        break;
                    case 'g':
                        boxL = "f" + Integer.toString(num);
                        break;
                    case 'i':
                        boxL = "h" + Integer.toString(num);
                        break;
                    case 'k':
                        boxL = "j" + Integer.toString(num);
                        break;

                    }
                    String newBoxL = convert(boxL);
                    _valuemap.put(newBoxL, _valuemap.get(newBoxL) + 1);
                    if (_valuemap.get(newBoxL) == 4)
                    {
                        completedBox += 1;
                        if ((turn % 2)+1 == 0)
                        {
                            _valuemap.put(newBoxL, 5);
                        }
                        else
                        {
                            _valuemap.put(newBoxL, 6);
                        }

                    }
                }
                if (let != 'k')
                {
                    String boxR = "";
                    switch (let)
                    {
                    case 'a':
                        boxR = "b" + Integer.toString(num);
                        break;
                    case 'c':
                        boxR = "d" + Integer.toString(num);
                        break;
                    case 'e':
                        boxR = "f" + Integer.toString(num);
                        break;
                    case 'g':
                        boxR = "h" + Integer.toString(num);
                        break;
                    case 'i':
                        boxR = "j" + Integer.toString(num);
                        break;

                    }
                    String newBoxR = convert(boxR);
                    _valuemap.put(newBoxR, _valuemap.get(newBoxR) + 1);
                    if (_valuemap.get(newBoxR) == 4)
                    {
                        completedBox += 1;
                        if ((turn % 2)+1 == 0)
                        {
                            _valuemap.put(newBoxR, 5);
                        }
                        else
                        {
                            _valuemap.put(newBoxR, 6);
                        }
                    }
                }
            }
            else
            //horizontal line
            {
                if (num != 11)
                {
                    String boxO = "";
                    boxO = let + Integer.toString(num + 1);
                    String newBoxO = convert(boxO);
                    _valuemap.put(newBoxO, _valuemap.get(newBoxO) + 1);
                    if (_valuemap.get(newBoxO) == 4)
                    {
                        completedBox += 1;
                        if ((turn % 2)+1 == 0)
                        {
                            _valuemap.put(newBoxO, 5);
                        }
                        else
                        {
                            _valuemap.put(newBoxO, 6);
                        }
                    }
                }
                if (num != 01)
                {
                    String boxU = "";
                    boxU = let + Integer.toString(num - 1);

                    String newBoxU = convert(boxU);
                    _valuemap.put(newBoxU, _valuemap.get(newBoxU) + 1);
                    if (_valuemap.get(newBoxU) == 4)
                    {
                        completedBox += 1;
                        if ((turn % 2)+1 == 0)
                        {
                            _valuemap.put(newBoxU, 5);
                        }
                        else
                        {
                            _valuemap.put(newBoxU, 6);
                        }
                    }
                }
            }

            if ((turn + 1) % 2 == 0 && completedBox > 0)
            {
                _valuemap.put("scorep1",
                        (_valuemap.get("scorep1") + completedBox));
            }
            else if (completedBox > 0)
            {
                _valuemap.put("scorep2",
                        (_valuemap.get("scorep2") + completedBox));
            }
            if (completedBox == 0) turn++;
        }

        for (int i=0;i<position.length();i+=3)
        {
            _valuemap.put(position.substring(i, i+3), 1);
        }
        _valuemap.put("turn", turn);
        return turn;
    }
}
