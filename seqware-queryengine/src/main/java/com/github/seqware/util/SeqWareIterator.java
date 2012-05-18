package com.github.seqware.util;

import java.util.Iterator;

/**
 * @author boconnor
 * TODO:
 * - need to make this support generics
 * - need to hide anything from BerkeleyDB
 *
 */
public interface SeqWareIterator<T> extends Iterator<T> {

//	// so the iterator class provides: hasNext(), next(), remove()
//    public void close() throws Exception;
//    public int getCount() throws Exception;
//    // FIXME: is there a way I don't have to expose this?
//    // FIXME: this should be wrapped by a SeqWare object
//    public Cursor getCursor() throws Exception;
//    // FIXME: this is a BerkeleyDB specific method, try to abstract away!
//    public Object nextSecondaryKey() throws UnsupportedEncodingException;
}