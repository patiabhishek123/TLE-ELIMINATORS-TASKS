import java.util.*;
public class TrieTrmplete {
    public class Node {
    Map<Character,Node> links;
    boolean isEnd;
    int count;

    Node(){
        links=new HashMap<>();
        isEnd=false;
    }
        
    }

    //Trie

    public class Trie {
        private final Node root;
        public Trie(){
            root=new Node();
        }
        //insert a word into the triw

        void insert(String word){
            Node curr=root;
            for(char ch:word.toCharArray())
            {
                curr=curr.links.computeIfAbsent(ch, c->new Node());
            }
            curr.isEnd=true;
        }

        //search
        
    }

}
