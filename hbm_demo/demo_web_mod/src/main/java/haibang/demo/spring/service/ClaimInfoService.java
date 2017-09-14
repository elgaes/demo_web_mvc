package haibang.demo.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import haibang.demo.jpa.Claim;
import haibang.demo.spring.dao.ClaimRepository;
/**
 * This simple serivce class intent to provide all Claim related infomation 
 * management. It access backend data access layer and provides other business logical functions.
 * It should return an intermediate business model object and mapping back and forth between
 * backend model and business model. However this is a simple app with read only let cut the 
 * middleman off.
 * 
 * 
 * @author 		Haibang Mai
 * @version    1.0
 * 
 */

@Service
public class ClaimInfoService
{
	protected ClaimRepository claimRepository;
	
	/**
	 * This method query the entity manager for all the Claim belong to a person who id supplied. 
	 *
	 * @param	personId 	Id of the person where associated claims will be returned. 
	 * @return      		List of Claim entity belong to the person from backend, return
	 * 						empty list if nothing found
	 * 
	 */

	public List<Claim> getPersonClaims(String personId)
	{
		List<Claim> result=this.claimRepository.findByPersonPersonId(personId);
	
		//if nothing found return empty list to avoid null pointer.
		return result==null? new ArrayList<Claim>() : result;
	}
	
	
	/**
	 * This method query the Claim repo for all available Claims. 
	 *
	 * 
	 * @return     All Claims from backend, return	empty list if nothing found
	 * 
	 */
	public List<Claim> getAllClaims()
	{
		List<Claim> result=this.claimRepository.findAll();
		
		//if nothing found return empty list to avoid null pointer.
		return result==null? new ArrayList<Claim>() : result;
	}
	

	public ClaimRepository getClaimRepository()
	{
		return claimRepository;
	}
	
	/**
	 * Spring will autowire in the Claim repo when this service is loaded. 
	 *
	 */
	@Autowired 
	public void setClaimRepository(ClaimRepository claimRepository)
	{
		this.claimRepository = claimRepository;
	}
	
}
