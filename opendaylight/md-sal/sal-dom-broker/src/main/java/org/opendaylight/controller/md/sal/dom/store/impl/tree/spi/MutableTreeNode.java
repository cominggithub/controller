/*
 * Copyright (c) 2014 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.controller.md.sal.dom.store.impl.tree.spi;

import org.opendaylight.controller.md.sal.dom.store.impl.tree.StoreTreeNode;
import org.opendaylight.yangtools.yang.data.api.InstanceIdentifier.PathArgument;
import org.opendaylight.yangtools.yang.data.api.schema.NormalizedNode;

/**
 * A mutable tree node. This is a transient view materialized from a pre-existing
 * node. Modifications are isolated. Once this object is {@link #seal()}-ed,
 * any interactions with it will result in undefined behavior.
 */
public interface MutableTreeNode extends StoreTreeNode<TreeNode> {
    void setData(NormalizedNode<?, ?> data);
    void setSubtreeVersion(Version subtreeVersion);
    void addChild(TreeNode child);
    void removeChild(PathArgument id);
    TreeNode seal();
}