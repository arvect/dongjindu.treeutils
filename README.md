# dongjindu.treeutils
Tree traverser implementation. Currently only preorder implemented. Lighter and faster than Guava but require user to return list interface. It is stricter requirement than iterable.  

##Usage example:  
&nbsp;&nbsp;TreePreorder<TestNode> preorder = new TreePreorder(root){  
&nbsp;&nbsp;&nbsp;&nbsp;             TreePreorder<TestNode> preorder1 = new TreePreorder<TestNode>(root) {  
&nbsp;&nbsp;&nbsp;&nbsp;            @Override  
&nbsp;&nbsp;&nbsp;&nbsp;            public List<TestNode> children(TestNode parent) {
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                return <a list of TestNode>;
&nbsp;&nbsp;&nbsp;&nbsp;            }  
&nbsp;&nbsp;        };  
  
Then the tree can be navigated as,   
&nbsp;&nbsp;while (preorder.hasNext()) {  
&nbsp;&nbsp;&nbsp;&nbsp;TestNode tnode = preorder.next()  
&nbsp;&nbsp;}  

When 1e8 nodes navigated in my computer, this implementation is 20 percent faster than google guava TreeTraverser.
