/*
 * At DoorDash, menus are updated daily even hourly to keep them up-to-date. Each menu can be regarded as a tree. A menu can have many categories; each category can have many menu_items; each menu_item can have many item_extras; An item_extra can have many item_extra_options…

class Node {
        String key;
        int value;
        boolean active;
        List<Node> children;
 }
We will compare the new menu sent from the merchant with our existing menu. Each item can be considered as a node in the tree. The definition of a node is defined above. Either value change or the active status change means the node has been changed. There are times when the new menu tree structure is different from existing trees, which means some nodes are set to null. In this case, we only do soft delete for any nodes in the menu. If that node or its sub-children are null, we will treat them ALL as inactive. There are no duplicate nodes with the same key.

Return the number of changed nodes in the tree.

        Existing tree                                        
         a(1, T)                                                
        /       \                                                          
     b(2, T)   c(3, T)                                               
    /     \           \                                                        
d(4, T) e(5, T)   f(6, T)                                               

        New tree 
        a(1, T)
            \
           c(3, F)
               \
               f(66, T)
a(1, T) a is the key, 1 is the value, T is True for active status
For example, there are a total of 5 changed nodes. Node b, Node d, Node e are automatically set to inactive. The active status of Node c and the value of Node f changed as well.

      Existing tree                                                   
        a(1, T)                                                 
      /         \                                                 
    b(2, T)   c(3, T)                                   
  /       \           \                                          
d(4, T) e(5, T)      g(7, T)                       

            New tree
            a(1, T)
          /        \                                             
   b(2, T)         c(3, T)  
   /    |    \           \    
d(4, T) e(5, T) f(6, T)    g(7, F) 
 */


import java.util.*;
public class Menu {
    public static class Node {
        String key;
        int value;
        boolean isActive;
        List<Node> children;
        
        public Node(String key, int value, boolean isActive) {
            this.key = key;
            this.value = value;
            this.isActive = isActive;
            this.children = new ArrayList<>();
        }
        
        public boolean equals(Node node) {
            if (node == null) {
                return false;
            }
            return this.key == node.key
                && this.value == node.value
                && this.isActive == isActive;
                        
        }
        public String toString() {
            return this.key;
        }
    }
    
    public static int getModifiedItems(Node oldMenu, Node newMenu) {
        if (oldMenu == null && newMenu == null) {
            return 0;
        }
        int count = 0;
        if (oldMenu == null || newMenu == null || !oldMenu.equals(newMenu)) {
            System.out.println(oldMenu + " " + newMenu);
            count++;
        }
        Map<String, Node> children1 = getChildNodes(oldMenu);
        Map<String, Node> children2 = getChildNodes(newMenu);
        
        for(String key: children1.keySet()){
                count += getModifiedItems(children1.get(key), children2.getOrDefault(key, null));
        }
        
        for(String key: children2.keySet()) {
            if(!children1.containsKey(key)) {
                count += getModifiedItems(null, children2.get(key));
            }
        }
        return count;
        
    
    }
    private static Map<String, Node> getChildNodes(Node menu) {
        Map<String, Node> map = new HashMap<>();
        if (menu == null) {
            return map;
        }
        for (Node node: menu.children) {
            map.put(node.key, node);
        }
        return map;
    }
    public static void main(String[] args) {
        Node a = new Node("a", 1, true);
        Node b = new Node("b", 2, true);
        Node c = new Node("c", 3, true);
        Node d = new Node("d", 4, true);
        Node e = new Node("e", 5, true);
        Node g = new Node("g", 7, true);
        
        a.children.add(b);
        a.children.add(c);
        
        b.children.add(d);
        b.children.add(e);
        
        Node a1 = new Node("a", 1, true);
        Node b1 = new Node("b", 2, true);
        Node c1 = new Node("c", 3, true);
        Node d1 = new Node("d", 4, true);
        Node e1 = new Node("e", 5, true);
        Node f1 = new Node("f", 6, true);
        Node g1 = new Node("g", 7, false);
        
        a1.children.add(b1);
        a1.children.add(c1);
        
        b1.children.add(d1);
        c1.children.add(e1);
        
        int count = getModifiedItems(a, a1);
        System.out.println("Changed Items are:" +count);
    }
}