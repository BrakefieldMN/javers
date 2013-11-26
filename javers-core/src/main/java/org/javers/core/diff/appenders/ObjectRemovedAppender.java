package org.javers.core.diff.appenders;

import java.util.Set;

import org.javers.common.collections.Function;
import org.javers.common.collections.Sets;
import org.javers.model.domain.Change;
import org.javers.model.domain.Diff;
import org.javers.model.domain.changeType.ObjectRemoved;
import org.javers.model.object.graph.ObjectNode;

public class ObjectRemovedAppender extends ChangeSetAppender {

  @Override
  public Set<Change> getChangeSet(Set<ObjectNode> leftGraph, Set<ObjectNode> rightGraph) {
    Set<ObjectNode> removedObjectNodes = Sets.difference(leftGraph, rightGraph);
    return Sets.transform(removedObjectNodes, new Function<ObjectNode, Change>() {
      @Override
      public ObjectRemoved apply(ObjectNode input) {
        return new ObjectRemoved(input.getGlobalCdoId());
      }
    });
  }
}