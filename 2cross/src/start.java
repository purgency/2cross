import java.util.*;

public class start
{
    public static void main(String[] args)
    {
        String LINE = "f3";
        String result = play(convert(LINE), getturn(convert(LINE)));
        System.out.println(result);

    }
    
    public static String play(String game, int turn)
    {
        String position = game;
        AbstractEngine engine;
        
        switch(turn)
        {
            case 1: engine = new Move1Engine();
                break;
            case 2: engine = new Move2Engine();
                break;
            case 3: engine = new Move3Engine();
                break;
            case 4: engine = new Move4Engine();
                break;
            case 5: engine = new Move5Engine();
                break;
            case 6: engine = new Move6Engine();
                break;
            case 7: engine = new Move7Engine();
                break;
            default: engine = new EndgameEngine();
                break;
        }
        
        String move = engine.chooseMove(position);
        return move;
    }

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
    
    public static int getturn(String position)
    {
        String[] _boxes = {"b10", "b8", "b6", "b4", "b2", "d10", "d8", "d6", "d4",
                "d2", "f10", "f8", "f6", "f4", "f2", "h10", "h8", "h6", "h4", "h2",
                "j10", "j8", "j6", "j4", "j2"};
        Map<String, Integer> _boxmap = new HashMap<String, Integer>();
        
        for (int i = 0; i < _boxes.length; i++)
        {
            _boxmap.put(_boxes[i], 0);
        }
        
        int turn = 1;
        String line = position;

        for (int i = 0; i < line.length(); i += 3)
        {
            Boolean completedBox = false;
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
                    _boxmap.put(boxL, _boxmap.get(boxL) + 1);
                    if (_boxmap.get(boxL) == 4)
                    {
                        completedBox = true;
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
                    _boxmap.put(boxR, _boxmap.get(boxR) + 1);
                    if (_boxmap.get(boxR) == 4)
                    {
                        completedBox = true;
                        if (turn % 2 == 0)
                        {
                            _boxmap.put(boxR, 10);
                        }
                        else
                        {
                            _boxmap.put(boxR, 20);
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
                    switch (num)
                    {
                    case 1:
                        boxO = let + Integer.toString(num + 1);
                        break;
                    case 3:
                        boxO = let + Integer.toString(num + 1);
                        break;
                    case 5:
                        boxO = let + Integer.toString(num + 1);
                        break;
                    case 7:
                        boxO = let + Integer.toString(num + 1);
                        break;
                    case 9:
                        boxO = let + Integer.toString(num + 1);
                        break;

                    }
                    _boxmap.put(boxO, _boxmap.get(boxO) + 1);
                    if (_boxmap.get(boxO) == 4)
                    {
                        completedBox = true;
                    }
                }
                if (num != 01)
                {
                    String boxU = "";
                    switch (num)
                    {
                    case 3:
                        boxU = let + Integer.toString(num - 1);
                        break;
                    case 5:
                        boxU = let + Integer.toString(num - 1);
                        break;
                    case 7:
                        boxU = let + Integer.toString(num - 1);
                        break;
                    case 9:
                        boxU = let + Integer.toString(num - 1);
                        break;
                    case 11:
                        boxU = let + Integer.toString(num - 1);
                        break;

                    }
                    _boxmap.put(boxU, _boxmap.get(boxU) + 1);
                    if (_boxmap.get(boxU) == 4)
                    {
                        completedBox = true;
                    }
                }
            }
            if (!completedBox) turn++;
        }
        return turn;
    
    }
}
