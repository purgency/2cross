import java.util.*;

public class start
{
    private static int _turn = 1;
    
    
    public static void main(String[] args)
    {
        String result = play(convert("g6"));
        System.out.println(result);

    }
    
    public static String play(String game)
    {
        for (int i=0;i<game.length();i+=3)
        {
            if(new HashSet<String>(Arrays.asList("a","b","c","d", "e", "f", "g", "h", "i", "j", "k")).contains(Character.toString(game.charAt(i))))
            {
                _turn++;
            }
        }
        String position = game;
        AbstractEngine engine;
        
        switch(_turn)
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
    
}
