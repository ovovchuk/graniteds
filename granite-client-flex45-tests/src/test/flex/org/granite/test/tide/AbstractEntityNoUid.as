/*
 *   GRANITE DATA SERVICES
 *   Copyright (C) 2006-2015 GRANITE DATA SERVICES S.A.S.
 *
 *   This file is part of the Granite Data Services Platform.
 *
 *   Granite Data Services is free software; you can redistribute it and/or
 *   modify it under the terms of the GNU Lesser General Public
 *   License as published by the Free Software Foundation; either
 *   version 2.1 of the License, or (at your option) any later version.
 *
 *   Granite Data Services is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser
 *   General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public
 *   License along with this library; if not, write to the Free Software
 *   Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301,
 *   USA, or see <http://www.gnu.org/licenses/>.
 */
/**
 * Generated by Gas3 v1.1.0 (Granite Data Services) on Sat Jul 26 17:58:20 CEST 2008.
 *
 * WARNING: DO NOT CHANGE THIS FILE. IT MAY BE OVERRIDDEN EACH TIME YOU USE
 * THE GENERATOR. CHANGE INSTEAD THE INHERITED CLASS (AbstractEntity.as).
 */

package org.granite.test.tide {

    import avmplus.getQualifiedClassName;
    
    import flash.utils.IDataInput;
    import flash.utils.IDataOutput;
    import flash.utils.IExternalizable;
    
    import mx.utils.UIDUtil;
    
    import org.granite.collections.IPersistentCollection;
    import org.granite.meta;
    import org.granite.ns.tide;
    import org.granite.tide.IEntityManager;
    import org.granite.tide.IPropertyHolder;

    use namespace meta;
    use namespace tide;


    [Managed]
    public class AbstractEntityNoUid implements IExternalizable {

		[Transient]
        meta var entityManager:IEntityManager = null;

        private var __initialized:Boolean = true;
        private var __detachedState:String = null;

        private var _id:Number;
        private var _uid:String;
		
		
		public function AbstractEntityNoUid(id:Number = NaN):void {
			if (!isNaN(id)) {
				_id = id;
				uid;
			}
		}
		

        meta function isInitialized(name:String = null):Boolean {
            if (!name)
                return __initialized;

            var property:* = this[name];
            return (
                (!(property is AbstractEntity) || (property as AbstractEntity).meta::isInitialized()) &&
                (!(property is IPersistentCollection) || (property as IPersistentCollection).isInitialized())
            );
        }
        // Used only for testing
        meta function setInitialized(init:Boolean):void {
        	__initialized = init;
        }
		meta function defineProxy3(obj:* = null):Boolean {
			if (obj != null) {
				var src:AbstractEntityNoUid = AbstractEntityNoUid(obj);
				if (src.__detachedState == null)
					return false;
				_id = src._id;
				__detachedState = src.__detachedState;
			}
			__initialized = false;
			return true;
		}

		[Id]
        public function get id():Number {
            return _id;
        }
        
        // Used only for testing
        public function set id(value:Number):void {
            _id = value;
        }

        public function set uid(value:String):void {
        }
        public function get uid():String {
			if (isNaN(_id))
				return UIDUtil.createUID();
			return getQualifiedClassName(this) + "#[" + String(_id) + "]";
        }
		

        meta function merge(em:IEntityManager, obj:*):void {
            var src:AbstractEntityNoUid = AbstractEntityNoUid(obj);
            __initialized = src.__initialized;
            __detachedState = src.__detachedState;
            if (meta::isInitialized()) {
	            em.meta_mergeExternal(src._id, _id, null, this, 'id', function setter(o:*):void{_id = o as Number});
            }
            else {
               	em.meta_mergeExternal(src._id, _id, null, this, 'id', function setter(o:*):void{_id = o as Number});
            }
        }

        public function readExternal(input:IDataInput):void {
            __initialized = input.readObject() as Boolean;
            __detachedState = input.readObject() as String;
            if (meta::isInitialized()) {
                _id = function(o:*):Number { return (o is Number ? o as Number : Number.NaN) } (input.readObject());
            }
            else {
                _id = function(o:*):Number { return (o is Number ? o as Number : Number.NaN) } (input.readObject());
            }
        }

        public function writeExternal(output:IDataOutput):void {
            output.writeObject(__initialized);
            output.writeObject(__detachedState);
            if (meta::isInitialized()) {
                output.writeObject((_id is IPropertyHolder) ? IPropertyHolder(_id).object : _id);
            }
            else {
                output.writeObject(_id);
            }
        }
        
        [Bindable(event="dirtyChange")]
        public function get meta_dirty():Boolean {
        	return entityManager ? entityManager.meta_isEntityChanged(this) : true;
        }
    }
}
