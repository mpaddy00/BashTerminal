/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bashterminal;

/**
 *
 * @author T420
 */
public class CustomException extends Exception{
    public class NotADirectoryException extends Exception
    {
    public NotADirectoryException(){}
    public NotADirectoryException(String message)
    {
        super(message);
    }
    }
    public class FullDirectoryException extends Exception{
        public FullDirectoryException(){}
        public FullDirectoryException(String message)
        {
            super(message);
        }
    }
}
