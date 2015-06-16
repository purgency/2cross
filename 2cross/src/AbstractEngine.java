import java.util.*;

public abstract class AbstractEngine
{
    public static final Set<String> _all = new HashSet<String>(Arrays.asList("b11", "d11", "f11", "h11", "j11", "b09", "d09", "f09", "h09", "j09", "b07", "d07", "f07", "h07", "j07", "b05", "d05", "f05", "h05", "j05", "b03", "d03", "f03", "h03", "j03", "b01", "d01", "f01", "h01", "j01", "a10", "c10", "e10", "g10", "i10", "k10", "a08", "c08", "e08", "g08", "i08", "k08", "a06", "c06", "e06", "g06", "i06", "k06", "a04", "c04", "e04", "g04", "i04", "k04", "a02", "c02", "e02", "g02", "i02", "k02"));
    public static final Set<String> _horizontal = new HashSet<String>(Arrays.asList("b11", "d11", "f11", "h11", "j11", "b09", "d09", "f09", "h09", "j09", "b07", "d07", "f07", "h07", "j07", "b05", "d05", "f05", "h05", "j05", "b03", "d03", "f03", "h03", "j03", "b01", "d01", "f01", "h01", "j01"));
    public static final Set<String> _vertical = new HashSet<String>(Arrays.asList("a10", "c10", "e10", "g10", "i10", "k10", "a08", "c08", "e08", "g08", "i08", "k08", "a06", "c06", "e06", "g06", "i06", "k06", "a04", "c04", "e04", "g04", "i04", "k04", "a02", "c02", "e02", "g02", "i02", "k02"));
    public static final Set<String> _top = new HashSet<String>(Arrays.asList("b11","d11","f11","h11","j11","b09","d09","f09","h09","j09","b07","d07","f07","h07","j07","a10","c10","e10","g10","i10","k10","a08","c08","e08","g08","i08","k08"));
    public static final Set<String> _bottom = new HashSet<String>(Arrays.asList("b01","d01","f01","h01","j01","b03","d03","f03","h03","j03","b05","d05","f05","h05","j05","a02","c02","e02","g02","i02","k02","a04","c04","e04","g04","i04","k04"));
    public static final Set<String> _equator = new HashSet<String>(Arrays.asList("a06", "c06", "e06", "g06", "i06", "k06"));
    public static final Set<String> _left = new HashSet<String>(Arrays.asList("e10", "e08", "e06", "e04", "e02", "c10", "c08", "c06", "c04", "c02", "a10", "a08", "a06", "a04", "a02", "d11", "d09", "d07", "d05", "d03", "d01", "b11", "b09", "b07", "b05", "b03", "b01"));
    public static final Set<String> _right = new HashSet<String>(Arrays.asList("g10", "g08", "g06", "g04", "g02", "i10", "i08", "i06", "i04", "i02", "k10", "k08", "k06", "k04", "k02", "h11", "h09", "h07", "h05", "h03", "h01", "j11", "j09", "j07", "j05", "j03", "j01"));
    public static final Set<String> _meridian = new HashSet<String>(Arrays.asList("f01", "f03", "f05", "f07", "f09", "f11"));
    public static final Set<String> _center = new HashSet<String>(Arrays.asList("f05", "e06", "g06", "f07"));
    public static final Set<String> _centerspoke = new HashSet<String>(Arrays.asList("d05", "e04", "g04", "h05", "h07", "g08", "e08", "d07"));
    public static final Set<String> _outerspoke = new HashSet<String>(Arrays.asList("b03", "c02", "i02", "j03", "j09", "i10", "c10", "b09"));
    public static final Set<String> _spike = new HashSet<String>(Arrays.asList("b05", "b07", "e02", "g02", "j05", "j07", "e10", "g10"));
    public static final Set<String> _thirdrow = new HashSet<String>(Arrays.asList("c04", "c06", "c08", "d09", "f09", "h09", "i08", "i06", "i04", "h03", "f03", "d03"));
    public static final Set<String> _edge = new HashSet<String>(Arrays.asList("a04", "a06", "a08", "d11", "f11", "h11", "k08", "k06", "k04", "h01", "f01", "d01"));
    public static final Set<String> _corner = new HashSet<String>(Arrays.asList("a10", "b11", "j11", "k10", "a02", "b01", "j01", "k02"));
   
    public int numEdge = 0;
    public int numCenter = 0;
    public int numHorizontal = 0;
    public int numVertical = 0;
    public int numTop = 0;
    public int numBottom = 0;
    public int numLeft = 0;
    public int numRight = 0;
    public int numThirdRow = 0;
    public int numCenterspoke = 0;
    
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
    
    public HashSet<String> unplayed(String position)
    {
        HashSet<String> unplayed = new HashSet<String>();
        
        for (String line : _all)
        {
            if(!(position.contains(line)))
            {
                unplayed.add(line);
            }
        }
        return unplayed;
    }
    
    public void setNums(String position)
    {
        String substring;
        for(int i=0;position.length()>i;i+=3)
        {
            substring = position.substring(i, i+3);
            if(isEdge(substring))
            {
                numEdge++;
            }
            if(inCenter(substring))   
            {
                numCenter++;
            }
            if(isHorizontal(substring))
            {
                numHorizontal++;
            }
            if(isVertical(substring))
            {
                numVertical++;
            }
            if(atTop(substring))
            {
                numTop++;
            }
            if(atBottom(substring))
            {
                numBottom++;
            }
            if(atLeft(substring))
            {
                numLeft++;
            }
            if(atRight(substring))
            {
                numRight++;
            }
            if(onThirdrow(substring))
            {
                numThirdRow++;
            }
            if(isCenterspoke(substring))
            {
                numCenterspoke++;
            }

        }
    }
    
    //Nim()
    
    //AlphaBeta()
    
    //isLoony()
    
    //isSacrifice()
 
    public abstract String chooseMove(String position);
}