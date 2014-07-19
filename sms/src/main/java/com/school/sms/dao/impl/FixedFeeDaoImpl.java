package com.school.sms.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.sms.dao.FixedFeeDao;
import com.school.sms.model.DiscountsAndConcessions;
import com.school.sms.model.FixedFeeBatchYearMonth;
import com.school.sms.model.GradeMaster;
import com.school.sms.model.VariableFeeBatchYearMonth;


@Service("fixedFeeDaoService")
@Transactional
public class FixedFeeDaoImpl implements FixedFeeDao {
	
	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	public void addFixedFee(FixedFeeBatchYearMonth feeBatchYearMonth){
		
	}
	public void updateFixedFee(FixedFeeBatchYearMonth feeBatchYearMonth){
		entityManager.merge(feeBatchYearMonth);
		entityManager.flush();
	}
	public void deleteFixedFee(Integer fixedFeeId){
		
	}
	public FixedFeeBatchYearMonth findFixedFee(String session,Integer batchId,String month){
		if(entityManager.createQuery("FROM FixedFeeBatchYearMonth f WHERE f.session="+"'"+session+"'"+ " and f.batchId="+"'"+batchId+"'"+" and f.month="+"'"+month+"'").getResultList().size()>0){
			return (FixedFeeBatchYearMonth) entityManager.createQuery("FROM FixedFeeBatchYearMonth f WHERE f.session="+"'"+session+"'"+ " and f.batchId="+"'"+batchId+"'"+" and f.month="+"'"+month+"'").getResultList().get(0);
		}
		return null;
		
		
	}

	@Override
	public List<FixedFeeBatchYearMonth> loadFeeStructures() {
		Query query = entityManager.createQuery("FROM FixedFeeBatchYearMonth f order by f.fixedFeeId ASC");
		return query.getResultList();
	}

	@Override
	public VariableFeeBatchYearMonth findFixedFee(String session, String batch,
			String month, String studentNameClassRoll) {
		List list= entityManager.createQuery("FROM VariableFeeBatchYearMonth f WHERE f.session="+"'"+session+"'"+ " and f.batch="+"'"+batch+"'"+" and f.month="+"'"+month+"'"+" and f.studentNameClassRoll="+"'"+studentNameClassRoll+"'").getResultList();
		if(list.size()>0){
			return (VariableFeeBatchYearMonth) list.get(0);
		}
		return null;
	}

	@Override
	public void updateVariableFee(VariableFeeBatchYearMonth variableFee) {
		entityManager.merge(variableFee);
		entityManager.flush();
		
	}

	@Override
	public List<VariableFeeBatchYearMonth> loadVariableFeeStructures() {
		Query query = entityManager.createQuery("FROM VariableFeeBatchYearMonth f order by f.variableFeeId ASC");
		return query.getResultList();
	}

	@Override
	public DiscountsAndConcessions findDiscountsAndConcession(String session,
			String batch, String month, String studentNameClassRoll) {
		List list= entityManager.createQuery("FROM DiscountsAndConcessions f WHERE f.session="+"'"+session+"'"+ " and f.batch="+"'"+batch+"'"+" and f.month="+"'"+month+"'"+" and f.studentNameClassRoll="+"'"+studentNameClassRoll+"'").getResultList();
		if(list.size()>0){
			return (DiscountsAndConcessions) list.get(0);
		}
		return null;
	}

	@Override
	public void updateDiscountsAndConcession(
			DiscountsAndConcessions discountsAndConcession) {
		entityManager.merge(discountsAndConcession);
		entityManager.flush();
		
	}

	@Override
	public List<DiscountsAndConcessions> loadDiscountsAndConcession() {
		Query query = entityManager.createQuery("FROM DiscountsAndConcessions f order by f.discountsConscessionsId ASC");
		return query.getResultList();
	}

	@Override
	public void deleteVariableFee(VariableFeeBatchYearMonth variableFee) {
		VariableFeeBatchYearMonth variableFeeBatchYearMonth = entityManager.find(VariableFeeBatchYearMonth.class,variableFee.getVariableFeeId());
		entityManager.remove(variableFeeBatchYearMonth);
		entityManager.flush();
		
	}

	@Override
	public void deleteFixedFee(FixedFeeBatchYearMonth fixedFee) {
		FixedFeeBatchYearMonth fixedFeeBatchYearMonth = entityManager.find(FixedFeeBatchYearMonth.class,fixedFee.getFixedFeeId());
		entityManager.remove(fixedFeeBatchYearMonth);
		entityManager.flush();
		
	}
}
