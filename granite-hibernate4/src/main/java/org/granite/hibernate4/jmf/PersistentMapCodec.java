/**
 *   GRANITE DATA SERVICES
 *   Copyright (C) 2006-2013 GRANITE DATA SERVICES S.A.S.
 *
 *   This file is part of Granite Data Services.
 *
 *   Granite Data Services is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU Library General Public License as published by
 *   the Free Software Foundation; either version 2 of the License, or (at your
 *   option) any later version.
 *
 *   Granite Data Services is distributed in the hope that it will be useful, but
 *   WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 *   FITNESS FOR A PARTICULAR PURPOSE. See the GNU Library General Public License
 *   for more details.
 *
 *   You should have received a copy of the GNU Library General Public License
 *   along with this library; if not, see <http://www.gnu.org/licenses/>.
 */
/*
  GRANITE DATA SERVICES
  Copyright (C) 2013 GRANITE DATA SERVICES S.A.S.

  This file is part of Granite Data Services.

  Granite Data Services is free software; you can redistribute it and/or modify
  it under the terms of the GNU Library General Public License as published by
  the Free Software Foundation; either version 2 of the License, or (at your
  option) any later version.

  Granite Data Services is distributed in the hope that it will be useful, but
  WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
  FITNESS FOR A PARTICULAR PURPOSE. See the GNU Library General Public License
  for more details.

  You should have received a copy of the GNU Library General Public License
  along with this library; if not, see <http://www.gnu.org/licenses/>.
*/

package org.granite.hibernate4.jmf;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.granite.messaging.jmf.ExtendedObjectInput;
import org.granite.messaging.jmf.persistence.JMFPersistentCollectionSnapshot;
import org.granite.messaging.persistence.PersistentCollectionSnapshot;
import org.hibernate.collection.internal.PersistentMap;

/**
 * @author Franck WOLFF
 */
public class PersistentMapCodec extends AbstractPersistentCollectionCodec<PersistentMap> {

	public PersistentMapCodec() {
		super(PersistentMap.class);
	}

	public PersistentMap newInstance(ExtendedObjectInput in, String className)
			throws IOException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, InvocationTargetException,
			SecurityException, NoSuchMethodException {
		
		PersistentCollectionSnapshot snapshot = new JMFPersistentCollectionSnapshot(null);
		snapshot.readInitializationData(in);
		return (snapshot.isInitialized() ? new PersistentMap(null, new HashMap<Object, Object>()) : new PersistentMap(null));
	}
}
