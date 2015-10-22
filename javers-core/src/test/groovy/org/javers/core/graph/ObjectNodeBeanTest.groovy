package org.javers.core.graph

import org.javers.core.MappingStyle

import static org.javers.core.JaversTestBuilder.javersTestAssembly

/**
 * @author bartosz walacik
 */
class ObjectNodeBeanTest extends ObjectNodeTest{

    def setup() {
        typeFactory = javersTestAssembly(MappingStyle.BEAN).typeSpawningFactory
    }
}
