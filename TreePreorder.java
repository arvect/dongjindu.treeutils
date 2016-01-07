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
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Dong Jin Du
 * @param <T> Object class to be iterated.
 */
public abstract class TreePreorder<T> implements Iterator<T> {
    private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(TreePreorder.class);
    private final T root;
    private T nowNode;
    private final List<Integer> pathIndex = new ArrayList();
    private final List<T> pathUnit = new ArrayList();

    public TreePreorder(T pRoot) {
        root = pRoot;
        nowNode = null;
    }

    public abstract List<T> children(T parent);
    
    @Override
    public T next() {
        return nowNode;
    }

    @Override
    public boolean hasNext() {
        try {
            if (nowNode == null) {
                nowNode = root; // Root is not in pathInde and pathUnit
                pathIndex.add(0);
                pathUnit.add(nowNode);
                return true;
            } 
            if (this.children(nowNode) != null && !this.children(nowNode).isEmpty()) {
                pathIndex.add(0);
                nowNode = this.children(nowNode).get(0);
                pathUnit.add(nowNode);
                return true;
            } else {
                int j = pathIndex.size() - 1;
                while (true) {
                    int k = pathIndex.get(j);
                    if (k < this.children(pathUnit.get(j - 1)).size() -1) {
                        k++;
                        pathIndex.set(j, k);
                        nowNode = this.children(pathUnit.get(j - 1)).get(k);
                        pathUnit.set(j, nowNode);
                        break;
                    } else {
                        pathIndex.remove(j);
                        pathUnit.remove(j);
                        j--;
                        if (j == 0) {
                            nowNode = null;
                            break;
                        }
                    }
                }
            }
            if ( nowNode == null) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            logger.error("Exception of hasNext()");
            e.printStackTrace();
        }
        return false;
    }
}
