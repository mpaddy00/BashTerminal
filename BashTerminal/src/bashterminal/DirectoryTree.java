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
import java.util.*;
import bashterminal.CustomException.*;
//change to n-ary from ternary tree?
public class DirectoryTree extends DirectoryNode {
    CustomException e = new CustomException();
    CustomException.FullDirectoryException fullE = e.new FullDirectoryException();
    private DirectoryNode root;
    private DirectoryNode cursor;
    DirectoryNode ref;
    /* Initializes a DirectoryTree object with a single DirectoryNode named "root"
    @Postconditions
        The tree contains a single DirectoryNode named "root" and both cursor
    and root reference this node
    
    */
    public DirectoryTree()
    {
        this.root= new DirectoryNode("root");
        cursor = root;
        
    }/*
    Adds newChild to any of the open child positions of this node a[0] through
    a[9]
    @Preconditions:
        Node is not a file and there is one empty position in the child of this
    node
    @postconditions:
        newChild has been added to the child of this node 
    @Throws:
    NotADirectoryException: if the current node is a a file
    FullDirectoryException: Thrown if all child references of this directory
    are occupied
    */
    
    
   public DirectoryNode addChildArr(DirectoryNode newChild, int i) throws NotADirectoryException, FullDirectoryException       
    {
        
       
        DirectoryNode newN= new DirectoryNode(this.getName());
        if(cursor.getIsFile())
        {
            throw e.new NotADirectoryException("can't add a child to a file");
        }
        if(i>=MAX_NODES)
        {
            throw e.new FullDirectoryException("Max Nodes reached");
        }
        if(root==null)
        {
            this.root = newN;
            
        }else
        {
            
                if(cursor.getNode(i)==null||cursor.getNode(i).getName().equalsIgnoreCase("empty"))
                {
                  cursor.setNode(i,newChild);
                  
                  
                }else
                {
                    System.out.println(cursor.getNode(i).getName());
                    return addChildArr(newChild, ++i);
                }
            }
        return newN;
        
    }
   /*moves the cursor to the root node
   @Postconditions
    The cursor now refernces the root node of the tree
   
   */
   public void resetCursor()
    {
        cursor = this.root;
    }
    public DirectoryNode getNodeReferenceR(String label, int i)
    {
       
        
        if(this.root==null)
        {
            return null;
        }else
        {
           
            if(root.getName().equals(label))
            {
                ref =root;
                return ref;
            }else if(cursor.getNode(i)!=null&&cursor.getNode(i).getName().trim().equalsIgnoreCase(label.trim()))
            {
                ref = cursor.getNode(i);
                return ref;
                
            }else if(i>=MAX_NODES)
            {
                throw new IllegalArgumentException("file not found among "
                        + "direct children");
                
            }else
            {
                getNodeReferenceR(label, ++i);
            }
        }
                return ref;
    }
    /* Moves the cursor to the directory with the name indictated by the name
    @Preconditions 
        name references a valid directory and doesn't references a file
    @Postconditions
        The cursor now references the directory with the name indicated by name
    If a child could not be found the user is prompted to enter a different 
    directory name is thrown
    @Throws
    NotADirectoryException: Thrown if node is a file
    
    
    */
    public void changeDirectory(String name ) throws NotADirectoryException//implement exception
    {
        
            cursor = getNodeReferenceR(name,0);
            if(cursor.getIsFile())
            {
                throw e.new NotADirectoryException("Cannot change directory into a file.");
            }
        
    }
    /*Returns a string containing a path of directory names from the root node of
    the tree to the cursor with each name separated by a forward slash
    @Postconditions
        The cursor remains at the same DirectoryNode
    
    */
    public void presentWorkingDirectory(String name)
    {
        
        root.nodePath(name);
    }
    public void listNames(int i)
    {
        String str ="";
        if(cursor.getNode(i)!=null)
        {
            System.out.print(cursor.getNode(i).getName()+ "  ");
            listNames(++i);
        }
    }
    public void removeBranch(int i)
    {
        if(cursor.getNode(i)!=null)
        {
            System.out.println("it's an i "+cursor.getNode(i).getName());
            cursor.setNode(i, null);

            //presentWorkingDirectory(++i);
        }
    }
    /*Returns a string containing a space seperated list of names of all the child
    directories or files of the cursor
    @Postconditions
        The curosr remains at the same DirectoryNode
    @Returns
        A formatted String of DirectoryNode names
    
    */
    public void listDirectory()
    {
         root.preOrdeR();
    }

    public void findDirectory(String str)
    {
        root.preOrderFind(str);
        System.out.print(str.trim());
    }
    /*Prints a formatted nested list of names of all the nodes in the directory
    tree, starting from the cursor
    @Postconditions
        The cursor remains at the same directoryNode
    
    */
    public void printDirectoryTree()
    {
          root.preOrdeR();
    }
    /*Creates a directory with the indicated name and adds it to the children
    to the children of the cursor node
    @Parameters
        name - the name of the directory field
    @Preconditions
        name is a legal argument
    @Postconditions
        A new directory node has been added to the children of the cursor, or
    an exception has been thrown
    @Throws
    IllegalArgumentException: Thrown if the 'name' argument is invalid
    FullDirectoryException: Thrown if all child references are occupied
    
    */
    public void makeDirectory(String name) throws NotADirectoryException //implement exceptions
    {
        name = name.trim();
        DirectoryNode dummy = new DirectoryNode(name, false);
        try{
            if(name.contains(" ")||name.contains("/"))
            {
                throw new IllegalArgumentException("");
            }
        this.addChildArr(dummy, 0);
        }catch(NotADirectoryException|FullDirectoryException e)
                {
                    System.out.println("Directory is full ");
                }catch(IllegalArgumentException e)
                {
                    System.out.println("Name contains a space or backslash");
                }
    }
    /*Creates a file with the indicated name and adds it to the children of the
    cursor node
    @parameters
        name - the name of the file to add
    @Preconditions 
        'name' is a legal argument does not contain spaces or forwards slashes
    @Postconditions
        A new DirectoryNode has been added to the children of the cursor, or an
    exception has been thrown
    @Throws
    IllegalArgumentException: thrown if the name is invalid
    FullDirectoryException: Thrown if all child references of this directory
    are occupied
    
    */
    public void makeFile(String name)//implement exception
    {
        name = name.trim();
       DirectoryNode dummy = new DirectoryNode(name.trim(), true);
        try{
            if(name.contains(" ")||name.contains("/"))
            {
                throw new IllegalArgumentException("");
            }
        this.addChildArr(dummy, 0);
        }catch(NotADirectoryException|FullDirectoryException e)
                {
                    System.out.println("Directory is full ");
                }catch(IllegalArgumentException e)
                {
                    System.out.println("Name contains a space or backslash");
                }
    }
    public  DirectoryNode getCursor()
    {
        return this.cursor;
    }
    public DirectoryNode getRoot()
    {
        return this.root;
    }
    public void getNodeParent(String str)
    {
        DirectoryNode hold=new DirectoryNode();
        if(!(root.preOrderFindLast(str).getName().equalsIgnoreCase("root")))
        {
        hold = root.preOrderFindLast(str);
        
        }
        cursor = hold;
    }
    public String getPath(String str)
    {
       
        String nStr = str.replaceAll("/", " ");
        Scanner scan = new Scanner(nStr);
        while(scan.hasNext())
        {
            nStr = scan.next();
            System.out.println(nStr.trim());
            return nStr;
            
            
        }
        return "";
    }
    
}
