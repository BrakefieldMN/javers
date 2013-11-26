package org.javers.core.diff;

import org.javers.model.object.graph.*;
import org.javers.model.visitors.Visitable;
import org.javers.model.visitors.Visitor;

import java.util.HashSet;
import java.util.Set;

/**
 * Flattens given graph into set using Depth-first search approach.
 *
 * @author Maciej Zasada
 */
public class DFSGraphToSetConverter implements GraphToSetConverter {

    @Override
    public Set<ObjectNode> convertFromGraph(ObjectNode graph) {
        DFSGraphTraverser dfsGraphTraverser = new DFSGraphTraverser();
        graph.accept(dfsGraphTraverser);
        return dfsGraphTraverser.visitedNodes;
    }

    private class DFSGraphTraverser implements Visitor {
        private final Set<ObjectNode> visitedNodes = new HashSet<>();

        @Override
        public void visit(Object object) {
            if(object instanceof ObjectNode) {
                visitedNodes.add((ObjectNode) object);
            }
        }
    }
}