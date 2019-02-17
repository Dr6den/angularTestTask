package com.tasklist.hibernate.util;

import java.io.Serializable;

/**
 *
 * @author andrew
 */
public interface Identifiable<T extends Serializable> {
    T getId();
}
