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

package org.granite.tide.spring.data;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;


public class FilterSpecUtil {

	public static Predicate buildPredicate(Path<?> root, CriteriaBuilder builder, Class<?> type, String key, Object value) {
		if (value == null)
			return null;
		
		if (type == null)
			type = value.getClass();
		
		if (type == String.class && value.toString().trim().length() == 0)
			return null;
		
		if (value instanceof String)
			return builder.like(root.get(key).as(String.class), "%" + value + "%");
		
		return builder.equal(root.get(key).as(type), value);
	}
}
