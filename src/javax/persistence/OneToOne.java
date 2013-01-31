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
 * This annotation defines a single-valued association to 
 * another entity that has one-to-one multiplicity. It is not 
 * normally necessary to specify the associated target entity 
 * explicitly since it can usually be inferred from the type 
 * of the object being referenced.
 *
 * <pre>
 *    Example 1: One-to-one association that maps a foreign key column
 *
 *    On Customer class:
 *
 *    &#064;OneToOne(optional=false)
 *    &#064;JoinColumn(
 *    	name="CUSTREC_ID", unique=true, nullable=false, updatable=false)
 *    public CustomerRecord getCustomerRecord() { return customerRecord; }
 *
 *    On CustomerRecord class:
 *
 *    &#064;OneToOne(optional=false, mappedBy="customerRecord")
 *    public Customer getCustomer() { return customer; }
 *
 *    Example 2: One-to-one association that assumes both the source and target share the same primary key values. 
 *
 *    On Employee class:
 *
 *    &#064;Entity
 *    public class Employee {
 *    	&#064;Id Integer id;
 *    
 *    	&#064;OneToOne &#064;PrimaryKeyJoinColumn
 *    	EmployeeInfo info;
 *    	...
 *    }
 *
 *    On EmployeeInfo class:
 *
 *    &#064;Entity
 *    public class EmployeeInfo {
 *    	&#064;Id Integer id;
 *    	...
 *    }
 * </pre>
 *
 * @since Java Persistence 1.0
 */
@Target({METHOD, FIELD}) 
@Retention(RUNTIME)

public @interface OneToOne {

    /** 
     * (Optional) The entity class that is the target of 
     * the association. 
     *
     * <p> Defaults to the type of the field or property 
     * that stores the association. 
     */
    Class targetEntity() default void.class;

    /**
     * (Optional) The operations that must be cascaded to 
     * the target of the association.
     *
     * <p> By default no operations are cascaded.
     */
    CascadeType[] cascade() default {};

    /** 
     * (Optional) Whether the association should be lazily 
     * loaded or must be eagerly fetched. The {@link FetchType#EAGER EAGER} 
     * strategy is a requirement on the persistence provider runtime that 
     * the associated entity must be eagerly fetched. The {@link FetchType#LAZY 
     * LAZY} strategy is a hint to the persistence provider runtime.
     */
    FetchType fetch() default EAGER;

    /** 
     * (Optional) Whether the association is optional. If set 
     * to false then a non-null relationship must always exist.
     */
    boolean optional() default true;

    /** (Optional) The field that owns the relationship. This 
      * element is only specified on the inverse (non-owning) 
      * side of the association.
     */
    String mappedBy() default "";
}
