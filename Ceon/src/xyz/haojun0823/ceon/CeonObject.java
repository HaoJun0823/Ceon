/**   
 * MIT License
 * 
 * Copyright (c) 2020 HaoJun Yang
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 * 
 * @Title: CeonObject.java 
 * @Project: Ceon
 * @Package: xyz.haojun0823.ceon 
 * @author: HaoJun0823   
 * @date: Feb 13, 2020 1:02:07 AM 
 * @version: V1.0   
 */
package xyz.haojun0823.ceon;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @ClassName: CeonObject
 * @Description: Used to store data.
 * @author: HaoJun0823
 * @date: Feb 13, 2020 1:02:07 AM
 */
public class CeonObject implements Serializable, Iterable<Entry<String, CeonData>>, Cloneable {

	private static final long serialVersionUID = -1042584082623252728L;

	private Map<String, CeonData> map;

	public CeonObject() {

		this.map = new LinkedHashMap<String, CeonData>();

	}

	public void put(String key, Long value) {

		map.put(key, new CeonData(value));
	}

	public void put(String key, Integer value) {
		this.put(key, value.longValue());
	}

	public void put(String key, Byte value) {
		this.put(key, value.longValue());
	}

	public void put(String key, Short value) {
		this.put(key, value.longValue());
	}

	public void put(String key, Double value) {

		map.put(key, new CeonData(value));

	}

	public void put(String key, Float value) {

		this.put(key, value.doubleValue());

	}

	public void put(String key, String value) {

		map.put(key, new CeonData(value));

	}

	public void put(String key, Character value) {

		this.put(key, value.toString());

	}

	public void put(String key, Boolean value) {

		map.put(key, new CeonData(value));

	}

	public void put(String key, Long[] value) {

		map.put(key, new CeonData(value));
	}

	public void put(String key, Integer[] value) {
		Long[] arr = new Long[value.length];
		for (int i = 0; i < value.length; i++) {
			arr[i] = value[i].longValue();
		}
		this.put(key, arr);
	}

	public void put(String key, Byte[] value) {
		Long[] arr = new Long[value.length];
		for (int i = 0; i < value.length; i++) {
			arr[i] = value[i].longValue();
		}
		this.put(key, arr);
	}

	public void put(String key, Short[] value) {
		Long[] arr = new Long[value.length];
		for (int i = 0; i < value.length; i++) {
			arr[i] = value[i].longValue();
		}
		this.put(key, arr);
	}

	public void put(String key, Double[] value) {

		map.put(key, new CeonData(value));

	}

	public void put(String key, Float[] value) {

		Double[] arr = new Double[value.length];
		for (int i = 0; i < value.length; i++) {
			arr[i] = value[i].doubleValue();
		}
		this.put(key, arr);

	}

	public void put(String key, String[] value) {

		map.put(key, new CeonData(value));

	}

	public void put(String key, Character[] value) {

		this.put(key, String.valueOf(value));

	}

	public void put(String key, Boolean[] value) {

		map.put(key, new CeonData(value));

	}

	public void put(String key, CeonObject value) {

		Entry<String, CeonData> entry = findObject(this, value);

		if (entry != null) {
			try {
				throw new CeonParseException(String.format(
						"CeonObject with key %s already exists in this CeonObject with key %s, this behavior has been revoked, because multiple nesting of the same object is not allowed!",
						key, entry.getKey()));
			} catch (CeonParseException e) {
				e.printStackTrace();
			}
		} else {
			map.put(key, new CeonData(value));
		}
	}

	public void put(String key, CeonObject[] value) {

		for (CeonObject obj : value) {
			Entry<String, CeonData> entry = findObject(this, obj);

			if (entry != null) {
				try {
					throw new CeonParseException(String.format(
							"CeonObject[] with key %s's child already exists in this CeonObject with key %s, this behavior has been revoked, because multiple nesting of the same object is not allowed!",
							key, entry.getKey()));
				} catch (CeonParseException e) {
					e.printStackTrace();
				}
			} else {
				map.put(key, new CeonData(value));
			}
		}
	}

	public CeonData get(String key) {

		return map.get(key);
	}

	@Override
	public Iterator<Entry<String, CeonData>> iterator() {
		// TODO Auto-generated method stub
		return this.map.entrySet().iterator();
	}

	public String toString() {

		try {
			return convert(this, 0, false);
		} catch (CeonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static CeonObject convert(String text) throws CeonParseException {
		CeonObject result = new CeonObject();
		text = clearText(text);
		
		int cursor = 0;
		boolean hasKey = false;
		String key;
		
		
		while(cursor<text.length()) {
			
			char c = text.charAt(cursor);
			
			if(!hasKey&&text.charAt(cursor+1)=='-') {
				
			}
			
			
			
			
			
			
		}
		
		

		return result;
	}


	public static String clearText(String text) {

		StringBuilder strBuild = new StringBuilder();

		for (char c : text.toCharArray()) {

			if (c != '\t' && c != '\n') {
				strBuild.append(c);
			}

		}

		return strBuild.toString();

	}

	private static String convert(CeonObject ceon, int deep, boolean childObj) throws CeonParseException {

		Iterator<Entry<String, CeonData>> iterator = ceon.iterator();
		StringBuffer strBuff = new StringBuffer();
		int count = 0;
		boolean isLeaf = true;
		while (iterator.hasNext()) {
			Entry<String, CeonData> entry = iterator.next();
			String key = entry.getKey();
			CeonData value = entry.getValue();
			CeonType type = value.getType();

			if (count == 0 && deep != 0) {
				strBuff.append('\n');
			}

			for (int i = 0; i < deep; i++) {
				strBuff.append('\t');
			}

			strBuff.append(type.getToken());
			strBuff.append('-');

			strBuff.append(key);
			strBuff.append('=');

			if (value.isArray()) {

				strBuff.append('[');
				if (type.equals(CeonType.INTEGER_ARRAY)) {

					Long[] arr = (Long[]) value.get();

					for (int i = 0; i < arr.length - 1; i++) {
						strBuff.append(arr[i]);
						strBuff.append(',');
					}
					strBuff.append(arr[arr.length - 1]);

				} else

				if (type.equals(CeonType.FLOAT_ARRAY)) {

					Double[] arr = (Double[]) value.get();

					for (int i = 0; i < arr.length - 1; i++) {
						strBuff.append(arr[i]);
						strBuff.append(',');
					}
					strBuff.append(arr[arr.length - 1]);

				} else

				if (type.equals(CeonType.BOOL_ARRAY)) {

					Boolean[] arr = (Boolean[]) value.get();

					for (int i = 0; i < arr.length - 1; i++) {
						strBuff.append(arr[i]);
						strBuff.append(',');
					}
					strBuff.append(arr[arr.length - 1]);

				} else if (type.equals(CeonType.STRING_ARRAY)) {

					String[] arr = (String[]) value.get();

					for (int i = 0; i < arr.length - 1; i++) {
						strBuff.append('\'');
						strBuff.append(arr[i]);
						strBuff.append('\'');
						strBuff.append(',');
					}
					strBuff.append('\'');
					strBuff.append(arr[arr.length - 1]);
					strBuff.append('\'');

				} else if (type.equals(CeonType.OBJECT_ARRAY)) {
					isLeaf = false;
					CeonObject[] arr = (CeonObject[]) value.get();

					for (int i = 0; i < arr.length - 1; i++) {
						strBuff.append(convert(arr[i], deep + 1, true));
						strBuff.append(',');
					}
					strBuff.append(convert(arr[arr.length - 1], deep + 1, true));

				} else {

					throw new CeonParseException();

				}
				strBuff.append(']');

			} else

			if (type.equals(CeonType.INTEGER)) {

				strBuff.append((Long) value.get());

			} else

			if (type.equals(CeonType.FLOAT)) {

				strBuff.append((Double) value.get());

			} else

			if (type.equals(CeonType.BOOL)) {

				strBuff.append((Boolean) value.get());

			} else if (type.equals(CeonType.STRING)) {

				strBuff.append('\'');
				strBuff.append((String) value.get());
				strBuff.append('\'');

			} else if (type.equals(CeonType.OBJECT)) {
				isLeaf = false;
				strBuff.append(convert((CeonObject) value.get(), deep + 1, true));

			} else {
				throw new CeonParseException();
			}
			if (iterator.hasNext()) {
				if (!isLeaf) {
					for (int i = 0; i < deep; i++) {
						strBuff.append('\t');
					}
				}
				strBuff.append(',');
			} else {
				if (!isLeaf) {
					for (int i = 0; i < deep; i++) {
						strBuff.append('\t');
					}
				}
				if (!iterator.hasNext()) {
					strBuff.append(';');
				}
			}
			strBuff.append('\n');
			count++;

		}

		return strBuff.toString();

	}

	public static Entry<String, CeonData> findObject(CeonObject obj, CeonObject target) {
		Entry<String, CeonData> result = null;

		Iterator<Entry<String, CeonData>> iterator = obj.map.entrySet().iterator();

		while (iterator.hasNext()) {

			Entry<String, CeonData> entry = iterator.next();

			if (entry.getValue().get() instanceof CeonObject) {

				if (entry.getValue().get().equals(target)) {
					result = entry;
				} else {
					result = findObject((CeonObject) entry.getValue().get(), target);
				}

			}

		}

		return result;

	}

	public boolean objectIsExists(CeonObject target) {

		return findObject(this, target) != null;
	}

	public boolean checkKeyVaild(String key) {

		return true;
	}

}
