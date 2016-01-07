/*
 * Copyright 2016 Dong Jin Du.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dongjindu.treeutils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Dong Jin Du
 */
public class TreePreorderTest extends TestCase {

    public TreePreorderTest(String testName) {
        super(testName);
        TestNode root = testData();
        TreePreorder<TestNode> preorder = new TreePreorderImpl(root);
        Integer i = 0;
        System.out.println("Testing running one time.");
        while (preorder.hasNext()) {
            TestNode tn = preorder.next();
            System.out.println("id of this testnode: " + tn.id);
            junit.framework.Assert.assertEquals(tn.id, testhm.get(i));
            i++;
        }

    }

    public static HashMap<Integer, Integer> testhm = new HashMap();
    public static TestNode testData() {
        TestNode node1 = new TestNode(1); testhm.put(0, 1);
        TestNode node11 = new TestNode(11);testhm.put(1, 11);
        TestNode node12 = new TestNode(12); testhm.put(2, 12);
        TestNode node13 = new TestNode(13); testhm.put(5, 13);
        TestNode node121 = new TestNode(121);testhm.put(3, 121);
        TestNode node122 = new TestNode(122); testhm.put(4, 122);
        node1.subs.add(node11);
        node1.subs.add(node12);
        node1.subs.add(node13);
        node12.subs.add(node121);
        node12.subs.add(node122);
        return node1;
    }

    public void testChildren() {
    }

    public void testNext() {
    }

    public void testHasNext() {
    }

    public class TreePreorderImpl extends TreePreorder {

        public TreePreorderImpl(TestNode root) {
            super(root);
        }

        public List children(Object parent) {
            return ((TestNode) parent).subs;
        }
    }

    public static class TestNode {

        public List<TestNode> subs = new ArrayList();
        public Integer id;

        public TestNode(int pId) {
            id = pId;
        }
    }
}
