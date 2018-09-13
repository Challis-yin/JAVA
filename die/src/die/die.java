package die;

public class die {
private final int MAX = 6;
private int face;
public die()
{face = 1;
}public int roll()
{face = (int)(Math.random()*MAX)+1;
return face;
}
public void setface (int value)
{face = value;
}public int get ()
{return face;

}public String toString()
{String result = Integer.toString(face);
return result;
}


}

