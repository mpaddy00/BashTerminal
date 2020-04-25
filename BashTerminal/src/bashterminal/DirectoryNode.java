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
public class DirectoryNode {
    private String name;
    private boolean isFile;
    private DirectoryNode left;
    private DirectoryNode middle;
    private DirectoryNode right;
    private String path="";
    final int MAX_NODES = 10;
    public  DirectoryNode []arrrr = new DirectoryNode[MAX_NODES];
    String rt="";
    public DirectoryNode()
    {
        name = "empty";
        isFile=false;
        
    }
    public DirectoryNode(String name, boolean isFile)
    {
        this.name=name;
        this.isFile=isFile;
    }
     //overloaded con for the n-ary tree
    public DirectoryNode(DirectoryNode[] arrrr)
    {
        
        for(int i =0;i<arrrr.length;i++)
        {
            arrrr[i] = new DirectoryNode();
        }
    }
    public DirectoryNode(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public DirectoryNode getLeft()
    {
        return this.left;
    }
    public DirectoryNode getMiddle()
    {
        return this.middle;
    }
    public DirectoryNode getRight()
    {
        return this.right;
    }
    public void setLeft(DirectoryNode left)
    {
        this.left=left;
    }
    public void setMiddle(DirectoryNode middle)
    {
        this.middle=middle;
    }
    public void setRight(DirectoryNode right)
    {
        this.right=right;
    }
    public boolean getIsFile()
    {
        return this.isFile;
    }
    public void setIsFile(boolean isFile)
    {
        this.isFile=isFile;
    }
    

     public void preOrdeR()
    {
        
        if(this.getIsFile()){
            
            System.out.println("     - "+name);
        }else
            
            System.out.println(" |- "+name);
        for(int i=0;i<MAX_NODES;i++)
        {
            if(arrrr[i]!=null)
            {
                
               
                arrrr[i].preOrdeR();

            }else{
                
                i++;
               
            }
        }
        
       
    }
    public void preOrderFind(String str)
    {
       
        
        System.out.println(name);
        for(int i=0;i<MAX_NODES;i++)
        {
            if(arrrr[i]!=null)
            {
                arrrr[i].preOrdeR();

            }
        }
    }
    public DirectoryNode preOrderFindLast(String str)
    {
        
        
        left =arrrr[0];
        return left;
    }
    
    public DirectoryNode getNode(int i)
    {
        return this.arrrr[i];
    }
    public void setNode(int i, DirectoryNode node)
    {
        
        this.arrrr[i] = node;
    }
    public void nodePath(String label)
    {
        boolean bool = false;
        
        if(!(name.equalsIgnoreCase("null")))
        {
        
        this.addString(name+"/");
        
        }
        if(bool=true)
        {
            System.out.print(this.getString());
            ClearString();
        }        
        for(int i=0;i<MAX_NODES;i++)
        {
           
            if(arrrr[i]!=null)
            {
                
                if(arrrr[i].getName().trim().equalsIgnoreCase(label.trim()))
                {
                    bool = true;
                    System.out.println("turning bool");
                }
                //ClearString();
                  arrrr[i].nodePath(label);
            }
          
            ClearString();
        }
      
    }
    public void ClearString ()
    {
        this.path="";
    }
    public void addString(String name)
    {
        this.setPath(this.getString().concat(name));
    }
    public String getString()
    {
        return path;
    }
    public void setPath(String path)
    {
        this.path=path;
    }
}
