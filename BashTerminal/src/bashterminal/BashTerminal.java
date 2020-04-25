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
public class BashTerminal extends DirectoryTree {

    public static void main(String[] args) {
       Scanner scantron = new Scanner(System.in);
       DirectoryTree Tree = new DirectoryTree();
       String input = "";
       do
       {
           System.out.print("[user@host]: $ ");
           input=scantron.next();
           switch(input)
           {
           case "pwd":
               System.out.println("label "+Tree.getCursor().getName());
               DirectoryNode dummy =Tree.getCursor();
               
               Tree.presentWorkingDirectory(dummy.getName());
           break;
           case "ls":String inp = scantron.nextLine();
           if(inp.trim().equalsIgnoreCase("-R"))
           {
               Tree.listDirectory();
           }else
           {
               Tree.listNames(0);
           }
           break;
           case "cd":
            String dir = scantron.nextLine();
            try{
                if(dir.trim().equalsIgnoreCase("/"))
                {
                    Tree.resetCursor();
                }else if(dir.trim().equalsIgnoreCase(". ."))
                {
                    Tree.getNodeParent(Tree.getCursor().getName());
                }else if(dir.trim().length()>10)
                {
                    //Tree.resetCursor();
                    String nStr = dir.replaceAll("/"," ");
                    Scanner scan = new Scanner(nStr);
                    while(scan.hasNext())
                    {
                        try{
                        String wStr = scan.next();
                        System.out.println(wStr);
                        Tree.changeDirectory(wStr);
                        }catch(ArrayIndexOutOfBoundsException e)
                        {
                        }
                        
                    }
                    
                }else
                {
                Tree.changeDirectory(dir);
                    System.out.println(dir);
                }
            }catch(ArrayIndexOutOfBoundsException| NotADirectoryException e)
            {
                System.out.println("Directory not found or a file");
            }
            break;
           case "mkdir":  
           String dir2 = scantron.nextLine();
           
           
           try{
               Tree.makeDirectory(dir2);
               
           }catch(NotADirectoryException e)
           {
               System.out.println(e);
           }
           
           break;
           case "touch": 
           String dir3 = scantron.nextLine();
           
           
               Tree.makeFile(dir3);
           
           break;
           case "exit": System.out.println("Terminating program...");
           break;
           case "find":
           String in = scantron.nextLine();
           Tree.findDirectory(in);
           break;
           case "mv":
                String direct = scantron.next();
                String transfer = scantron.next();
                Tree.resetCursor();
                String nStr = direct.replaceAll("/"," ");
                String nStr2 = transfer.replaceAll("/"," ");
                Scanner scan = new Scanner(nStr);
                Scanner scanner = new Scanner(nStr2);
                DirectoryNode copyCurs=new DirectoryNode();
                    while(scan.hasNext())
                    {
                        try{
                        String wStr = scan.next();
                        System.out.println(wStr);
                        Tree.changeDirectory(wStr);
                        DirectoryNode noed = Tree.getCursor();
                        copyCurs=noed;
                        }catch(ArrayIndexOutOfBoundsException|NotADirectoryException e)
                        {
                        }
                        
                    }
                    
                    
                    System.out.println("here " + copyCurs.getName());
                    Tree.removeBranch(0);
                   try{
                    while(scanner.hasNext())
                    {
                        try{
                        Tree.resetCursor();
                        String wStr2 = scanner.next();
                        System.out.println(wStr2);
                        Tree.changeDirectory(wStr2);
                        
                        }catch(ArrayIndexOutOfBoundsException|NotADirectoryException e)
                        {
                        }
                        
                    }
                    Tree.addChildArr(copyCurs, 0);
                   }catch(NotADirectoryException |FullDirectoryException e)
                   {
                   }
           break;
           default: System.out.println("Invalid input");
           break;
       
           }
       }while(!(input.equals("exit")));
    }
    
}
