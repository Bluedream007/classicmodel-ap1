package com.bluedream.sales1.dao;

import com.bluedream.sales1.domain.Customers;
import com.bluedream.sales1.domain.Orderdetails;
import com.bluedream.sales1.domain.Orders;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage Orders entities.
 * 
 */
@Repository("OrdersDAO")
@Transactional
public class OrdersDAOImpl extends AbstractJpaDao<Orders> implements OrdersDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Orders.class }));

	/**
	 * EntityManager injected by Spring for persistence unit MySQL_ConnecterJ_5_1_36
	 *
	 */
	@PersistenceContext(unitName = "MySQL_ConnecterJ_5_1_36")
	private EntityManager entityManager;

	/**
	 * Instantiates a new OrdersDAOImpl
	 *
	 */
	public OrdersDAOImpl() {
		super();
	}

	/**
	 * Get the entity manager that manages persistence unit 
	 *
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	/**
	 * JPQL Query - findOrdersByShippedDate
	 *
	 */
	@Transactional
	public Set<Orders> findOrdersByShippedDate(java.util.Calendar shippedDate) throws DataAccessException {

		return findOrdersByShippedDate(shippedDate, -1, -1);
	}

	/**
	 * JPQL Query - findOrdersByShippedDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Orders> findOrdersByShippedDate(java.util.Calendar shippedDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOrdersByShippedDate", startResult, maxRows, shippedDate);
		return new LinkedHashSet<Orders>(query.getResultList());
	}

	/**
	 * JPQL Query - findOrdersByStatusContaining
	 *
	 */
	@Transactional
	public Set<Orders> findOrdersByStatusContaining(String status) throws DataAccessException {

		return findOrdersByStatusContaining(status, -1, -1);
	}

	/**
	 * JPQL Query - findOrdersByStatusContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Orders> findOrdersByStatusContaining(String status, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOrdersByStatusContaining", startResult, maxRows, status);
		return new LinkedHashSet<Orders>(query.getResultList());
	}

	/**
	 * JPQL Query - findOrdersByPrimaryKey
	 *
	 */
	@Transactional
	public Orders findOrdersByPrimaryKey(Integer orderNumber) throws DataAccessException {

		// return findOrdersByPrimaryKey(orderNumber, -1, -1);
		Orders oOrders = findOrdersByPrimaryKey(orderNumber, -1, -1);		
		
		Set<Orderdetails> oOrddetailSet = oOrders.getOrderdetailses();
		System.out.println("the size of oOrddetailSet: " + oOrddetailSet.size());
		
		// oOrddetailSet.iterator()
		for(Orderdetails itemDetail: oOrddetailSet) {
			System.out.println("OrderLineNumber: " + itemDetail.getOrderLineNumber());	
			System.out.println("ProductCode: " + itemDetail.getProductCode());
			System.out.println("OrderNumber: " + itemDetail.getOrderNumber());
		}		
		
		return oOrders;
	}

	/**
	 * JPQL Query - findOrdersByPrimaryKey
	 *
	 */
	@Transactional
	public Orders findOrdersByPrimaryKey(Integer orderNumber, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findOrdersByPrimaryKey", startResult, maxRows, orderNumber);
			return (com.bluedream.sales1.domain.Orders) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}
	
	/**
	 * JPQL Query - findOrdersByOrderDateAfter
	 *
	 */
	@Transactional
	public Set<Orders> findOrdersByOrderDateAfter(java.util.Calendar orderDate) throws DataAccessException {

		return findOrdersByOrderDateAfter(orderDate, -1, -1);
	}

	/**
	 * JPQL Query - findOrdersByOrderDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Orders> findOrdersByOrderDateAfter(java.util.Calendar orderDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOrdersByOrderDateAfter", startResult, maxRows, orderDate);
		return new LinkedHashSet<Orders>(query.getResultList());
	}

	/**
	 * JPQL Query - findOrdersByShippedDateBefore
	 *
	 */
	@Transactional
	public Set<Orders> findOrdersByShippedDateBefore(java.util.Calendar shippedDate) throws DataAccessException {

		return findOrdersByShippedDateBefore(shippedDate, -1, -1);
	}

	/**
	 * JPQL Query - findOrdersByShippedDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Orders> findOrdersByShippedDateBefore(java.util.Calendar shippedDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOrdersByShippedDateBefore", startResult, maxRows, shippedDate);
		return new LinkedHashSet<Orders>(query.getResultList());
	}

	/**
	 * JPQL Query - findOrdersByComments
	 *
	 */
	@Transactional
	public Set<Orders> findOrdersByComments(String comments) throws DataAccessException {

		return findOrdersByComments(comments, -1, -1);
	}

	/**
	 * JPQL Query - findOrdersByComments
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Orders> findOrdersByComments(String comments, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOrdersByComments", startResult, maxRows, comments);
		return new LinkedHashSet<Orders>(query.getResultList());
	}

	/**
	 * JPQL Query - findOrdersByShippedDateAfter
	 *
	 */
	@Transactional
	public Set<Orders> findOrdersByShippedDateAfter(java.util.Calendar shippedDate) throws DataAccessException {

		return findOrdersByShippedDateAfter(shippedDate, -1, -1);
	}

	/**
	 * JPQL Query - findOrdersByShippedDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Orders> findOrdersByShippedDateAfter(java.util.Calendar shippedDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOrdersByShippedDateAfter", startResult, maxRows, shippedDate);
		return new LinkedHashSet<Orders>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllOrderss
	 *
	 */
	@Transactional
	public Set<Orders> findAllOrderss() throws DataAccessException {

		return findAllOrderss(-1, -1);
	}

	/**
	 * JPQL Query - findAllOrderss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Orders> findAllOrderss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllOrderss", startResult, maxRows);
		return new LinkedHashSet<Orders>(query.getResultList());
	}

	/**
	 * JPQL Query - findOrdersByStatus
	 *
	 */
	@Transactional
	public Set<Orders> findOrdersByStatus(String status) throws DataAccessException {

		return findOrdersByStatus(status, -1, -1);
	}

	/**
	 * JPQL Query - findOrdersByStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Orders> findOrdersByStatus(String status, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOrdersByStatus", startResult, maxRows, status);
		return new LinkedHashSet<Orders>(query.getResultList());
	}

	/**
	 * JPQL Query - findOrdersByOrderDateBefore
	 *
	 */
	@Transactional
	public Set<Orders> findOrdersByOrderDateBefore(java.util.Calendar orderDate) throws DataAccessException {

		return findOrdersByOrderDateBefore(orderDate, -1, -1);
	}

	/**
	 * JPQL Query - findOrdersByOrderDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Orders> findOrdersByOrderDateBefore(java.util.Calendar orderDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOrdersByOrderDateBefore", startResult, maxRows, orderDate);
		return new LinkedHashSet<Orders>(query.getResultList());
	}

	/**
	 * JPQL Query - findOrdersByRequiredDate
	 *
	 */
	@Transactional
	public Set<Orders> findOrdersByRequiredDate(java.util.Calendar requiredDate) throws DataAccessException {

		return findOrdersByRequiredDate(requiredDate, -1, -1);
	}

	/**
	 * JPQL Query - findOrdersByRequiredDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Orders> findOrdersByRequiredDate(java.util.Calendar requiredDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOrdersByRequiredDate", startResult, maxRows, requiredDate);
		return new LinkedHashSet<Orders>(query.getResultList());
	}

	/**
	 * JPQL Query - findOrdersByOrderNumber
	 *
	 */
	@Transactional
	public Orders findOrdersByOrderNumber(Integer orderNumber) throws DataAccessException {

		return findOrdersByOrderNumber(orderNumber, -1, -1);
	}

	/**
	 * JPQL Query - findOrdersByOrderNumber
	 *
	 */

	@Transactional
	public Orders findOrdersByOrderNumber(Integer orderNumber, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findOrdersByOrderNumber", startResult, maxRows, orderNumber);
			return (com.bluedream.sales1.domain.Orders) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findOrdersByOrderDate
	 *
	 */
	@Transactional
	public Set<Orders> findOrdersByOrderDate(java.util.Calendar orderDate) throws DataAccessException {

		return findOrdersByOrderDate(orderDate, -1, -1);
	}

	/**
	 * JPQL Query - findOrdersByOrderDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Orders> findOrdersByOrderDate(java.util.Calendar orderDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOrdersByOrderDate", startResult, maxRows, orderDate);
		return new LinkedHashSet<Orders>(query.getResultList());
	}

	/**
	 * JPQL Query - findOrdersByRequiredDateAfter
	 *
	 */
	@Transactional
	public Set<Orders> findOrdersByRequiredDateAfter(java.util.Calendar requiredDate) throws DataAccessException {

		return findOrdersByRequiredDateAfter(requiredDate, -1, -1);
	}

	/**
	 * JPQL Query - findOrdersByRequiredDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Orders> findOrdersByRequiredDateAfter(java.util.Calendar requiredDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOrdersByRequiredDateAfter", startResult, maxRows, requiredDate);
		return new LinkedHashSet<Orders>(query.getResultList());
	}

	/**
	 * JPQL Query - findOrdersByRequiredDateBefore
	 *
	 */
	@Transactional
	public Set<Orders> findOrdersByRequiredDateBefore(java.util.Calendar requiredDate) throws DataAccessException {

		return findOrdersByRequiredDateBefore(requiredDate, -1, -1);
	}

	/**
	 * JPQL Query - findOrdersByRequiredDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Orders> findOrdersByRequiredDateBefore(java.util.Calendar requiredDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOrdersByRequiredDateBefore", startResult, maxRows, requiredDate);
		return new LinkedHashSet<Orders>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Orders entity) {
		return true;
	}
	
	// * MyFunxtion ================================================================================= *
	/**
	 * JPQL Query - fetch OrdersDetails By Orders PrimaryKey
	 *
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Orderdetails> fetchOrdetailsByPKeyJoin(Integer orderNumber, int startResult, int maxRows) throws DataAccessException {
		
		try {
			/*
			String strJoinFetchQry = "select o.orderNumber, o.customerNumber, o1" +
                                     " FROM orders o JOIN orderdetails o1 ON o.orderNumber = o1.orderNumber" +
					                 " WHERE o.orderNumber = ?1";
			*/
			String strJoinFetchQry = "select od " + 
                                     "from Orderdetails od, Orders o " +
                                     "where o.orderNumber = od.orderNumber " +
                                     "  and od.orderNumber = ?1";
			
			 Query query = entityManager.createQuery(strJoinFetchQry);
			 query.setParameter("1", orderNumber);		 
			
			 return new LinkedHashSet<Orderdetails>(query.getResultList());
		} catch (NoResultException nre) {
			return null;
		}
	}
	
	/**
	 * JPQL Query - fetch Orders By Customers PrimaryKey
	 *
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Orders> fetchOrderByCustPKeyJoin(Integer customerNumber, int startResult, int maxRows) throws DataAccessException {
		try {
			String strJoinFetchQry = "select myOrders " + 
                                     "from Orders myOrders " + 
                                     "where myOrders.customers.customerNumber = ?1";

            Query query = entityManager.createQuery(strJoinFetchQry);
            query.setParameter("1", customerNumber);		 

            return new LinkedHashSet<Orders>(query.getResultList());
			
		} catch (NoResultException nre) {
			return null;
		}
	
	}
	
	// * MyFunxtion End ================================================================================= *
}
