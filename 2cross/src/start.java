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
        String LINE = "http://www.trmph.com/dnb/board#5,b11d9g6c10b9a10c6e8e6d5c8f9h7d7g8g4e4f3f5f7e2g2h3h1j1j3i2j5k2c2f1b3b5g10h11j11k10k8j7k6i6i4h5a2b1k4b7a8a6e10d11f11i10h9c4i8d1d3j9a4";
        String result = play(convert(LINE), getturn(convert(LINE)));
        System.out.println(result);

    }
    
    /**
     * Chooses the engine to use based on the turnnumber
     * @param game the position
     * @param turn the turnnumber
     * @return
     */
    public static String play(String game, int turn)
    {
        String position = game;
        AbstractEngine engine;
        
        switch(turn)
        {
            case 1: engine = new Move1Engine();
                break;
            case 2: engine = new Move2Engine(_valuemap);
                break;
            case 3: engine = new Move3Engine(_valuemap);
                break;
            case 4: engine = new Move4Engine(_valuemap);
                break;
            case 5: engine = new Move5Engine(_valuemap);
                break;
            case 6: engine = new Move6Engine(_valuemap);
                break;
            case 7: engine = new Move7Engine(_valuemap);
                break;
            default: engine = new EndgameEngine(_valuemap);
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
        String[] _boxes = {"b10", "b8", "b6", "b4", "b2", "d10", "d8", "d6", "d4",
                "d2", "f10", "f8", "f6", "f4", "f2", "h10", "h8", "h6", "h4", "h2",
                "j10", "j8", "j6", "j4", "j2"};
        
        
        for (int i = 0; i < _boxes.length; i++)
        {
            _valuemap.put(_boxes[i], 0);
        }
        _valuemap.put("scorep1", 0);
        _valuemap.put("scorep2", 0);
        
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
                    _valuemap.put(boxL, _valuemap.get(boxL) + 1);
                    if (_valuemap.get(boxL) == 4)
                    {
                        completedBox += 1;
                        
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
                    _valuemap.put(boxR, _valuemap.get(boxR) + 1);
                    if (_valuemap.get(boxR) == 4)
                    {
                        completedBox += 1;
                    }
                }
            }
            else
            //horizontal line
            {
                if (num != 11)
                {
                    String boxO = "";
//                    switch (num)
//                    {
//                    case 1:
                        boxO = let + Integer.toString(num + 1);
//                        break;
//                    case 3:
//                        boxO = let + Integer.toString(num + 1);
//                        break;
//                    case 5:
//                        boxO = let + Integer.toString(num + 1);
//                        break;
//                    case 7:
//                        boxO = let + Integer.toString(num + 1);
//                        break;
//                    case 9:
//                        boxO = let + Integer.toString(num + 1);
//                        break;
//
//                   }
                    _valuemap.put(boxO, _valuemap.get(boxO) + 1);
                    if (_valuemap.get(boxO) == 4)
                    {
                        completedBox += 1;
                    }
                }
                if (num != 01)
                {
                    String boxU = "";
//                    switch (num)
//                    {
//                    case 3:
                          boxU = let + Integer.toString(num - 1);
//                        break;
//                    case 5:
//                        boxU = let + Integer.toString(num - 1);
//                        break;
//                    case 7:
//                        boxU = let + Integer.toString(num - 1);
//                        break;
//                    case 9:
//                        boxU = let + Integer.toString(num - 1);
//                        break;
//                    case 11:
//                        boxU = let + Integer.toString(num - 1);
//                        break;
//
//                    }
                    _valuemap.put(boxU, _valuemap.get(boxU) + 1);
                    if (_valuemap.get(boxU) == 4)
                    {
                        completedBox += 1;
                    }
                }
            }

            if((turn+1)%2==0 && completedBox>0)
            {
                _valuemap.put("scorep1", ( _valuemap.get("scorep1")+completedBox));
            }
            else if (completedBox>0)
            {
                _valuemap.put("scorep2", ( _valuemap.get("scorep2")+completedBox));
            }
            if (completedBox==0) turn++;
        }
        return turn;
    
    }
}
