/*
 * The contents of this file are subject to the terms 
 * of the Common Development and Distribution License 
 * (the License).  You may not use this file except in
 * compliance with the License.
 * 
 * You can obtain a copy of the license at 
 * https://glassfish.dev.java.net/public/CDDLv1.0.html or
 * glassfish/bootstrap/legal/CDDLv1.0.txt.
 * See the License for the specific language governing 
 * permissions and limitations under the License.
 * 
 * When distributing Covered Code, include this CDDL 
 * Header Notice in each file and include the License file 
 * at glassfish/bootstrap/legal/CDDLv1.0.txt.  
 * If applicable, add the following below the CDDL Header, 
 * with the fields enclosed by brackets [] replaced by
 * you own identifying information: 
 * "Portions Copyrighted [year] [name of copyright owner]"
 * 
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 */
package javax.persistence;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static javax.persistence.FetchType.EAGER;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * The <code>Basic</code> annotation is the simplest type of mapping 
 * to a database column. The <code>Basic</code> annotation can be 
 * applied to a persistent property or instance variable of any of the 
 * following types: Java primitive types, wrappers of the primitive types, 
 * {@link String}, {@link java.math.BigInteger java.math.BigInteger}, 
 * {@link java.math.BigDecimal java.math.BigDecimal}, 
 * {@link java.util.Date java.util.Date}, 
 * {@link java.util.Calendar java.util.Calendar}, 
 * {@link java.sql.Date java.sql.Date}, {@link java.sql.Time java.sql.Time}, 
 * {@link java.sql.Timestamp java.sql.Timestamp}, <code>byte[], Byte[], 
 * char[], Character[]</code>, enums, and any other type that implements 
 * {@link java.io.Serializable Serializable}. 
 * 
 * <p> The use of the <code>Basic</code> annotation is optional for 
 * persistent fields and properties of these types.
 *
 * @since Java Persistence 1.0
 */
@Target({METHOD, FIELD}) 
@Retention(RUNTIME)
public @interface Basic {

    /**
     * (Optional) Defines whether the value of the field or property should 
     * be lazily loaded or must be eagerly fetched. The <code>EAGER</code> 
     * strategy is a requirement on the persistence provider runtime 
     * that the value must be eagerly fetched.  The <code>LAZY</code> 
     * strategy is a hint to the persistence provider runtime.
     * If not specified, defaults to <code>EAGER</code>.
     */
    FetchType fetch() default EAGER;

    /**
     * (Optional) Defines whether the value of the field or property may be null. 
     * This is a hint and is disregarded for primitive types; it may 
     * be used in schema generation.
     * If not specified, defaults to <code>true</code>.
     */
    boolean optional() default true;
}
