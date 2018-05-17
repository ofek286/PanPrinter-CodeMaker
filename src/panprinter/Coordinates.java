/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package panprinter;

/**
 * 
 * @author O.S.
 * @version Jan 30, 2016
 */
public class Coordinates {
    private int _x;
    private int _y;
    
    public Coordinates()
    {
        _x = 0;
        _y = 0;
    }
    
    public Coordinates(Coordinates coord)
    {
        _x = coord._x;
        _y = coord._y;
    }
    
    public Coordinates(int x, int y)
    {
        _x = x;
        _y = y;
    }
    
    public int getX()
    {
        return _x;
    }
    
    public int getY()
    {
        return _y;
    }
    
    public void setX(int x)
    {
        _x = x;
    }
    
    public void setY(int y)
    {
        _y = y;
    }
    
    public boolean equals(Coordinates other)
    {
        if (other == null)
            return false;
        else
            return ((_x == other._x) && (_y == other._y));
    }
    
    public String toString()
    {
        return "(" + _x + "," + _y + ")";
    }
}
