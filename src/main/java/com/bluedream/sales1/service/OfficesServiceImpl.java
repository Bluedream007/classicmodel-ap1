package com.bluedream.sales1.service;

import com.bluedream.sales1.dao.EmployeesDAO;
import com.bluedream.sales1.dao.OfficesDAO;

import com.bluedream.sales1.domain.Employees;
import com.bluedream.sales1.domain.Offices;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Offices entities
 * 
 */

@Service("OfficesService")
@Transactional
public class OfficesServiceImpl implements OfficesService {

	/**
	 * DAO injected by Spring that manages Employees entities
	 * 
	 */
	@Autowired
	private EmployeesDAO employeesDAO;

	/**
	 * DAO injected by Spring that manages Offices entities
	 * 
	 */
	@Autowired
	private OfficesDAO officesDAO;

	/**
	 * Instantiates a new OfficesServiceImpl.
	 *
	 */
	public OfficesServiceImpl() {
	}

	/**
	 * Return a count of all Offices entity
	 * 
	 */
	@Transactional
	public Integer countOfficess() {
		return ((Long) officesDAO.createQuerySingleResult("select count(o) from Offices o").getSingleResult()).intValue();
	}

	/**
	 * Return all Offices entity
	 * 
	 */
	@Transactional
	public List<Offices> findAllOfficess(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Offices>(officesDAO.findAllOfficess(startResult, maxRows));
	}

	/**
	 * Delete an existing Offices entity
	 * 
	 */
	@Transactional
	public void deleteOffices(Offices offices) {
		officesDAO.remove(offices);
		officesDAO.flush();
	}

	/**
	 * Save an existing Offices entity
	 * 
	 */
	@Transactional
	public void saveOffices(Offices offices) {
		Offices existingOffices = officesDAO.findOfficesByPrimaryKey(offices.getOfficeCode());

		if (existingOffices != null) {
			if (existingOffices != offices) {
				existingOffices.setOfficeCode(offices.getOfficeCode());
				existingOffices.setCity(offices.getCity());
				existingOffices.setPhone(offices.getPhone());
				existingOffices.setAddressLine1(offices.getAddressLine1());
				existingOffices.setAddressLine2(offices.getAddressLine2());
				existingOffices.setState(offices.getState());
				existingOffices.setCountry(offices.getCountry());
				existingOffices.setPostalCode(offices.getPostalCode());
				existingOffices.setTerritory(offices.getTerritory());
			}
			offices = officesDAO.store(existingOffices);
		} else {
			offices = officesDAO.store(offices);
		}
		officesDAO.flush();
	}

	/**
	 * Load an existing Offices entity
	 * 
	 */
	@Transactional
	public Set<Offices> loadOfficess() {
		return officesDAO.findAllOfficess();
	}

	/**
	 */
	@Transactional
	public Offices findOfficesByPrimaryKey(String officeCode) {
		return officesDAO.findOfficesByPrimaryKey(officeCode);
	}

	/**
	 * Delete an existing Employees entity
	 * 
	 */
	@Transactional
	public Offices deleteOfficesEmployeeses(String offices_officeCode, Integer related_employeeses_employeeNumber) {
		Employees related_employeeses = employeesDAO.findEmployeesByPrimaryKey(related_employeeses_employeeNumber, -1, -1);

		Offices offices = officesDAO.findOfficesByPrimaryKey(offices_officeCode, -1, -1);

		related_employeeses.setOffices(null);
		offices.getEmployeeses().remove(related_employeeses);

		employeesDAO.remove(related_employeeses);
		employeesDAO.flush();

		return offices;
	}

	/**
	 * Save an existing Employees entity
	 * 
	 */
	@Transactional
	public Offices saveOfficesEmployeeses(String officeCode, Employees related_employeeses) {
		Offices offices = officesDAO.findOfficesByPrimaryKey(officeCode, -1, -1);
		Employees existingemployeeses = employeesDAO.findEmployeesByPrimaryKey(related_employeeses.getEmployeeNumber());

		// copy into the existing record to preserve existing relationships
		if (existingemployeeses != null) {
			existingemployeeses.setEmployeeNumber(related_employeeses.getEmployeeNumber());
			existingemployeeses.setLastName(related_employeeses.getLastName());
			existingemployeeses.setFirstName(related_employeeses.getFirstName());
			existingemployeeses.setExtension(related_employeeses.getExtension());
			existingemployeeses.setEmail(related_employeeses.getEmail());
			existingemployeeses.setJobTitle(related_employeeses.getJobTitle());
			related_employeeses = existingemployeeses;
		}

		related_employeeses.setOffices(offices);
		offices.getEmployeeses().add(related_employeeses);
		related_employeeses = employeesDAO.store(related_employeeses);
		employeesDAO.flush();

		offices = officesDAO.store(offices);
		officesDAO.flush();

		return offices;
	}
}
